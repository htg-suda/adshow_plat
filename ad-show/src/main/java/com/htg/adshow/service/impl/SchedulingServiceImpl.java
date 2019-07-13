package com.htg.adshow.service.impl;

import com.htg.adshow.constant.ScheduleConst;
import com.htg.adshow.service.IDeviceService;
import com.htg.adshow.service.ISchedulingDeviceRelService;
import com.htg.adshow.service.ISchedulingShowRelService;
import com.htg.common.constant.Del_FLAG;
import com.htg.common.dto.adshow.DevInScheduleDTO;
import com.htg.common.dto.adshow.ReleaseScheduleDTO;
import com.htg.common.dto.adshow.ScheduleAddDTO;
import com.htg.common.dto.adshow.ShowInScheduleDTO;
import com.htg.common.entity.adshow.Device;
import com.htg.common.entity.adshow.Scheduling;
import com.htg.adshow.mapper.SchedulingMapper;
import com.htg.adshow.service.ISchedulingService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.htg.common.entity.adshow.SchedulingDeviceRel;
import com.htg.common.entity.adshow.SchedulingShowRel;
import com.htg.common.exception.GlobalException;
import com.htg.common.result.CodeEnum;
import com.htg.common.result.CommonResult;
import com.htg.common.result.RespId;
import com.htg.common.result.RespList;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.security.action.GetLongAction;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 节目排期表 服务实现类
 * </p>
 *
 * @author htg
 * @since 2019-07-02
 */
@Slf4j
@Service
public class SchedulingServiceImpl extends ServiceImpl<SchedulingMapper, Scheduling> implements ISchedulingService {

    @Autowired
    private ISchedulingShowRelService schedulingShowRelService;

    @Autowired
    private IDeviceService deviceService;

    @Autowired
    private ISchedulingDeviceRelService schedulingDeviceRelService;

    @Autowired
    private MSGServiceImpl msgService;

    @Override
    public CommonResult<RespId> addSchedule(ScheduleAddDTO addDTO) {
        Long startTime = addDTO.getStartTime();
        Long endTime = addDTO.getEndTime();
        Long downloadTime = addDTO.getDownloadTime();

        DateTime startDateTime = new DateTime(startTime);
        DateTime endDateTime = new DateTime(endTime);
        DateTime downloadDateTime = new DateTime(downloadTime);
        /* 时间检测*/
        if (startDateTime.isBeforeNow()) throw new GlobalException(CodeEnum.START_TIME_SHOULD_AFTER_NOW);
        if (endDateTime.isBeforeNow()) throw new GlobalException(CodeEnum.END_TIME_SHOULD_AFTER_NOW);
        if (downloadDateTime.isBeforeNow()) throw new GlobalException(CodeEnum.DOWNLOAD_TIME_SHOULD_AFTER_NOW);

        if (startDateTime.isAfter(endDateTime)) throw new GlobalException(CodeEnum.START_TIME_SHOULD_BEFORE_END_TIME);
        if (downloadDateTime.isAfter(startDateTime))
            throw new GlobalException(CodeEnum.DOWNLOAD_TIME_SHOULD_BEFORE_START_TIME);


        Date startDate = new Date(startDateTime.getMillis());
        Date endDate = new Date(endDateTime.getMillis());
        Date downloadDate = new Date(downloadDateTime.getMillis());


        Integer playMode = addDTO.getPlayMode();
        if (ScheduleConst.PLAY_MODE_LOCAL != playMode && ScheduleConst.PLAY_MODE_ONLINE != playMode)
            throw new GlobalException(CodeEnum.PLAY_MODE_ERROR);

        Integer releaseType = addDTO.getReleaseType();
        if (ScheduleConst.RELEASE_CUT != releaseType &&
                releaseType != ScheduleConst.RELEASE_MONOPOLY &&
                releaseType != ScheduleConst.RELEASE_TAKE_TURNS) {
            throw new GlobalException(CodeEnum.RELEASE_TYPE_ERROR);
        }
        /* 构造排期*/
        Scheduling scheduling = new Scheduling();
        scheduling.setStartTime(startDate);
        scheduling.setEndTime(endDate);
        scheduling.setDownloadTime(downloadDate);
        scheduling.setName(addDTO.getName());
        scheduling.setDelFlag(Del_FLAG.EXISTED);
        scheduling.setPlayMode(addDTO.getPlayMode());
        scheduling.setReleaseType(addDTO.getReleaseType());
        scheduling.setDayInWeek(addDTO.getDayInWeek());
        scheduling.setRemark(addDTO.getRemark());
        if (insert(scheduling)) {
            return CommonResult.success(new RespId(scheduling.getId()));
        }
        return CommonResult.error("添加失败");
    }

