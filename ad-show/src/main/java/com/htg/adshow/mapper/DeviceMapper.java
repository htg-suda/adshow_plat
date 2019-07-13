package com.htg.adshow.mapper;

import com.baomidou.mybatisplus.plugins.Page;
import com.htg.common.entity.adshow.Device;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.htg.common.vo.adshow.DeviceInfoVo;
import com.htg.common.vo.adshow.DeviceListVo;
import com.htg.common.vo.adshow.SchedulingVO;

import java.util.List;

/**
 * <p>
 * 终端设备表 Mapper 接口
 * </p>
 *
 * @author htg
 * @since 2019-07-02
 */
public interface DeviceMapper extends BaseMapper<Device> {

    Device selectByMac(String mac);

    Device selectBySN(String sn);

    List<DeviceInfoVo> selectVerifyList(Page<DeviceInfoVo> page, String sellerName, Integer type, Integer deviceId, Integer status);

    List<DeviceListVo> selectDevList(Page<DeviceListVo> page, String sellerName, Integer deviceId, Integer status, Integer onlineStatus);

    List<SchedulingVO> selectSchedulingVOList(Integer deviceId);

    SchedulingVO selectSchedulingVO(Integer schedulingId);

}
