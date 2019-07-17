package com.htg.adshow.controller.sys;

import com.htg.adshow.service.IMsgRecordService;
import com.htg.common.dto.adshow.MsgRecordPageDTO;
import com.htg.common.exception.GlobalException;
import com.htg.common.result.CommonResult;
import com.htg.common.result.RespPage;
import com.htg.common.vo.adshow.MsgRecordVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
    @PostMapping("/page")
    public CommonResult<RespPage<MsgRecordVO>> pageMsgRecord(@Valid @RequestBody MsgRecordPageDTO msgRecordPageDTO) throws GlobalException {

        return msgRecordService.selectByPage(msgRecordPageDTO);
    }

}

