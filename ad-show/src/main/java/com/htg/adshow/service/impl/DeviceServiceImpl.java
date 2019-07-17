package com.htg.adshow.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.htg.adshow.constant.DevConst;
import com.htg.adshow.mapper.DeviceMapper;
import com.htg.adshow.service.IDeviceService;
import com.htg.adshow.service.ISchedulingDeviceRelService;
import com.htg.adshow.utils.SnowFlakeUtil;
import com.htg.common.constant.Del_FLAG;
import com.htg.common.constant.SellerConst;
import com.htg.common.dto.adshow.*;
import com.htg.common.entity.adshow.Device;
import com.htg.common.entity.adshow.SchedulingDeviceRel;
import com.htg.common.entity.seller.SellerEnterpriseInfo;
import com.htg.common.entity.seller.SellerInfo;
import com.htg.common.exception.GlobalException;
import com.htg.common.msg.SnMsg;
import com.htg.common.result.*;
import com.htg.common.utils.AuthUtil;
import com.htg.common.vo.adshow.*;
import com.htg.feign.client.UserClient;
import org.apache.commons.lang.ArrayUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.security.action.GetLongAction;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

/**
 * <p>
 * 终端设备表 服务实现类
 * </p>
 *
 * @author htg
 * @since 2019-07-02
 */
@Service
public class DeviceServiceImpl extends ServiceImpl<DeviceMapper, Device> implements IDeviceService {
    @Autowired
    private UserClient userClient;
    /**
     * 注入发送MQTT的Bean
     */
    @Autowired
    private MSGServiceImpl msgService;

    @Autowired
    private ISchedulingDeviceRelService schedulingDeviceRelService;

    @Override
    @Transactional
    public CommonResult<RespId> addDevice(DeviceAddDTO deviceDTO) {

        Device device = new Device();
        String sellerSn = deviceDTO.getSellerSn();
        String mac = deviceDTO.getMac();
        /* 检查设备是否已经存在*/
        Device devExt = baseMapper.selectByMac(mac);
        if (devExt != null) throw new GlobalException(CodeEnum.DEVICE_HAS_EXIST);

        // 获取商户信息
        SellerInfo sellerInfo = userClient.getSellerBySN(sellerSn);
        if (sellerInfo == null) throw new GlobalException(CodeEnum.SELLER_NOT_EXIST);
        if (sellerInfo.getType() == SellerConst.TYPE_ENTERPRISE) { //
            SellerEnterpriseInfo sellerEnterpriseInfo = userClient.getSellerEnterpriseInfoBySN(sellerSn);
            if (sellerEnterpriseInfo == null) throw new GlobalException(CodeEnum.ENTERPRISE_INFO_NOT_EXIST);
            device.setSellerName(sellerEnterpriseInfo.getEnterpriseName());
        } else {
            device.setSellerName(sellerInfo.getAdminName());
        }

        /* 检测设备类型*/
        Integer type = deviceDTO.getType();
        boolean contains = ArrayUtils.contains(DevConst.DEV_TYPE, type);

        if (!contains) throw new GlobalException(CodeEnum.ADD_DEVICE_TYPE_ERROR);

        BeanUtils.copyProperties(deviceDTO, device);
        /* 生成设备序列号码 */
        device.setNum(SnowFlakeUtil.getFlowIdInstance().nextId() + "");
        device.setSn(UUID.randomUUID().toString());
        device.setOnlineStatus(DevConst.ONLINE_STATUS_ON);
        device.setStatus(DevConst.STATUS_HAS_NOT_VERFIY);
        device.setDelFlag(Del_FLAG.EXISTED);
        if (insert(device)) {
            return CommonResult.success(new RespId(device.getId()));
        } else {
            return CommonResult.error("添加设备失败");
        }
    }

