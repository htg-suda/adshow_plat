package com.htg.adshow.controller.sys;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.htg.adshow.service.IMsgRecordService;
import com.htg.common.entity.adshow.MsgRecord;
import com.htg.common.exception.GlobalException;
import com.htg.common.result.CommonResult;
import com.htg.common.result.RespPage;
import com.htg.common.vo.adshow.MsgRecordVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 消息记录表 前端控制器
 * </p>
 *
 * @author htg
 * @since 2019-07-11
 */
@Slf4j
@Api(value = "MsgRecordController", tags = "06-消息记录管理")
@RestController
@Validated
@RequestMapping("/msg_record")
public class MsgRecordController {
    @Autowired
    private IMsgRecordService msgRecordService;

    /* 获取设备操作记录,并且分页 */
    @ApiOperation(value = "获取设备操作记录")
    @ResponseBody
    @GetMapping("/page/{sn}/{pageNum}/{pageSize}")
    public CommonResult<RespPage<MsgRecordVO>> rebootDev(@PathVariable("sn") String sn, @PathVariable("pageNum") Integer pageNum, @PathVariable("pageSize") Integer pageSize) throws GlobalException {
        Wrapper<MsgRecord> wrapper = new EntityWrapper<>();
        wrapper.eq("sn", sn);
        Page<MsgRecord> msgRecordPage = new Page<>(pageNum, pageSize, "update_time", false);
        Page<MsgRecord> recordPage = msgRecordService.selectPage(msgRecordPage, wrapper);
        List<MsgRecord> records = recordPage.getRecords();

        List<MsgRecordVO> recordVOList = new ArrayList<>();
        for (MsgRecord record : records) {
            MsgRecordVO recordVO = new MsgRecordVO();
            recordVO.setTag(record.getTag());
            recordVO.setNum(record.getNum());
            recordVO.setStatus(record.getStatus());
            recordVO.setInitiator(record.getInitiator());
            recordVO.setSn(record.getSn());
            Date endTime = record.getEndTime();
            if (endTime != null) {
                String endStr = new DateTime(endTime.getTime()).toString("yyyy-MM-dd HH:mm:ss");
                recordVO.setEndTime(endStr);
            }

            Date startTime = record.getStartTime();
            String startStr = new DateTime(startTime.getTime()).toString("yyyy-MM-dd HH:mm:ss");
            recordVO.setStartTime(startStr);

            Date updateTime = record.getUpdateTime();
            String updateStr = new DateTime(updateTime.getTime()).toString("yyyy-MM-dd HH:mm:ss");
            recordVO.setUpdateTime(updateStr);

            recordVOList.add(recordVO);
        }
        return CommonResult.success(new RespPage<>(recordVOList, msgRecordPage.getTotal()));
    }

}

