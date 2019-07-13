package com.htg.adshow.controller.sys;
import com.htg.adshow.service.ISchedulingService;
import com.htg.common.dto.adshow.*;
import com.htg.common.exception.GlobalException;
import com.htg.common.result.CommonResult;
import com.htg.common.result.RespId;
import com.htg.common.result.RespList;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * <p>
 * 节目排期表 前端控制器
 * </p>
 *
 * @author htg
 * @since 2019-07-02
 */

@Slf4j
@Api(value = "SchedulingController", tags = "04-排期管理")
@RestController
@Validated
@RequestMapping("/scheduling")
public class SchedulingController {

    @Autowired
    private ISchedulingService schedulingService;

    /* 添加排期 */
    /* 添加机构 */
    /* 获取用户信息*/
    @ApiOperation(value = "添加排期")
    @ResponseBody
    @PostMapping("/add")
    public CommonResult<RespId> addSchedule(@Valid @RequestBody ScheduleAddDTO addDTO) throws GlobalException {
        return schedulingService.addSchedule(addDTO);
    }

    /* 为排期添加节目 */
    @ApiOperation(value = "为排期添加节目")
    @ResponseBody
    @PostMapping("/add_show_to_schedule")
    public CommonResult<RespList<Integer>> addShowToSchedule(@Valid @RequestBody ShowInScheduleDTO addDTO) throws GlobalException {
        return schedulingService.addShowToSchedule(addDTO);
    }

    /* 为排期添加设备,并且 推送给设备 */
    @ApiOperation(value = "为排期添加设备")
    @ResponseBody
    @PostMapping("/add_dev_to_schedule")
    public CommonResult<RespList<Integer>> addDevToSchedule(@Valid @RequestBody DevInScheduleDTO addDTO) throws GlobalException {
        return schedulingService.addDevToSchedule(addDTO);
    }


    /* Api */
    @ApiOperation(value = "添加排期,节目,设备")
    @ResponseBody
    @PostMapping("/release_schedule")
    public CommonResult<RespList<Integer>> addDevAndShowToSchedule(@Valid @RequestBody ReleaseScheduleDTO addDTO) throws GlobalException {
        return schedulingService.releaseSchedule(addDTO);
    }
}