    @Override
    @Transactional
    public CommonResult<RespList<Integer>> addShowToSchedule(ShowInScheduleDTO addDTO) {
        Integer scheduleId = addDTO.getScheduleId();
        List<Integer> showIdList = addDTO.getShowIdList();
        List<Integer> relIds = new ArrayList<>();
        for (Integer showId : showIdList) {
            SchedulingShowRel schedulingShowRel = new SchedulingShowRel();
            schedulingShowRel.setDelFlag(Del_FLAG.EXISTED);
            schedulingShowRel.setSchedulingId(scheduleId);
            schedulingShowRel.setShowId(showId);
            if (!schedulingShowRelService.insert(schedulingShowRel)) throw new GlobalException(CodeEnum.SCHEDULE_ADD_SHOW_FAILED);
            relIds.add(schedulingShowRel.getId());
        }
        log.info("==========>id is  {}", relIds);
        return CommonResult.success(new RespList<>(relIds));

    }

    @Override
    @Transactional
    public CommonResult<RespList<Integer>> addDevToSchedule(DevInScheduleDTO addDTO) {
        Integer scheduleId = addDTO.getScheduleId();
        List<String> snList = addDTO.getSnList();
        List<Integer> relIds = new ArrayList<>();
        for (String sn : snList) {
            Device device = deviceService.getDeviceBySN(sn);
            if (device == null) throw new GlobalException(CodeEnum.DEVICE_NOT_EXIST);
            device.setUpdateTime(new Date());
            SchedulingDeviceRel schedulingDeviceRel = new SchedulingDeviceRel();
            schedulingDeviceRel.setSchedulingId(scheduleId);
            schedulingDeviceRel.setDelFlag(Del_FLAG.EXISTED);
            schedulingDeviceRel.setDeviceId(device.getId());
            if (!schedulingDeviceRelService.insert(schedulingDeviceRel) ||  !deviceService.updateById(device)) throw new GlobalException(CodeEnum.SCHEDULE_ADD_DEV_FAILED);
            relIds.add(schedulingDeviceRel.getId());
        }
        return CommonResult.success(new RespList<>(relIds));
    }

    @Override
    @Transactional
    public CommonResult<RespList<Integer>> releaseSchedule(ReleaseScheduleDTO addDTO) {
        ScheduleAddDTO scheduleAddDTO = new ScheduleAddDTO();
        BeanUtils.copyProperties(addDTO, scheduleAddDTO);
        scheduleAddDTO.setDelFlag(Del_FLAG.EXISTED);
        CommonResult<RespId> addScheduleResult = addSchedule(scheduleAddDTO);
        if (!addScheduleResult.isSuccess()) throw new GlobalException(CodeEnum.ADD_SCHEDULE_FAILED);
        Integer id = addScheduleResult.getData().getId();

        /* 为排期添加节目*/
        ShowInScheduleDTO showInScheduleDTO = new ShowInScheduleDTO();
        showInScheduleDTO.setScheduleId(id);
        showInScheduleDTO.setShowIdList(addDTO.getShowIdList());
        CommonResult<RespList<Integer>> addShowToScheduleResult = addShowToSchedule(showInScheduleDTO);
        log.info("==========>result is  {}", addShowToScheduleResult);
        if (!addShowToScheduleResult.isSuccess()) throw new GlobalException(CodeEnum.SCHEDULE_ADD_SHOW_FAILED);

        /* 为 排期添加设备 */
        DevInScheduleDTO devInScheduleDTO = new DevInScheduleDTO();
        devInScheduleDTO.setSnList(addDTO.getSnList());
        devInScheduleDTO.setScheduleId(id);
        CommonResult<RespList<Integer>> addDevToScheduleResult = addDevToSchedule(devInScheduleDTO);
        if (!addDevToScheduleResult.isSuccess()) throw new GlobalException(CodeEnum.SCHEDULE_ADD_DEV_FAILED);

        /* 发送消息 */
        for (String sn : addDTO.getSnList()) {
            msgService.sendSyncScheduleMsg(sn);
        }

        return addDevToScheduleResult;
    }
}
