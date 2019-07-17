package com.htg.adshow.service;

import com.baomidou.mybatisplus.service.IService;
import com.htg.common.dto.adshow.PlayRecordPageDTO;
import com.htg.common.entity.adshow.PlayRecord;
import com.htg.common.result.CommonResult;
import com.htg.common.result.RespPage;
import com.htg.common.vo.adshow.PlayRecordPageVO;

/**
 * <p>
 * 播放记录表 服务类
 * </p>
 *
 * @author htg
 * @since 2019-07-11
 */
public interface IPlayRecordService extends IService<PlayRecord> {

    CommonResult<RespPage<PlayRecordPageVO>> queryPlayRecordByPage(PlayRecordPageDTO playRecordDTO);

    Integer getPlayCountBySN(String sn);


}
