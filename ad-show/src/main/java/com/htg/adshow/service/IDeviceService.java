package com.htg.adshow.service;

import com.baomidou.mybatisplus.service.IService;
import com.htg.common.dto.adshow.*;
import com.htg.common.entity.adshow.Device;
import com.htg.common.result.CommonResult;
import com.htg.common.result.RespId;
import com.htg.common.result.RespList;
import com.htg.common.result.RespPage;
import com.htg.common.vo.adshow.*;

/**
 * <p>
 * 终端设备表 服务类
 * </p>
 *
 * @author htg
 * @since 2019-07-02
 */
public interface IDeviceService extends IService<Device> {

    CommonResult<RespId> addDevice(DeviceAddDTO device);

    CommonResult<RespId> verifyDevice(DeviceVerifyDTO deviceVerifyDTO);

    CommonResult<DeviceStatusInfoVO> getDeviceByMac(String mac);

    CommonResult<RespPage<DeviceInfoVo>> getVerifyDeviceList(DevVerifyListDTO devVerifyListDTO);

    CommonResult<RespPage<DeviceListVo>> getDeviceList(DevListDTO listDTO);

    CommonResult<RespList<SchedulingVO>> getShowList(String sn);

    CommonResult<DeviceDetailVo> getDevDetails(String sn);

    /* 根据 序列号获取设备 */
    Device getDeviceBySN(String sn);

    CommonResult<RespPage<SchedulingVO>> getScheduleListByPage(String sn, Integer pageNum, Integer pageSize);

    CommonResult  clearAllSchedule(String sn);

    CommonResult deleteSomeScheduleInDev(ScheduleDevDelDTO scheduleDevDelDTO);

    CommonResult changeStatus(DevModifyStatusDTO devModifyStatusDTO);


    CommonResult<RespPage<DeviceListVo>> getSellerDeviceList(SellerDevListDTO listDTO);

    CommonResult<RespPage<DeviceInfoVo>> getSellerVerifyDeviceList(SellerDevVerifyListDTO devVerifyListDTO);

    Integer getDeviceCountBySN(String sellerSN);




}
