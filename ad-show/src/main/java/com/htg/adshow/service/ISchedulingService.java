package com.htg.adshow.service;

import com.htg.common.dto.adshow.DevInScheduleDTO;
import com.htg.common.dto.adshow.ReleaseScheduleDTO;
import com.htg.common.dto.adshow.ScheduleAddDTO;
import com.htg.common.dto.adshow.ShowInScheduleDTO;
import com.htg.common.entity.adshow.Scheduling;
import com.baomidou.mybatisplus.service.IService;
import com.htg.common.result.CommonResult;
import com.htg.common.result.RespId;
import com.htg.common.result.RespList;

/**
 * <p>
 * 节目排期表 服务类
 * </p>
 *
 * @author htg
 * @since 2019-07-02
 */
public interface ISchedulingService extends IService<Scheduling> {

    CommonResult<RespId> addSchedule(ScheduleAddDTO addDTO);

    CommonResult<RespList<Integer>> addShowToSchedule(ShowInScheduleDTO addDTO);

    CommonResult<RespList<Integer>> addDevToSchedule(DevInScheduleDTO addDTO);

    CommonResult<RespList<Integer>> releaseSchedule(ReleaseScheduleDTO addDTO);
}
