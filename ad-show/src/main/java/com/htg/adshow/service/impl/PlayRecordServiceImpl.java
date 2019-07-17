package com.htg.adshow.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.htg.adshow.mapper.PlayRecordMapper;
import com.htg.adshow.service.IDeviceService;
import com.htg.adshow.service.IPlayRecordService;
import com.htg.common.dto.adshow.PlayRecordPageDTO;
import com.htg.common.entity.adshow.Device;
import com.htg.common.entity.adshow.PlayRecord;
import com.htg.common.result.CommonResult;
import com.htg.common.result.RespPage;
import com.htg.common.vo.adshow.PlayRecordPageVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 播放记录表 服务实现类
 * </p>
 *
 * @author htg
 * @since 2019-07-11
 */
@Slf4j
@Service
public class PlayRecordServiceImpl extends ServiceImpl<PlayRecordMapper, PlayRecord> implements IPlayRecordService {

    @Autowired
    private IDeviceService deviceService;

    @Override
    public CommonResult<RespPage<PlayRecordPageVO>> queryPlayRecordByPage(PlayRecordPageDTO playRecordDTO) {
        Integer pageSize = playRecordDTO.getPageSize();
        Integer pageNum = playRecordDTO.getPageNum();
        Page<PlayRecordPageVO> page = new Page<>(pageNum, pageSize);
        String devName = playRecordDTO.getDevName();
        if (devName != null) {
            devName = "%" + devName + "%";
        }
        String showName = playRecordDTO.getShowName();
        if (showName != null) {
            showName = "%" + showName + "%";
        }

        Long startTime = playRecordDTO.getStartTime();
        Long endTime = playRecordDTO.getEndTime();
        List<PlayRecordPageVO> pageVOList = baseMapper.selectPlayRecordByPage(page, devName, showName, startTime, endTime);
        for (PlayRecordPageVO pageVO : pageVOList) {
            log.info("day is ===> {}", pageVO.getDay());
        }
        return CommonResult.success(new RespPage<>(pageVOList, page.getTotal()));
    }

    @Override
    public Integer getPlayCountBySN(String sellerSN) {
        Wrapper<Device> wrapper = new EntityWrapper<>();
        wrapper.eq("seller_sn", sellerSN);
        List<Device> devices = deviceService.selectList(wrapper);
        Integer count = 0;
        for (Device device : devices) {
            Wrapper<PlayRecord> wrap01 = new EntityWrapper<>();
            wrap01.eq("sn", device.getSn());
            List<PlayRecord> playRecords = selectList(wrap01);
            for (PlayRecord record : playRecords) {
                count += record.getFrequency();
            }
        }
        return count;
    }


}
