package com.htg.common.vo.adshow;

import io.swagger.annotations.ApiModelProperty;

public class AgencyPageVO {

    @ApiModelProperty(value = "机构id", example = "1")
    private Integer id;

    @ApiModelProperty(value = "机构编号", example = "0010")
    private String num;

    @ApiModelProperty(value = "机构名", example = "上海办事处")
    private String name;

    @ApiModelProperty(value = "机构联系人", example = "小明")
    private String contact;

    @ApiModelProperty(value = "机构联系手机号码", example = "18717919375")
    private String contactNum;


    @ApiModelProperty(value = "省", example = "1001")
    private String province;


    @ApiModelProperty(value = "市", example = "1002")
    private String city;


    @ApiModelProperty(value = "县/区", example = "1003")
    private String county;

    @ApiModelProperty(value = "详细地址", example = "1003")
    private String addressDetail;


    @ApiModelProperty(value = "父机构名", example = "上海办事处")
    private String parentName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
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

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getAddressDetail() {
        return addressDetail;
    }

    public void setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    @Override
    public String toString() {
        return "AgencyPageVO{" +
                "id=" + id +
                ", num='" + num + '\'' +
                ", name='" + name + '\'' +
                ", contact='" + contact + '\'' +
                ", contactNum='" + contactNum + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", county='" + county + '\'' +
                ", addressDetail='" + addressDetail + '\'' +
                ", parentName='" + parentName + '\'' +
                '}';
    }
}
