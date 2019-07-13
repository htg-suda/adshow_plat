package com.htg.adshow.service;

import com.baomidou.mybatisplus.service.IService;
import com.htg.common.dto.adshow.ShowDTO;
import com.htg.common.entity.adshow.Show;
import com.htg.common.result.CommonResult;
import com.htg.common.result.RespId;

/**
 * <p>
 * 节目表 服务类
 * </p>
 *
 * @author htg
 * @since 2019-07-08
 */
public interface IShowService extends IService<Show> {

    CommonResult<RespId> addShow(ShowDTO showDTO);
}
