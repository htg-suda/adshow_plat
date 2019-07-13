package com.htg.common.dto.custom;

import com.htg.common.dto.seller.user.SrUserDto;
import com.htg.common.entity.custom.CustomServiceInfo;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class CustomServiceUserDTO {
    @Valid
    @NotNull(message = "用户基本信息不能为空")
    private SrUserDto srUserDto;

    @Valid
    @NotNull(message = "客服基本信息不能为空")
    private CustomServiceInfo customServiceInfo;


    public SrUserDto getSrUserDto() {
        return srUserDto;
    }

    public void setSrUserDto(SrUserDto srUserDto) {
        this.srUserDto = srUserDto;
    }

    public CustomServiceInfo getCustomServiceInfo() {
        return customServiceInfo;
    }

    public void setCustomServiceInfo(CustomServiceInfo customServiceInfo) {
        this.customServiceInfo = customServiceInfo;
    }

    @Override
    public String toString() {
        return "CustomServiceUserDTO{" +
                "srUserDto=" + srUserDto +
                ", customServiceInfo=" + customServiceInfo +
                '}';
    }
}
