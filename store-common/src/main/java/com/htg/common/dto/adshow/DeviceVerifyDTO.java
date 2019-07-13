package com.htg.common.dto.adshow;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class DeviceVerifyDTO {

    @NotBlank(message = "终端名不能为空")
    @ApiModelProperty(value = "设备名", example = "小米投影仪")
    @TableField("name")
    private String name;

    /**
     * 终端序列号码
     */
    @NotBlank(message = "终端序列号不能为空")
    @ApiModelProperty(value = "终端序列号", example = "05150")
    @TableField("sn")
    private String sn;


    /**
     * 省
     */
    @ApiModelProperty(value = "省ID", example = "1001")
    @TableField("province")
    private Integer province;
    /**
     * 市
     */
    @ApiModelProperty(value = "市ID", example = "1001")
    @TableField("city")
    private Integer city;
    /**
     * 县/区
     */
    @ApiModelProperty(value = "县/区ID", example = "1001")
    @TableField("county")
    private Integer county;
    /**
     * 地址详情
     */
    @ApiModelProperty(value = "地址详情", example = "1001")
    @TableField("address_detail")
    private String addressDetail;
    /**
     * 设备所在经度
     */
    @ApiModelProperty(value = "设备所在经度", example = "22.07")
    @TableField("longitude")
    private String longitude;
    /**
     * 设备所在纬度
     */
    @ApiModelProperty(value = "设备所在纬度", example = "33.87")
    @TableField("latitude")
    private String latitude;
    /**
     * 设备规格
     */
    @Length(max = 255, message = "设备规格不能大于255位")
    @ApiModelProperty(value = "设备规格", example = "从前有坐山,山里有坐庙")
    @TableField("spec")
    private String spec;
    /**
     * 设备备注
     */
    @Length(max = 255, message = "设备备注不能大于255位")
    @ApiModelProperty(value = "设备规格", example = "从前有坐山,山里有坐庙")
    @TableField("remark")
    private String remark;


    @NotNull(message = "认证状态不能为空")
    @ApiModelProperty(value = "设备状态 ,0-未认证,1-启用,2-停用", example = "1")
    @TableField("status")
    private Integer status;


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "DeviceVerifyDTO{" +
                "name='" + name + '\'' +
                ", sn='" + sn + '\'' +
                ", province=" + province +
                ", city=" + city +
                ", county=" + county +
                ", addressDetail='" + addressDetail + '\'' +
                ", longitude='" + longitude + '\'' +
                ", latitude='" + latitude + '\'' +
                ", spec='" + spec + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
