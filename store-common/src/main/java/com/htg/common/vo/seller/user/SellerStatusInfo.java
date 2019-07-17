package com.htg.common.vo.seller.user;

import io.swagger.annotations.ApiModelProperty;

public class SellerStatusInfo {
    @ApiModelProperty(value = "商户状态 0-未提交过商户信息 " +
            "1,商铺信息已经提交,待审核," +
            "2,已经提交商户信息,但是审核未通过," +
            "3,商户信息提交,且已经审核通过" +
            "6,商户直接被冻结"
            , example = "1")
    private Integer shopStatus;


    public Integer getShopStatus() {
        return shopStatus;
    }

    public void setShopStatus(Integer shopStatus) {
        this.shopStatus = shopStatus;
    }

    @Override
    public String toString() {
        return "SellerStatusInfo{" +
                "shopStatus=" + shopStatus +
                '}';
    }
}
