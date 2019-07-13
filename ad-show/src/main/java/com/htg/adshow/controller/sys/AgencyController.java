package com.htg.adshow.controller.sys;

import com.htg.adshow.service.IAgencyService;
import com.htg.common.dto.adshow.AgencyModifyDTO;
import com.htg.common.dto.adshow.AgencyPageDTO;
import com.htg.common.entity.adshow.Agency;
import com.htg.common.exception.GlobalException;
import com.htg.common.result.*;
import com.htg.common.vo.adshow.AgencyPageVO;
import com.htg.common.vo.adshow.AgencyVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * <p>
 * 机构表 前端控制器
 * </p>
 *
 * @author htg
 * @since 2019-07-02
 */
@Slf4j
@Api(value = "AgencyController", tags = "02-机构管理")
@RestController
@Validated
@RequestMapping("/agency")
public class AgencyController {
    @Autowired
    private IAgencyService agencyService;

    /* 添加机构 */
    /* 获取用户信息*/
    @ApiOperation(value = "添加机构")
    @ResponseBody
    @PostMapping("/add")
    public CommonResult<RespId> addAgency(@Valid @RequestBody Agency agency) throws GlobalException {
        return agencyService.addAgency(agency);
    }

    /* 获取机构 */
    @ApiOperation(value = "根据 parentId,获取 机构")
    @ResponseBody
    @GetMapping("/list/{parentId}")
    public CommonResult<RespList<AgencyVO>> getAgencyByParentId(@PathVariable("parentId") Integer parentId) throws GlobalException {
        return agencyService.getAgencyByParentId(parentId);
    }

    /* 根据 id 获取 机构 */

    /* 获取机构 */
    @ApiOperation(value = "根据机构id获取机构")
    @ResponseBody
    @GetMapping("/info/{agencyId}")
    public CommonResult<AgencyVO> getAgencyId(@PathVariable("agencyId") Integer agencyId) throws GlobalException {
        Agency agency = agencyService.selectById(agencyId);
        if (agency == null) throw new GlobalException(CodeEnum.AGENCY_NOT_EXIST);
        AgencyVO agencyVo = new AgencyVO();
        BeanUtils.copyProperties(agency, agencyVo);
        return CommonResult.success(agencyVo);
    }

    /* 修改机构 */
    @ApiOperation(value = "修改机构")
    @ResponseBody
    @PostMapping("/modify")
    public CommonResult modifyAgency(@Valid @RequestBody AgencyModifyDTO agencyModifyDTO) throws GlobalException {
        return agencyService.modifyAgency(agencyModifyDTO);
    }

    /* 查询机构并且 分页 */
    @ApiOperation(value = "查询机构")
    @ResponseBody
    @PostMapping("/list")
    public CommonResult<RespPage<AgencyPageVO>> getAgencyByPage(@Valid @RequestBody AgencyPageDTO agencyPageDTO) throws GlobalException {
        return agencyService.selectByPage(agencyPageDTO);
    }


}

