package com.htg.adshow.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.htg.common.entity.adshow.PlayRecord;
import com.htg.common.vo.adshow.PlayRecordPageVO;

import java.util.List;

/**
 * <p>
 * 播放记录表 Mapper 接口
 * </p>
 *
 * @author htg
 * @since 2019-07-11
 */
public interface PlayRecordMapper extends BaseMapper<PlayRecord> {

    List<PlayRecordPageVO> selectPlayRecordByPage(Page<PlayRecordPageVO> page, String devName, String showName, Long startTime, Long endTime);

}
