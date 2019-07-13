package com.htg.common.vo.adshow;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class DeviceInfoVo {
    @ApiModelProperty(value = "终端设备id", hidden = true)
    private Integer id;


    @NotBlank(message = "终端名不能为空")
    @ApiModelProperty(value = "设备名", example = "小米投影仪")
    private String name;


    @NotBlank(message = "终端编号不能为空")
    @ApiModelProperty(value = "设备编号", example = "05150")
    private String num;
    /**
     * 终端序列号码
     */
    @NotBlank(message = "终端序列号不能为空")
    @ApiModelProperty(value = "终端序列号", example = "05150")
    private String sn;


    @NotNull(message = "设备类型不能为空")
    @ApiModelProperty(value = "设备类型, 1-投影仪,2-直立屏幕,3-86盒", example = "1")
    private Integer type;


    @NotBlank(message = "商户编号不能为空")
    @ApiModelProperty(value = "商户编号", example = "10086")
    private String sellerSn;


    @ApiModelProperty(value = "商户名,对于企业商户就是企业名,对于个人商户就是管理员的名字", example = "招财猫", hidden = true)
    private String sellerName;


    /**
     * 屏幕 高度 1920
     */
    @NotNull(message = "屏幕高度不能为空")
    @ApiModelProperty(value = "屏幕 高度", example = "1920")
    private Integer height;

    /**
     * 屏幕 宽度 1080
     */
    @NotNull(message = "屏幕宽度不能为空")
    @ApiModelProperty(value = "屏幕 宽度", example = "1200")
    private Integer width;


    /**
     * 设备mac 地址
     */
    @NotBlank(message = "设备mac地址不能为空")
    @ApiModelProperty(value = "设备mac 地址", example = "ef:89:90:88")
    private String mac;
    /**
     * IP 地址
     */

    @ApiModelProperty(value = "设备IP地址", example = "192.168.2.145")
    private String ipAddress;
    /**
     * 端口号码
     */
    @ApiModelProperty(value = "端口号", example = "8829")
    private String port;

    /**
     * 音量
     */

    @ApiModelProperty(value = "设备音量", example = "5")
    private Integer volume;
    /**
     * 系统版本
     */
    @Length(max = 20, min = 1, message = "系统版本长度不能大于20位")
    @ApiModelProperty(value = "系统版本", example = "android9.0")
    private String systemVersion;
    /**
     * 应用版本
     */
    @Length(max = 20, min = 1, message = "应用版本长度不能大于20位")
    @ApiModelProperty(value = "系统版本", example = "1.2.0")
    private String appVersion;


    @ApiModelProperty(value = "设备状态 ,0-未认证,1-启用,2-停用", example = "1")
    private Integer status;

    @ApiModelProperty(value = "更新时间", example = "1")
    private Date updateTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getSellerSn() {
        return sellerSn;
    }

    public void setSellerSn(String sellerSn) {
        this.sellerSn = sellerSn;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public String getSystemVersion() {
        return systemVersion;
    }

    public void setSystemVersion(String systemVersion) {
        this.systemVersion = systemVersion;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "DeviceInfoVo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", num='" + num + '\'' +
                ", sn='" + sn + '\'' +
                ", type=" + type +
                ", sellerSn='" + sellerSn + '\'' +
                ", sellerName='" + sellerName + '\'' +
                ", height=" + height +
                ", width=" + width +
                ", mac='" + mac + '\'' +
                ", ipAddress='" + ipAddress + '\'' +
                ", port='" + port + '\'' +
                ", volume=" + volume +
                ", systemVersion='" + systemVersion + '\'' +
                ", appVersion='" + appVersion + '\'' +
                ", status=" + status +
                ", updateTime=" + updateTime +
                '}';
    }
}
