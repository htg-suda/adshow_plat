package com.htg.common.entity.adshow;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.htg.common.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;

/**
 * <p>
 * 机构表
 * </p>
 *
 * @author htg
 * @since 2019-07-02
 */
@TableName("sr_agency")
public class Agency extends BaseEntity {

    private static final long serialVersionUID = 1L;


    @ApiModelProperty(value = "机构id", hidden = true)
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;


    @NotNull(message = "父机构id不能为空")
    @ApiModelProperty(value = "父机构id,0为根节点", example = "0")
    @TableField("parent_id")
    private Integer parentId;


    @ApiModelProperty(value = "机构编号", example = "0010", hidden = true)
    @TableField("num")
    private String num;
    /**
     *
     */
    @Length(max = 16, min = 1, message = "机构名不能大于16位")
    @NotBlank(message = "机构名不能为空")
    @ApiModelProperty(value = "机构名", example = "上海办事处")
    @TableField("name")
    private String name;

    @Length(max = 16, min = 1, message = "机构联系人姓名不能大于16位")
    @NotBlank(message = "机构联系人姓名不能为空")
    @ApiModelProperty(value = "机构联系人", example = "小明")
    @TableField("contact")
    private String contact;

    @Pattern(regexp = "^[1](([3|5|8][\\d])|([4][5,6,7,8,9])|([6][5,6])|([7][3,4,5,6,7,8])|([9][8,9]))[\\d]{8}$",
            message = "手机号码不合法")
    @NotBlank(message = "机构联系手机号码不能为空")
    @ApiModelProperty(value = "机构联系手机号码", example = "18717919375")
    @TableField("contact_num")
    private String contactNum;
    /**
     * 省
     */

    @NotNull(message = "省不能为空")
    @ApiModelProperty(value = "省ID", example = "1001")
    @TableField("province")
    private Integer province;


    @NotNull(message = "市不能为空")
    @ApiModelProperty(value = "市ID", example = "1002")
    @TableField("city")
    private Integer city;


    @NotNull(message = "县/区不能为空")
    @ApiModelProperty(value = "县/区 ID", example = "1003")
    @TableField("county")
    private Integer county;

    @Length(max = 100, min = 1, message = "地址详情不能大于100位")
    @NotBlank(message = "详情地址不能为空")
    @ApiModelProperty(value = "详情地址", example = "上海办事处")
    @TableField("address_detail")
    private String addressDetail;


    @Length(max = 255, message = "机构备注不能大于255位")
    @ApiModelProperty(value = "机构备注", example = "从前有坐山,山里有坐庙...")
    @TableField("remark")
    private String remark;

    @NotNull(message = "排序字不能为空")
    @ApiModelProperty(value = "分类排序字段 0~100,越小越靠前", example = "66")
    @Min(value = 0, message = "排序字不可小于0")
    @Max(value = 100, message = "排序字不可大于100")
    @TableField("sort")
    private Integer sort;


    @ApiModelProperty(value = " 删除状态,0-有效,-1 -删除", example = "0", hidden = true)
    @TableField("del_flag")
    private Integer delFlag;


    public Integer getId() {
        return id;
    }

    public Agency setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getParentId() {
        return parentId;
    }

    public Agency setParentId(Integer parentId) {
        this.parentId = parentId;
        return this;
    }

    public String getNum() {
        return num;
    }

    public Agency setNum(String num) {
        this.num = num;
        return this;
    }

    public String getName() {
        return name;
    }

    public Agency setName(String name) {
        this.name = name;
        return this;
    }

    public String getContact() {
        return contact;
    }

    public Agency setContact(String contact) {
        this.contact = contact;
        return this;
    }

    public String getContactNum() {
        return contactNum;
    }

    public Agency setContactNum(String contactNum) {
        this.contactNum = contactNum;
        return this;
    }

    public Integer getProvince() {
        return province;
    }

    public Agency setProvince(Integer province) {
        this.province = province;
        return this;
    }

    public Integer getCity() {
        return city;
    }

    public Agency setCity(Integer city) {
        this.city = city;
        return this;
    }

    public Integer getCounty() {
        return county;
    }

    public Agency setCounty(Integer county) {
        this.county = county;
        return this;
    }

    public String getAddressDetail() {
        return addressDetail;
    }

    public Agency setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail;
        return this;
    }

    public String getRemark() {
        return remark;
    }

    public Agency setRemark(String remark) {
        this.remark = remark;
        return this;
    }

    public Integer getSort() {
        return sort;
    }

    public Agency setSort(Integer sort) {
        this.sort = sort;
        return this;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public Agency setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
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
                ", delFlag=" + delFlag +
                "}";
    }
}
