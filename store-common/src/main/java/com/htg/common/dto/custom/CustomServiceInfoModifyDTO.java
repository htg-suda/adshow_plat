package com.htg.common.dto.custom;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CustomServiceInfoModifyDTO {
    @NotNull(message = "客服ID 不可为空")
    @ApiModelProperty(value = "客服ID",example = "1")
    private Integer id;

    @NotBlank(message = "客服昵称不能为空")
    @ApiModelProperty(value = "客服昵称", example = "会飞的鱼", required = true)
    private String serviceName;


    @NotBlank(message = "客服真实姓名不能为空")
    @ApiModelProperty(value = "客服真实姓名", example = "张三", required = true)
    private String realName;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }










}
