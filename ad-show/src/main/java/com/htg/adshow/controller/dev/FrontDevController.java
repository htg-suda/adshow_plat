package com.htg.adshow.controller.dev;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.htg.adshow.constant.MsgStatusConst;
import com.htg.adshow.service.IDeviceService;
import com.htg.adshow.service.IMsgRecordService;
import com.htg.common.dto.adshow.DeviceAddDTO;
import com.htg.common.dto.adshow.UploadShotDTO;
import com.htg.common.entity.adshow.MsgRecord;
import com.htg.common.exception.GlobalException;
import com.htg.common.result.CommonResult;
import com.htg.common.result.RespId;
import com.htg.common.result.RespList;
import com.htg.common.vo.adshow.DeviceStatusInfoVO;
import com.htg.common.vo.adshow.SchedulingVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Slf4j
@Api(value = "FrontDevController", tags = "11-前端设备调用")
@RestController
@Validated
@RequestMapping("/front/device")
public class FrontDevController {

    @Autowired
    private StringRedisTemplate redisTemplate;
    /* 注册设备*/
    @Autowired
    private IDeviceService deviceService;

    @Autowired
    private IMsgRecordService msgRecordService;

    /* 添加机构 */
    /* 获取用户信息*/
    @ApiOperation(value = "添加设备")
    @ResponseBody
    @PostMapping("/add")
    public CommonResult<RespId> addDevice(@Valid @RequestBody DeviceAddDTO device) throws GlobalException {
        return deviceService.addDevice(device);
    }

    /* 根据MAC 地址获取 终端编号和认证状态 */
    @ApiOperation(value = "根据设备Mac地址,获取设备是否被认证了")
    @ResponseBody
    @GetMapping("/info/{mac}")
    public CommonResult<DeviceStatusInfoVO> getDeviceByMac(@PathVariable("mac") String mac) throws GlobalException {
        return deviceService.getDeviceByMac(mac);
    }

    /* 根据设备序列号获取设备的节目和排期  */
    @ApiOperation(value = "根据序列号获取排期和节目")
    @ResponseBody
    @GetMapping("/list/show/{sn}")
    public CommonResult<RespList<SchedulingVO>> getSchedulingList(@PathVariable("sn") String sn) throws GlobalException {
        return deviceService.getShowList(sn);
    }


    /* 消息收到,或完成消息 通知 */
    @ApiOperation(value = "消息执行完成后的回执")
    @ResponseBody
    @GetMapping("/msg/status/{num}")
    public CommonResult updateMsgStatus(@PathVariable("num") String num) throws GlobalException {
        Wrapper<MsgRecord> wrapper = new EntityWrapper<>();
        wrapper.eq("num", num);
        MsgRecord msgRecord = msgRecordService.selectOne(wrapper);
        if (msgRecord != null) {
            msgRecord.setStatus(MsgStatusConst.RECIVE_SUCCESS);
            msgRecord.setEndTime(new Date());
        } else {
            return CommonResult.error("修改失败,消息记录不存在");
        }
        if (msgRecordService.updateById(msgRecord)) return CommonResult.success("修改成功");
        return CommonResult.error("修改失败");
    }

    /* 上传截屏图片 地址 */
    @ApiOperation(value = "上传截图")
    @ResponseBody
    @PostMapping("/upload_shot")
    public CommonResult uploadShot(UploadShotDTO shotDTO) throws GlobalException {
        redisTemplate.opsForValue().set(shotDTO.getSn(), shotDTO.getUrl(), 24, TimeUnit.HOURS);
        return CommonResult.success("设置成功");
    }


}