    @Override
    public CommonResult<RespId> verifyDevice(DeviceVerifyDTO deviceVerifyDTO) {
        Integer status = deviceVerifyDTO.getStatus();
        if (status != DevConst.STATUS_HAS_NOT_VERFIY && status != DevConst.STATUS_ACTIVE && status != DevConst.STATUS_FROZEN) {
            throw new GlobalException(CodeEnum.VERIFY_DEVICE_STATUS_ERROR);
        }
        String sn = deviceVerifyDTO.getSn();
        Device deviceExt = baseMapper.selectBySN(sn);
        if (deviceExt == null) throw new GlobalException(CodeEnum.DEVICE_NOT_EXIST);

        BeanUtils.copyProperties(deviceVerifyDTO, deviceExt);
        if (updateById(deviceExt)) {
            if (deviceExt.getStatus() == DevConst.STATUS_ACTIVE) { // 如果
                SnMsg snMsg = new SnMsg();
                snMsg.setSn(deviceExt.getSn());
                msgService.sendVerifyPassMSG(deviceExt.getMac(), snMsg);
            }
            return CommonResult.success(new RespId(deviceExt.getId()));
        } else {
            return CommonResult.error("更新失败");
        }
    }

    @Override
    public CommonResult<DeviceStatusInfoVO> getDeviceByMac(String mac) {
        Device device = baseMapper.selectByMac(mac);
        DeviceStatusInfoVO statusInfoVO = new DeviceStatusInfoVO();
        if (device == null) {
            statusInfoVO.setSn(null);
            statusInfoVO.setStatus(DevConst.STATUS_DEV_NOT_EXIST);
        } else if (device.getStatus() != DevConst.STATUS_ACTIVE && device.getStatus() != DevConst.STATUS_FROZEN) {
            statusInfoVO.setSn(null);
            statusInfoVO.setStatus(device.getStatus());
        } else {
            statusInfoVO.setSn(device.getSn());
            statusInfoVO.setStatus(device.getStatus());
        }
        return CommonResult.success(statusInfoVO);
    }


    @Override
    public CommonResult<RespPage<DeviceInfoVo>> getVerifyDeviceList(DevVerifyListDTO devVerifyListDTO) {
        Page<DeviceInfoVo> page = new Page<>(devVerifyListDTO.getPageNum(), devVerifyListDTO.getPageSize());
        String sellerName = devVerifyListDTO.getSellerName();
        Integer type = devVerifyListDTO.getType();
        Integer deviceId = devVerifyListDTO.getDeviceId();
        List<DeviceInfoVo> list = baseMapper.selectVerifyList(page, sellerName, type, deviceId, DevConst.STATUS_HAS_NOT_VERFIY);
        return CommonResult.success(new RespPage<>(list, page.getTotal()));
    }

    @Override
    public CommonResult<RespPage<DeviceListVo>> getDeviceList(DevListDTO listDTO) {
        Page<DeviceListVo> page = new Page<>(listDTO.getPageNum(), listDTO.getPageSize());
        String sellerName = listDTO.getSellerName();
        Integer deviceId = listDTO.getDeviceId();
        Integer status = listDTO.getStatus();
        Integer onlineStatus = listDTO.getOnlineStatus();
        List<DeviceListVo> list = baseMapper.selectDevList(page, sellerName, deviceId, status, onlineStatus);
        for (DeviceListVo deviceListVo : list) {
            //   Integer id = deviceListVo.getId();
            int showCount = 0;
            List<SchedulingVO> schedulingVOS = baseMapper.selectSchedulingVOList(deviceListVo.getId());
            //Collection<SchedulingVO> schedulingVOS = getShowList(deviceListVo.getSn()).getData().getList();
            for (SchedulingVO schedulingVO : schedulingVOS) {
                int size = schedulingVO.getShowVOList().size();
                showCount += size;
            }
            deviceListVo.setShowCount(showCount);
        }
        return CommonResult.success(new RespPage<>(list, page.getTotal()));
    }


