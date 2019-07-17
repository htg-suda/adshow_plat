package com.htg.adshow.service;

import com.baomidou.mybatisplus.service.IService;
import com.htg.common.dto.adshow.MsgRecordPageDTO;
import com.htg.common.entity.adshow.MsgRecord;
import com.htg.common.result.CommonResult;
import com.htg.common.result.RespPage;
import com.htg.common.vo.adshow.MsgRecordVO;

import java.util.List;

/**
 * <p>
 * 消息记录表 服务类
 * </p>
 *
 * @author htg
 * @since 2019-07-11
 */
public interface IMsgRecordService extends IService<MsgRecord> {

    CommonResult<RespPage<MsgRecordVO>> selectByPage(MsgRecordPageDTO msgRecordPageDTO);

}
