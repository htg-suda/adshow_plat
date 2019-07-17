package com.htg.adshow.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.htg.adshow.mapper.MsgRecordMapper;
import com.htg.adshow.service.IMsgRecordService;
import com.htg.common.dto.adshow.MsgRecordPageDTO;
import com.htg.common.entity.adshow.MsgRecord;
import com.htg.common.result.CommonResult;
import com.htg.common.result.RespPage;
import com.htg.common.vo.adshow.MsgRecordVO;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * <p>
 * 消息记录表 服务实现类
 * </p>
 *
 * @author htg
 * @since 2019-07-11
 */
@Service
public class MsgRecordServiceImpl extends ServiceImpl<MsgRecordMapper, MsgRecord> implements IMsgRecordService {

    @Override
    public CommonResult<RespPage<MsgRecordVO>> selectByPage(MsgRecordPageDTO pageDTO) {
        Integer pageNum = pageDTO.getPageNum();
        Integer pageSize = pageDTO.getPageSize();
        Page<MsgRecordVO> page = new Page<>(pageNum, pageSize);

        String name = pageDTO.getName();
        String mac = pageDTO.getMac();
        String sn = pageDTO.getSn();
        Integer type = pageDTO.getType();
        if (name != null) {
            name = "%" + name + "%";
        }

        if (mac != null) {
            mac = "%" + mac + "%";
        }
        List<MsgRecordVO> recordVOList = baseMapper.selectByPage(page, name, sn, mac, type);


        return CommonResult.success(new RespPage<>(recordVOList, page.getTotal()));
    }
}