    @Override
    public CommonResult<RespList<SchedulingVO>> getShowList(String sn) {
        Device device = baseMapper.selectBySN(sn);

        if (device == null) throw new GlobalException(CodeEnum.DEVICE_NOT_EXIST);

        if (device.getStatus() != DevConst.STATUS_ACTIVE && device.getStatus() != DevConst.STATUS_FROZEN)
            throw new GlobalException(CodeEnum.DEVICE_HAS_NOT_ACTIVE);


        List<SchedulingVO> schedulingVOS = baseMapper.selectSchedulingVOList(device.getId());

        return CommonResult.success(new RespList<>(schedulingVOS));
    }


    /* 根据设备序列号 获取设备详情*/
    @Override
    public CommonResult<DeviceDetailVo> getDevDetails(String sn) {
        DeviceDetailVo deviceDetailVo = new DeviceDetailVo();
        Device device = baseMapper.selectBySN(sn);
        if (device == null) throw new GlobalException(CodeEnum.DEVICE_NOT_EXIST);
        BeanUtils.copyProperties(device, deviceDetailVo);
        return CommonResult.success(deviceDetailVo);
    }


    /* 根据 序列号获取设备 */
    @Override
    public Device getDeviceBySN(String sn) {
        return baseMapper.selectBySN(sn);
    }

    @Override
    public CommonResult<RespPage<SchedulingVO>> getScheduleListByPage(String sn, Integer pageNum, Integer pageSize) {
        Device device = baseMapper.selectBySN(sn);
        if (device == null) throw new GlobalException(CodeEnum.DEVICE_NOT_EXIST);
        if (device.getStatus() != DevConst.STATUS_ACTIVE && device.getStatus() != DevConst.STATUS_FROZEN)
            throw new GlobalException(CodeEnum.DEVICE_HAS_NOT_ACTIVE);
        /* 查询的条件 */
        Wrapper<SchedulingDeviceRel> wrapper = new EntityWrapper<>();
        wrapper.eq("device_id", device.getId());
        Page<SchedulingDeviceRel> page = new Page<>(pageNum, pageSize, "create_time", false);
        Page<SchedulingDeviceRel> result = schedulingDeviceRelService.selectPage(page, wrapper);
        List<SchedulingDeviceRel> records = result.getRecords();
        long total = result.getTotal();

        List<SchedulingVO> schedulingVOS = new ArrayList<>();

        for (SchedulingDeviceRel deviceRel : records) {
            Integer schedulingId = deviceRel.getSchedulingId();
            SchedulingVO schedulingVO = baseMapper.selectSchedulingVO(schedulingId);
            schedulingVO.setReleaseTime(deviceRel.getCreateTime());
            schedulingVOS.add(schedulingVO);
        }
        return CommonResult.success(new RespPage<>(schedulingVOS, total));
    }

    @Override
    @Transactional
    public CommonResult clearAllSchedule(String sn) {
        Device device = getDeviceBySN(sn);
        Wrapper<SchedulingDeviceRel> wrapper = new EntityWrapper<>();
        wrapper.eq("device_id", device.getId());
        boolean delete = schedulingDeviceRelService.delete(wrapper);
        if (delete) {
            msgService.sendClearAllSchMsg(sn);
            return CommonResult.success("删除成功");
        } else {
            return CommonResult.error("删除失败");
        }
    }

    @Override
    @Transactional
    public CommonResult deleteSomeScheduleInDev(ScheduleDevDelDTO scheduleDevDelDTO) {
        String sn = scheduleDevDelDTO.getSn();
        List<Integer> scheduleIdList = scheduleDevDelDTO.getScheduleIdList();
        Device device = getDeviceBySN(sn);
        for (Integer scheduleId : scheduleIdList) {
            Wrapper<SchedulingDeviceRel> wrapper = new EntityWrapper<>();
            wrapper.eq("device_id", device.getId()).and().eq("scheduling_id", scheduleId);
            if (!schedulingDeviceRelService.delete(wrapper)) {
                throw new GlobalException(CodeEnum.SCHEDULE_DELETE_DEV_FAILED);
            }
        }
        msgService.sendDeleteSomeSchMsg(sn);
        return CommonResult.success("删除排期成功");
    }

