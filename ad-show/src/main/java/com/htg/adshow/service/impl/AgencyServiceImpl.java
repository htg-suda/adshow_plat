package com.htg.adshow.service.impl;
import com.baomidou.mybatisplus.plugins.Page;
import com.htg.adshow.utils.SnowFlakeUtil;
import com.htg.common.constant.Del_FLAG;
import com.htg.common.dto.adshow.AgencyModifyDTO;
import com.htg.common.dto.adshow.AgencyPageDTO;
import com.htg.common.entity.adshow.Agency;
import com.htg.adshow.mapper.AgencyMapper;
import com.htg.adshow.service.IAgencyService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.htg.common.exception.GlobalException;
import com.htg.common.result.*;
import com.htg.common.vo.adshow.AgencyPageVO;
import com.htg.common.vo.adshow.AgencyVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 机构表 服务实现类
 * </p>
 *
 * @author htg
 * @since 2019-07-02
 */
@Service
public class AgencyServiceImpl extends ServiceImpl<AgencyMapper, Agency> implements IAgencyService {
    /* 添加机构*/
    @Override
    public CommonResult<RespId> addAgency(Agency agency) {
        Agency agencyExt=  baseMapper.selectByName(agency.getName());
        if(agencyExt!=null) throw new GlobalException(CodeEnum.AGENCY_NAME_HAS_EXIST);
        Integer parentId = agency.getParentId();
        if(parentId!=0 && baseMapper.selectById(parentId)==null) throw new GlobalException(CodeEnum.AGENCY_PARENT_NOT_EXIST);
        agency.setNum(SnowFlakeUtil.getFlowIdInstance().nextId() + "");
        agency.setDelFlag(Del_FLAG.EXISTED);
        if (insert(agency)) return CommonResult.success(new RespId(agency.getId()));
        return CommonResult.error("添加失败");
    }

    @Override
    public CommonResult<RespList<AgencyVO>> getAgencyByParentId(Integer parentId) {
        List<Agency> agencyList = baseMapper.selectByParentId(parentId);
        List<AgencyVO> agencyVOList = new ArrayList<>();
        agencyList.forEach((value) -> {
            AgencyVO agencyVo = new AgencyVO();
            BeanUtils.copyProperties(value, agencyVo);
            agencyVOList.add(agencyVo);
        });
        return CommonResult.success(new RespList<>(agencyVOList));
    }

    @Override
    public CommonResult<RespPage<AgencyPageVO>> selectByPage(AgencyPageDTO agencyPageDTO) {
        Page<AgencyPageVO> page = new Page<>(agencyPageDTO.getPageNum(), agencyPageDTO.getPageSize());
        String contact = agencyPageDTO.getContact();
        String contactNum = agencyPageDTO.getContactNum();
        if (contact != null) {
            contact = "%" + contact + "%";
        }
        String num = agencyPageDTO.getNum();
        List<AgencyPageVO> agencyPageVOList = baseMapper.selectByPage(page, num, contact, contactNum);
        return CommonResult.success(new RespPage<>(agencyPageVOList, page.getTotal()));
    }

    @Override
    public CommonResult modifyAgency(AgencyModifyDTO agencyModifyDTO) {
        Agency agencyExt=  baseMapper.selectByName(agencyModifyDTO.getName());

        if(agencyExt!=null && agencyExt.getId()!=agencyModifyDTO.getId()) throw new GlobalException(CodeEnum.AGENCY_NAME_HAS_EXIST);
        Integer agencyId = agencyModifyDTO.getId();
        if (selectById(agencyId) == null) throw new GlobalException(CodeEnum.AGENCY_NOT_EXIST);
        Integer parentId = agencyModifyDTO.getParentId();
        if (parentId != 0 && selectById(parentId) == null) throw new GlobalException(CodeEnum.AGENCY_PARENT_NOT_EXIST);
        Agency agency = new Agency();

        BeanUtils.copyProperties(agencyModifyDTO, agency);
        if (updateById(agency)) {
            return CommonResult.success("修改成功");
        } else {
            return CommonResult.error("修改失败");
        }
    }

}
