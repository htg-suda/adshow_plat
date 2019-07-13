package com.htg.common.dto.adshow;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;

public class AgencyModifyDTO {

    @NotNull(message = "机构id不能为空")
    @ApiModelProperty(value = "机构id",example = "0")
    private Integer id;


    @NotNull(message = "父机构id不能为空")
    @ApiModelProperty(value = "父机构id,0为根节点", example = "0")
    private Integer parentId;


    @Length(max = 16, min = 1, message = "机构名不能大于16位")
    @NotBlank(message = "机构名不能为空")
    @ApiModelProperty(value = "机构名", example = "上海办事处")
    private String name;

    @Length(max = 16, min = 1, message = "机构联系人姓名不能大于16位")
    @NotBlank(message = "机构联系人姓名不能为空")
    @ApiModelProperty(value = "机构联系人", example = "小明")
    private String contact;

    @Pattern(regexp = "^[1](([3|5|8][\\d])|([4][5,6,7,8,9])|([6][5,6])|([7][3,4,5,6,7,8])|([9][8,9]))[\\d]{8}$",
            message = "手机号码不合法")
    @NotBlank(message = "机构联系手机号码不能为空")
    @ApiModelProperty(value = "机构联系手机号码", example = "18717919375")
    private String contactNum;


    @NotNull(message = "省不能为空")
    @ApiModelProperty(value = "省ID", example = "1001")
    private Integer province;


    @NotNull(message = "市不能为空")
    @ApiModelProperty(value = "市ID", example = "1002")
    private Integer city;


    @NotNull(message = "县/区不能为空")
    @ApiModelProperty(value = "县/区 ID", example = "1003")
    private Integer county;

    @Length(max = 100, min = 1, message = "地址详情不能大于100位")
    @NotBlank(message = "详情地址不能为空")
    @ApiModelProperty(value = "详情地址", example = "1003")
    private String addressDetail;


    @Length(max = 255, message = "机构备注不能大于255位")
    @ApiModelProperty(value = "机构备注", example = "从前有坐山,山里有坐庙...")
    private String remark;

    @NotNull(message = "排序字不能为空")
    @ApiModelProperty(value = "分类排序字段 0~100,越小越靠前", example = "66")
    @Min(value = 0, message = "排序字不可小于0")
    @Max(value = 100, message = "排序字不可大于100")
    private Integer sort;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getContactNum() {
        return contactNum;
    }

    public void setContactNum(String contactNum) {
        this.contactNum = contactNum;
    }

    public Integer getProvince() {
        return province;
    }

    public void setProvince(Integer province) {
        this.province = province;
    }

    public Integer getCity() {
        return city;
    }

    public void setCity(Integer city) {
        this.city = city;
    }

    public Integer getCounty() {
        return county;
    }

    public void setCounty(Integer county) {
        this.county = county;
    }

    public String getAddressDetail() {
        return addressDetail;
    }

    public void setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
