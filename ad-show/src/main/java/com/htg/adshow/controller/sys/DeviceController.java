package com.htg.adshow.controller.sys;

import com.htg.adshow.service.IDeviceService;
import com.htg.adshow.service.impl.MSGServiceImpl;
import com.htg.common.dto.adshow.*;
import com.htg.common.exception.GlobalException;
import com.htg.common.result.CodeEnum;
import com.htg.common.result.CommonResult;
import com.htg.common.result.RespId;
import com.htg.common.result.RespPage;
import com.htg.common.utils.AuthUtil;
import com.htg.common.vo.adshow.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 终端设备表 前端控制器
 * </p>
 *
 * @author htg
 * @since 2019-07-02
 */
@Slf4j
@Api(value = "DeviceController", tags = "03-设备管理")
@RestController
@Validated
@RequestMapping("/device")
public class DeviceController {
    @Autowired
    private MSGServiceImpl msgService;

    /* 注册设备*/
    @Autowired
    private IDeviceService deviceService;

    @Autowired
    private StringRedisTemplate redisTemplate;

    /* 添加机构 */
    /* 获取用户信息*/
    @ApiOperation(value = "修改或者认证设备")
    @ResponseBody
    @PostMapping("/verfiy")
    public CommonResult<RespId> verfiyDevice(@Valid @RequestBody DeviceVerifyDTO deviceVerifyDTO) throws GlobalException {
        return deviceService.verifyDevice(deviceVerifyDTO);
    }



    /* 获取设备列表 */
    @ApiOperation(value = "查找待认证设备")
    @ResponseBody
    @PostMapping("/verify/list")
    public CommonResult<RespPage<DeviceInfoVo>> getVerifyDeviceList(@Valid @RequestBody DevVerifyListDTO devVerifyListDTO) throws GlobalException {
        String sellerName = devVerifyListDTO.getSellerName();

        if (sellerName != null) {
            sellerName = "%" + sellerName + "%";
            devVerifyListDTO.setSellerName(sellerName);
        }
        return deviceService.getVerifyDeviceList(devVerifyListDTO);
    }


    /* 获取设备列表 */
    @ApiOperation(value = "设备列表")
    @ResponseBody
    @PostMapping("/list")
    public CommonResult<RespPage<DeviceListVo>> getVerifyDeviceList(@Valid @RequestBody DevListDTO listDTO) throws GlobalException {
        String sellerName = listDTO.getSellerName();

        if (sellerName != null) {
            sellerName = "%" + sellerName + "%";
            listDTO.setSellerName(sellerName);
        }
        return deviceService.getDeviceList(listDTO);
    }




    /*根据设备的 sn 获取 设备详情*/
    @ApiOperation(value = "根据序列号获取设备详情")
    @ResponseBody
    @GetMapping("/detail/{sn}")
    public CommonResult<DeviceDetailVo> getDeviceDetails(@PathVariable("sn") String sn) throws GlobalException {
        return deviceService.getDevDetails(sn);
    }


    /*根据设备的 sn 获取 设备详情*/
    @ApiOperation(value = "根据序列号分页节目排期")
    @ResponseBody
    @GetMapping("/page/{sn}/{pageNum}/{pageSize}")
    public CommonResult<RespPage<SchedulingVO>> getDeviceDetails(@PathVariable("sn") String sn, @PathVariable("pageNum") Integer pageNum, @PathVariable("pageSize") Integer pageSize) throws GlobalException {
        return deviceService.getScheduleListByPage(sn, pageNum, pageSize);
    }


    /* 清空所有节目 */
    @ApiOperation(value = "清空所有节目")
    @ResponseBody
    @GetMapping("/clear_all_schedule_in_dev/{sn}")
    public CommonResult clearAllSchedule(@PathVariable("sn") String sn) throws GlobalException {
        return deviceService.clearAllSchedule(sn);
    }

    /* 清空所有节目 */
    @ApiOperation(value = "清空指定节目")
    @ResponseBody
    @PostMapping("/delete_some_schedule_in_dev")
    public CommonResult deleteSomeScheduleInDev(@Valid @RequestBody ScheduleDevDelDTO scheduleDevDelDTO) throws GlobalException {
        // Device deviceBySN = deviceService.getDeviceBySN(scheduleDevDelDTO.getSn());
        return deviceService.deleteSomeScheduleInDev(scheduleDevDelDTO);
    }

