package com.htg.adshow.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.htg.common.entity.adshow.MsgRecord;
import com.htg.common.vo.adshow.MsgRecordVO;

import java.util.List;

/**
 * <p>
 * 消息记录表 Mapper 接口
 * </p>
 *
 * @author htg
 * @since 2019-07-11
 */
public interface MsgRecordMapper extends BaseMapper<MsgRecord> {
    List<MsgRecordVO> selectByPage(Page<MsgRecordVO> page, String name, String sn, String mac, Integer type);
}
