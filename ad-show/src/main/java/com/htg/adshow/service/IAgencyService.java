package com.htg.adshow.service;

import com.htg.common.dto.adshow.AgencyModifyDTO;
import com.htg.common.dto.adshow.AgencyPageDTO;
import com.htg.common.entity.adshow.Agency;
import com.baomidou.mybatisplus.service.IService;
import com.htg.common.result.CommonResult;
import com.htg.common.result.RespId;
import com.htg.common.result.RespList;
import com.htg.common.result.RespPage;
import com.htg.common.vo.adshow.AgencyPageVO;
import com.htg.common.vo.adshow.AgencyVO;

/**
 * <p>
 * 机构表 服务类
 * </p>
 *
 * @author htg
 * @since 2019-07-02
 */
public interface IAgencyService extends IService<Agency> {

    CommonResult<RespId> addAgency(Agency agency);

    CommonResult<RespList<AgencyVO>> getAgencyByParentId(Integer parentId);

    CommonResult<RespPage<AgencyPageVO>> selectByPage(AgencyPageDTO agencyPageDTO);

    CommonResult modifyAgency(AgencyModifyDTO agencyModifyDTO);
}
