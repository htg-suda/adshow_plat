package com.htg.user.service;

import com.baomidou.mybatisplus.service.IService;
import com.htg.common.dto.seller.shop.SellerAddDto;
import com.htg.common.dto.seller.system.*;
import com.htg.common.entity.seller.SellerInfo;
import com.htg.common.entity.seller.SellerStore;
import com.htg.common.exception.GlobalException;
import com.htg.common.result.CommonResult;
import com.htg.common.result.RespId;
import com.htg.common.result.RespPage;
import com.htg.common.vo.seller.shop.SellerInfoDetailsVo;
import com.htg.common.vo.seller.system.SysSellerInfoDetailsVo;
import com.htg.common.vo.seller.system.SysSellerListItem;
import com.htg.common.vo.seller.system.SysVerifySellerListItem;

/**
 * <p>
 * 卖家/商户信息表 服务类
 * </p>
 *
 * @author htg
 * @since 2019-06-12
 */
public interface ISellerInfoService extends IService<SellerInfo> {

    CommonResult<RespId> addSeller(SellerAddDto sellerAddDto) throws GlobalException;

    CommonResult<RespId> addStore(SellerStore sellerStore) throws GlobalException;

    CommonResult<RespPage<SysVerifySellerListItem>> getSellerVerfiyList(SellerVerifyListDto listDto);


    CommonResult<SellerInfoDetailsVo> getSellerInfoDetails(Integer userId) throws GlobalException;

    CommonResult verifySellerInfo(SellerVerifyDto verifyDto);


    SellerInfo getSellerInfo(Integer userId) throws GlobalException;

    SellerStore getStoreByUserId(Integer userId) throws GlobalException;


    CommonResult<RespId> addSysSeller(SysSellerAddDto sysSellerAddDto)   throws GlobalException;

    CommonResult<SysSellerInfoDetailsVo> sysGetSellerInfoById(Integer sellerId);

    CommonResult sysModifySellerDto(SysSellerModifyDto sellerModifyDto);

    SellerInfo getSellerInfoBySN(String sellerSN);

    CommonResult<RespPage<SysSellerListItem>> getSellerList(SellerListDto listDto);
}