    @Override
    @Transactional
    public CommonResult changeStatus(DevModifyStatusDTO devModifyStatusDTO) {
        Integer status = devModifyStatusDTO.getStatus();
        if (status != DevConst.STATUS_FROZEN && status != DevConst.STATUS_ACTIVE)
            throw new GlobalException(CodeEnum.DEVICE_STATUS_ERROR);

        List<String> snList = devModifyStatusDTO.getSnList();
        for (String sn : snList) {
            Device device = getDeviceBySN(sn);
            device.setStatus(status);
            if (!updateById(device))
                throw new GlobalException(CodeEnum.DEV_CHANGE_STATUS_FAILED);
        }
        /* 等所有的设备都更新成功了再 发消息*/
        if (status == DevConst.STATUS_ACTIVE) {
            for (String sn : snList) {
                msgService.sendActiveMSG(sn);
            }
        } else if (status == DevConst.STATUS_FROZEN) {
            for (String sn : snList) {
                msgService.sendFrozenMSG(sn);
            }
        }
        return CommonResult.success("更新设备状态成功");
    }

    @Override
    public CommonResult<RespPage<DeviceListVo>> getSellerDeviceList(SellerDevListDTO listDTO) {
        Integer loginUserId = AuthUtil.getLoginUserId();
        SellerInfo sellerInfo = userClient.getSellerInfoByUserId(loginUserId);
        if (sellerInfo == null) throw new GlobalException(CodeEnum.SELLER_NOT_EXIST);
        String sn = sellerInfo.getSn();
        Integer deviceId = listDTO.getDeviceId();
        Integer status = listDTO.getStatus();
        Integer onlineStatus = listDTO.getOnlineStatus();
        Page<DeviceListVo> page = new Page<>(listDTO.getPageNum(), listDTO.getPageSize());
        List<DeviceListVo> list = baseMapper.selectSellerDevList(page, deviceId, status, onlineStatus, sn);
        for (DeviceListVo deviceListVo : list) {
            //   Integer id = deviceListVo.getId();
            int showCount = 0;
            List<SchedulingVO> schedulingVOS = baseMapper.selectSchedulingVOList(deviceListVo.getId());
            //Collection<SchedulingVO> schedulingVOS = getShowList(deviceListVo.getSn()).getData().getList();
            for (SchedulingVO schedulingVO : schedulingVOS) {
                int size = schedulingVO.getShowVOList().size();
                showCount += size;
            }
            deviceListVo.setShowCount(showCount);
        }

        return CommonResult.success(new RespPage<>(list, page.getTotal()));
    }

    @Override
    public CommonResult<RespPage<DeviceInfoVo>> getSellerVerifyDeviceList(SellerDevVerifyListDTO devVerifyListDTO) {
        Integer loginUserId = AuthUtil.getLoginUserId();
        SellerInfo sellerInfo = userClient.getSellerInfoByUserId(loginUserId);
        if (sellerInfo == null) throw new GlobalException(CodeEnum.SELLER_NOT_EXIST);
        String sn = sellerInfo.getSn();
        Page<DeviceInfoVo> page = new Page<>(devVerifyListDTO.getPageNum(), devVerifyListDTO.getPageNum());
        Integer type = devVerifyListDTO.getType();
        Integer deviceId = devVerifyListDTO.getDeviceId();
        List<DeviceInfoVo> list = baseMapper.selectSellerDevVerifyList(page, sn, type, deviceId, DevConst.STATUS_HAS_NOT_VERFIY);
        return CommonResult.success(new RespPage<>(list, page.getTotal()));
    }

    @Override
    public Integer getDeviceCountBySN(String sn) {

        return baseMapper.selectByCountBySn(sn);
    }


}
