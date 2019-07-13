package com.htg.adshow.controller.sys;

import com.htg.adshow.service.IPlayRecordService;
import com.htg.common.dto.adshow.PlayRecordPageDTO;
import com.htg.common.exception.GlobalException;
import com.htg.common.result.CommonResult;
import com.htg.common.result.RespPage;
import com.htg.common.vo.adshow.PlayRecordPageVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * <p>
 * 播放记录表 前端控制器
 * </p>
 *
 * @author htg
 * @since 2019-07-11
 */
@Slf4j
@Api(value = "PlayRecordController", tags = "07-播放记录管理")
@RestController
@RequestMapping("/play_record")
public class PlayRecordController {
    /* 添加或修改播放记录 */
    @Autowired
    private IPlayRecordService playRecordService;


    /* 播放记录 分页 */
    @ApiOperation(value = "添加播放记录")
    @ResponseBody
    @PostMapping("/page")
    public CommonResult<RespPage<PlayRecordPageVO>> queryPlayRecordByPage(@Valid @RequestBody PlayRecordPageDTO playRecordDTO) throws GlobalException {
        return playRecordService.queryPlayRecordByPage(playRecordDTO);
    }


}