    /* 启用 和 停用 设备 */
    @ApiOperation(value = "启用或停用设备")
    @ResponseBody
    @PostMapping("/change_status")
    public CommonResult changeStatus(@Valid @RequestBody DevModifyStatusDTO devModifyStatusDTO) throws GlobalException {
        log.info("====> changeStatus user  is  {}", AuthUtil.getLoginUser().getUsername());
        return deviceService.changeStatus(devModifyStatusDTO);
    }


    @ApiOperation(value = "远程播放")
    @ResponseBody
    @PostMapping("/remote_play/{sn}")
    public CommonResult sendRemotePlayMsg(@PathVariable("sn") String sn) throws GlobalException {
        msgService.sendRemotePlayMsg(sn);
        return CommonResult.success("发送成功");
    }


    /* 启用 和 停用 设备 */
    @ApiOperation(value = "选择播放")
    @ResponseBody
    @PostMapping("/select_to_play/{sn}")
    public CommonResult sendSelectToPlayMsg(@PathVariable("sn") String sn) throws GlobalException {
        msgService.sendSelectToPlayMsg(sn);
        return CommonResult.success("发送成功");
    }


    /* 启用 和 停用 设备 */
    @ApiOperation(value = "截屏")
    @ResponseBody
    @PostMapping("/screenshot/{sn}")
    public CommonResult sendScreenshotsMsg(@PathVariable("sn") String sn) throws GlobalException {
        msgService.sendScreenshotsMsg(sn);
        return CommonResult.success("发送成功");
    }


    @ApiOperation(value = "更新APK")
    @ResponseBody
    @PostMapping("/update_app")
    public CommonResult updateApp(@Valid @RequestBody DevSNListDTO devSNListDTO) throws GlobalException {
        for (String sn : devSNListDTO.getSnList()) {
            msgService.sendUpdateAppMsg(sn);
        }
        return CommonResult.success("发送成功");
    }


    @ApiOperation(value = "停止播放")
    @ResponseBody
    @GetMapping("/stop_play/{sn}")
    public CommonResult stopPlayDev(@PathVariable("sn") String sn) throws GlobalException {
        msgService.sendStopPlayMsg(sn);
        return CommonResult.success("发送成功");
    }


    @ApiOperation(value = "静音")
    @ResponseBody
    @GetMapping("/mute/{sn}")
    public CommonResult muteDev(@PathVariable("sn") String sn) throws GlobalException {
        msgService.sendMuteMsg(sn);
        return CommonResult.success("发送成功");
    }


    @ApiOperation(value = "设置音量")
    @ResponseBody
    @GetMapping("/set_volume/{sn}/{vo}")
    public CommonResult muteDev(@PathVariable("sn") String sn, @PathVariable("vo") String vo) throws GlobalException {
        msgService.sendSetVolumeMsg(sn, vo);
        return CommonResult.success("发送成功");
    }

    @ApiOperation(value = "关机")
    @ResponseBody
    @GetMapping("/shutdown/{sn}")
    public CommonResult shutDownDev(@PathVariable("sn") String sn) throws GlobalException {
        msgService.sendShutdownMsg(sn);
        return CommonResult.success("发送成功");
    }

    @ApiOperation(value = "重启设备")
    @ResponseBody
    @GetMapping("/reboot/{sn}")
    public CommonResult rebootDev(@PathVariable("sn") String sn) throws GlobalException {
        msgService.sendRebootMsg(sn);
        return CommonResult.success("发送成功");
    }



    /* 上传截屏图片 地址 */
    @ApiOperation(value = "延迟刷新截图")
    @ResponseBody
    @GetMapping("/screen_shot_pic/{sn}")
    public CommonResult uploadShot(@PathVariable("sn") String sn) throws GlobalException {
        String shotUrl = redisTemplate.opsForValue().get(sn);
        if(shotUrl==null){
            throw new GlobalException(CodeEnum.SCREEN_SHOT_NOT_EXIST);
        }
        ScreenShotVo screenShotVo=new ScreenShotVo();
        screenShotVo.setUrl(shotUrl);
        return CommonResult.success(screenShotVo);
    }


}

