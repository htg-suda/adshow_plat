package com.htg.common.vo.adshow;

import com.htg.common.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 机构表
 * </p>
 *
 * @author htg
 * @since 2019-07-02
 */

public class AgencyVO extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 机构id
     */
    @ApiModelProperty(value = "机构id",example = "1")
    private Integer id;


    @ApiModelProperty(value = "父机构id,0为根节点", example = "0")
    private Integer parentId;
    /**
     *
     */
    @ApiModelProperty(value = "机构编号", example = "0010")
    private String num;
    /**
     *
     */
    @ApiModelProperty(value = "机构名", example = "上海办事处")
    private String name;

    @ApiModelProperty(value = "机构联系人", example = "小明")
    private String contact;

    @ApiModelProperty(value = "机构联系手机号码", example = "18717919375")
    private String contactNum;



    @ApiModelProperty(value = "省ID", example = "1001")
    private Integer province;


    @ApiModelProperty(value = "市ID", example = "1002")
    private Integer city;


    @ApiModelProperty(value = "县/区 ID", example = "1003")
    private Integer county;

    @ApiModelProperty(value = "详细地址", example = "李家屯")
    private String addressDetail;


    @ApiModelProperty(value = "机构备注", example = "从前有坐山,山里有坐庙...")
    private String remark;

    @ApiModelProperty(value = "分类排序字段 0~100,越小越靠前", example = "66")
    private Integer sort;




    public Integer getId() {
        return id;
    }

    public AgencyVO setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getParentId() {
        return parentId;
    }

    public AgencyVO setParentId(Integer parentId) {
        this.parentId = parentId;
        return this;
    }

    public String getNum() {
        return num;
    }

    public AgencyVO setNum(String num) {
        this.num = num;
        return this;
    }

    public String getName() {
        return name;
    }

    public AgencyVO setName(String name) {
        this.name = name;
        return this;
    }

    public String getContact() {
        return contact;
    }

    public AgencyVO setContact(String contact) {
        this.contact = contact;
        return this;
    }

    public String getContactNum() {
        return contactNum;
    }

    public AgencyVO setContactNum(String contactNum) {
        this.contactNum = contactNum;
        return this;
    }

    public Integer getProvince() {
        return province;
    }

    public AgencyVO setProvince(Integer province) {
        this.province = province;
        return this;
    }

    public Integer getCity() {
        return city;
    }

    public AgencyVO setCity(Integer city) {
        this.city = city;
        return this;
    }

    public Integer getCounty() {
        return county;
    }

    public AgencyVO setCounty(Integer county) {
        this.county = county;
        return this;
    }

    public String getAddressDetail() {
        return addressDetail;
    }

    public AgencyVO setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail;
        return this;
    }

    public String getRemark() {
        return remark;
    }

    public AgencyVO setRemark(String remark) {
        this.remark = remark;
        return this;
    }

    public Integer getSort() {
        return sort;
    }

    public AgencyVO setSort(Integer sort) {
        this.sort = sort;
        return this;
    }



    @Override
    public String toString() {
        return "Agency{" +
                "id=" + id +
                ", parentId=" + parentId +
                ", num=" + num +
                ", name=" + name +
                ", contact=" + contact +
                ", contactNum=" + contactNum +
                ", province=" + province +
                ", city=" + city +
                ", county=" + county +
                ", addressDetail=" + addressDetail +
                ", remark=" + remark +
                ", sort=" + sort +

                "}";
    }
}
