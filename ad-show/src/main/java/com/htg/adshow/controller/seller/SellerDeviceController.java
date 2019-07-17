package com.htg.adshow.controller.seller;

import com.htg.adshow.service.IDeviceService;
import com.htg.common.dto.adshow.SellerDevListDTO;
import com.htg.common.dto.adshow.SellerDevVerifyListDTO;
import com.htg.common.exception.GlobalException;
import com.htg.common.result.CommonResult;
import com.htg.common.result.RespPage;
import com.htg.common.vo.adshow.DeviceInfoVo;
import com.htg.common.vo.adshow.DeviceListVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;


@Slf4j
@Api(value = "SellerShowController", tags = "05-卖家设备管理")
@RestController
@Validated
@RequestMapping("/seller/device")
public class SellerDeviceController {

    @Autowired
    private IDeviceService iDeviceService;

    /* 获取设备列表 */
    @ApiOperation(value = "设备列表")
    @ResponseBody
    @PostMapping("/list")
    public CommonResult<RespPage<DeviceListVo>> getVerifyDeviceList(@Valid @RequestBody SellerDevListDTO listDTO) throws GlobalException {
        return iDeviceService.getSellerDeviceList(listDTO);
    }

    /* 获取设备列表 */
    @ApiOperation(value = "查找待认证设备")
    @ResponseBody
    @PostMapping("/verify/list")
    public CommonResult<RespPage<DeviceInfoVo>> getSellerVerifyDeviceList(@Valid @RequestBody SellerDevVerifyListDTO devVerifyListDTO) throws GlobalException {
        return iDeviceService.getSellerVerifyDeviceList(devVerifyListDTO);
    }
}
