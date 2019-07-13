package com.htg.common.dto.adshow;

import com.baomidou.mybatisplus.annotations.TableField;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class DeviceAddDTO {

    @NotNull(message = "设备类型不能为空")
    @ApiModelProperty(value = "设备类型, 1-投影仪,2-直立屏幕,3-86盒", example = "1")
    @TableField("type")
    private Integer type;


    @NotBlank(message = "商户编号不能为空")
    @ApiModelProperty(value = "商户编号", example = "10086")
    @TableField("seller_sn")
    private String sellerSn;


    /**
     * 屏幕 高度 1920
     */
    @NotNull(message = "屏幕高度不能为空")
    @ApiModelProperty(value = "屏幕 高度", example = "1920")
    @TableField("height")
    private Integer height;

    /**
     * 屏幕 宽度 1080
     */
    @NotNull(message = "屏幕宽度不能为空")
    @ApiModelProperty(value = "屏幕 宽度", example = "1200")
    @TableField("width")
    private Integer width;


    /**
     * 设备mac 地址
     */
    @NotBlank(message = "设备mac地址不能为空")
    @ApiModelProperty(value = "设备mac 地址", example = "ef:89:90:88")
    @TableField("mac")
    private String mac;
    /**
     * IP 地址
     */

    @ApiModelProperty(value = "设备IP地址", example = "192.168.2.145")
    @TableField("ip_address")
    private String ipAddress;
    /**
     * 端口号码
     */
    @ApiModelProperty(value = "端口号", example = "8829")
    @TableField("port")
    private String port;


    @ApiModelProperty(value = "设备音量", example = "5")
    @TableField("volume")
    private Integer volume;
    /**
     * 系统版本
     */
    @Length(max = 20, min = 1, message = "系统版本长度不能大于20位")
    @ApiModelProperty(value = "系统版本", example = "android9.0")
    @TableField("system_version")
    private String systemVersion;
    /**
     * 应用版本
     */
    @Length(max = 20, min = 1, message = "应用版本长度不能大于20位")
    @ApiModelProperty(value = "系统版本", example = "1.2.0")
    @TableField("app_version")
    private String appVersion;


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

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        return "DeviceAddDTO{" +
                "type=" + type +
                ", sellerSn='" + sellerSn + '\'' +
                ", height=" + height +
                ", width=" + width +
                ", mac='" + mac + '\'' +
                ", ipAddress='" + ipAddress + '\'' +
                ", port='" + port + '\'' +
                ", volume=" + volume +
                ", systemVersion='" + systemVersion + '\'' +
                ", appVersion='" + appVersion + '\'' +
                '}';
    }
}
