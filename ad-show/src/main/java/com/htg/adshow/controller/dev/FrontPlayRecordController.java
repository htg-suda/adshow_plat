package com.htg.adshow.controller.dev;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.htg.adshow.constant.DevConst;
import com.htg.adshow.service.IDeviceService;
import com.htg.adshow.service.IPlayRecordService;
import com.htg.adshow.service.ISchedulingService;
import com.htg.adshow.service.IShowService;
import com.htg.common.constant.Del_FLAG;
import com.htg.common.dto.adshow.PlayRecordDTO;
import com.htg.common.entity.adshow.Device;
import com.htg.common.entity.adshow.PlayRecord;
import com.htg.common.exception.GlobalException;
import com.htg.common.result.CodeEnum;
import com.htg.common.result.CommonResult;
import com.htg.common.result.RespId;
import com.htg.common.result.RespList;
import com.htg.common.vo.adshow.SchedulingVO;
import com.htg.common.vo.adshow.ShowVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Slf4j
@Api(value = "FrontPlayRecordController", tags = "12-前端设备播放记录管理")
@RestController
@RequestMapping("/front/play_record")
public class FrontPlayRecordController {

    /* 添加或修改播放记录 */
    @Autowired
    private IPlayRecordService playRecordService;

    @Autowired
    private IDeviceService iDeviceService;


    /**/
    @ApiOperation(value = "添加播放记录")
    @ResponseBody
    @PostMapping("/add")
    @Transactional
    public CommonResult<RespId> addPlayRecord(@Valid @RequestBody PlayRecordDTO playRecordDTO) throws GlobalException {
        String sn = playRecordDTO.getSn();
        Integer showId = playRecordDTO.getShowId();
        Device deviceBySN = iDeviceService.getDeviceBySN(sn);
        Integer schedulingId = playRecordDTO.getSchedulingId();

        /* 在提交记录的时候 检测设备的状态 */
        if (deviceBySN == null) throw new GlobalException(CodeEnum.DEVICE_NOT_EXIST);
        if (deviceBySN.getStatus() != DevConst.STATUS_ACTIVE)
            throw new GlobalException(CodeEnum.DEVICE_INVALID_PLAY_RECORD_BY_DEV_STATUS);
        /* 对排期进行判断 */

        /* 对节目进行判断 */

        SchedulingVO schedulingVOExt = null;
        ShowVO showExt = null;
        CommonResult<RespList<SchedulingVO>> showList = iDeviceService.getShowList(sn);
        Collection<SchedulingVO> list = showList.getData().getList();
        boolean hasSchedule = false;
        /* 获取所有排期 */
        for (SchedulingVO schedule : list) {
            if (schedule.getId() == schedulingId) {
                hasSchedule = true;
                schedulingVOExt = schedule;
                break;
            }
        }
        if (hasSchedule) {
            /* 检测排期是否超前 或则 过期后还在播放 */
            Date endTime = schedulingVOExt.getEndTime();
            if (endTime.before(new Date()))
                throw new GlobalException(CodeEnum.DEVICE_INVALID_PLAY_RECORD_BY_SCHEDULING_HAS_END);
            Date startTime = schedulingVOExt.getStartTime();
            if (startTime.after(new Date()))
                throw new GlobalException(CodeEnum.DEVICE_INVALID_PLAY_RECORD_BY_SCHEDULING_HAS_NOT_START);

            List<ShowVO> showVOList = schedulingVOExt.getShowVOList();
            boolean hasShow = false;
            for (ShowVO showVO : showVOList) {
                if (showVO.getId() == showId) {
                    hasShow = true;
                    showExt = showVO;
                    break;
                }
            }
            if (!hasShow) { // 播放节目在指定的排期中不存在
                throw new GlobalException(CodeEnum.DEVICE_INVALID_PLAY_RECORD_BY_SHOW_NOT_EXIST);
            }

        } else {  // 没有找到指定排期id的排期
            throw new GlobalException(CodeEnum.DEVICE_INVALID_PLAY_RECORD_BY_SCHEDULING_NOT_EXIST);
        }



        /* */
        String nowStr = DateTime.now().toString("yyyy-MM-dd");
        DateTime dateTime = DateTimeFormat.forPattern("yyyy-MM-dd").parseDateTime(nowStr);
        Date day = dateTime.toDate();

        PlayRecord playRecord = new PlayRecord();
        Wrapper<PlayRecord> wrapper = new EntityWrapper<>();
        wrapper.eq("day", day).and().eq("sn", playRecordDTO.getSn()).and().eq("show_id", playRecord.getShowId());

        PlayRecord playRecordExt = playRecordService.selectOne(wrapper);
        if (playRecordExt == null) {
            playRecord.setDay(day);
            BeanUtils.copyProperties(playRecordDTO, playRecord);
            playRecord.setDelFlag(Del_FLAG.EXISTED);
            playRecord.setFrequency(1);
            if (playRecordService.insert(playRecord)) return CommonResult.success(new RespId(playRecord.getId()));
        } else {
            Integer frequency = playRecordExt.getFrequency();
            playRecordExt.setFrequency(++frequency);
            if (playRecordService.updateById(playRecordExt))
                return CommonResult.success(new RespId(playRecordExt.getId()));
        }
        return CommonResult.error("更新失败");
    }
}
