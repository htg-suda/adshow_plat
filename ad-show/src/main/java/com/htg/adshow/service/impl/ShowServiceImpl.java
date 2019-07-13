package com.htg.adshow.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.htg.adshow.mapper.ShowMapper;
import com.htg.adshow.service.IShowService;
import com.htg.adshow.utils.SnowFlakeUtil;
import com.htg.common.constant.Del_FLAG;
import com.htg.common.dto.adshow.ShowDTO;
import com.htg.common.entity.adshow.Show;
import com.htg.common.result.CommonResult;
import com.htg.common.result.RespId;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 节目表 服务实现类
 * </p>
 *
 * @author htg
 * @since 2019-07-08
 */
@Service
public class ShowServiceImpl extends ServiceImpl<ShowMapper, Show> implements IShowService {

    @Override
    public CommonResult<RespId> addShow(ShowDTO showDTO) {
        Show show = new Show();
        BeanUtils.copyProperties(showDTO, show);
        show.setDelFlag(Del_FLAG.EXISTED);
        show.setNum(SnowFlakeUtil.getFlowIdInstance().nextId() + "");
        show.setAddBy(1);
        show.setAuthorId(0);
        if (insert(show)) {
            return CommonResult.success(new RespId(show.getId()));
        } else {
            return CommonResult.error("添加失败");
        }
    }

    /* 获取节目列表 */



}
