package com.htg.common.vo.adshow;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.htg.common.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * <p>
 * 终端设备表
 * </p>
 *
 * @author htg
 * @since 2019-07-02
 */
public class DeviceDetailVo  {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "终端设备id")
    private Integer id;


    @ApiModelProperty(value = "设备名", example = "小米投影仪")
    private String name;


    @ApiModelProperty(value = "设备编号", example = "05150")
    private String num;
    /**
     * 终端序列号码
     */
    @ApiModelProperty(value = "终端序列号", example = "05150")
    private String sn;


    @ApiModelProperty(value = "设备类型, 1-投影仪,2-直立屏幕,3-86盒", example = "1")
    private Integer type;


    @ApiModelProperty(value = "商户编号", example = "10086")
    private String sellerSn;


    @ApiModelProperty(value = "商户名,对于企业商户就是企业名,对于个人商户就是管理员的名字", example = "招财猫",hidden = true)
    private String sellerName;


    /**
     * 屏幕 高度 1920
     */
    @ApiModelProperty(value = "屏幕 高度", example = "1920")
    private Integer height;

    /**
     * 屏幕 宽度 1080
     */
    @ApiModelProperty(value = "屏幕 宽度", example = "1200")
    private Integer width;


    /**
     * 设备mac 地址
     */
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
     * 省
     */
    @ApiModelProperty(value = "省ID", example = "1001")
    private Integer province;
    /**
     * 市
     */
    @ApiModelProperty(value = "市ID", example = "1001")
    private Integer city;
    /**
     * 县/区
     */
    @ApiModelProperty(value = "县/区ID", example = "1001")
    private Integer county;
    /**
     * 地址详情
     */
    @ApiModelProperty(value = "地址详情", example = "1001")
    private String addressDetail;
    /**
     * 设备所在经度
     */
    @ApiModelProperty(value = "设备所在经度", example = "22.07")
    private String longitude;
    /**
     * 设备所在纬度
     */
    @ApiModelProperty(value = "设备所在纬度", example = "33.87")
    private String latitude;
    /**
     * 设备规格
     */
    @ApiModelProperty(value = "设备规格", example = "从前有坐山,山里有坐庙")
    private String spec;
    /**
     * 设备备注
     */
    @ApiModelProperty(value = "设备规格", example = "从前有坐山,山里有坐庙")
    private String remark;
    /**
     * 音量
     */

    @ApiModelProperty(value = "设备音量", example = "5")
    private Integer volume;
    /**
     * 系统版本
     */
    @ApiModelProperty(value = "系统版本", example = "android9.0")
    private String systemVersion;
    /**
     * 应用版本
     */
    @ApiModelProperty(value = "系统版本", example = "1.2.0")
    private String appVersion;


    @ApiModelProperty(value = "设备状态 ,0-未认证,1-启用,2-停用", example = "1")
    private Integer status;


    @ApiModelProperty(value = " 设备在线状态,0-离线,1-在线,2-未知", example = "0")
    private Integer onlineStatus;

    @ApiModelProperty(value = "每天的开机时间", example = "10:00:00")
    private String openTime;


    @ApiModelProperty(value = "每天的关机时间", example = "22:00:00")
    private String closeTime;




    public Integer getId() {
        return id;
    }

    public DeviceDetailVo setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public DeviceDetailVo setName(String name) {
        this.name = name;
        return this;
    }

    public String getNum() {
        return num;
    }

    public DeviceDetailVo setNum(String num) {
        this.num = num;
        return this;
    }

    public String getSn() {
        return sn;
    }

    public DeviceDetailVo setSn(String sn) {
        this.sn = sn;
        return this;
    }

    public Integer getType() {
        return type;
    }

    public DeviceDetailVo setType(Integer type) {
        this.type = type;
        return this;
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

    public DeviceDetailVo setHeight(Integer height) {
        this.height = height;
        return this;
    }

    public Integer getWidth() {
        return width;
    }

    public DeviceDetailVo setWidth(Integer width) {
        this.width = width;
        return this;
    }

    public String getMac() {
        return mac;
    }

    public DeviceDetailVo setMac(String mac) {
        this.mac = mac;
        return this;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public DeviceDetailVo setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
        return this;
    }

    public String getPort() {
        return port;
    }

    public DeviceDetailVo setPort(String port) {
        this.port = port;
        return this;
    }

    public Integer getProvince() {
        return province;
    }

    public DeviceDetailVo setProvince(Integer province) {
        this.province = province;
        return this;
    }

    public Integer getCity() {
        return city;
    }

    public DeviceDetailVo setCity(Integer city) {
        this.city = city;
        return this;
    }

    public Integer getCounty() {
        return county;
    }

    public DeviceDetailVo setCounty(Integer county) {
        this.county = county;
        return this;
    }

    public String getAddressDetail() {
        return addressDetail;
    }

    public DeviceDetailVo setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail;
        return this;
    }

    public String getLongitude() {
        return longitude;
    }

    public DeviceDetailVo setLongitude(String longitude) {
        this.longitude = longitude;
        return this;
    }

    public String getLatitude() {
        return latitude;
    }

    public DeviceDetailVo setLatitude(String latitude) {
        this.latitude = latitude;
        return this;
    }

    public String getSpec() {
        return spec;
    }

    public DeviceDetailVo setSpec(String spec) {
        this.spec = spec;
        return this;
    }

    public String getRemark() {
        return remark;
    }

    public DeviceDetailVo setRemark(String remark) {
        this.remark = remark;
        return this;
    }

    public Integer getVolume() {
        return volume;
    }

    public DeviceDetailVo setVolume(Integer volume) {
        this.volume = volume;
        return this;
    }

    public String getSystemVersion() {
        return systemVersion;
    }

    public DeviceDetailVo setSystemVersion(String systemVersion) {
        this.systemVersion = systemVersion;
        return this;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public DeviceDetailVo setAppVersion(String appVersion) {
        this.appVersion = appVersion;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public DeviceDetailVo setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public Integer getOnlineStatus() {
        return onlineStatus;
    }

    public DeviceDetailVo setOnlineStatus(Integer onlineStatus) {
        this.onlineStatus = onlineStatus;
        return this;
    }

    public String getOpenTime() {
        return openTime;
    }

    public DeviceDetailVo setOpenTime(String openTime) {
        this.openTime = openTime;
        return this;
    }

    public String getCloseTime() {
        return closeTime;
    }

    public DeviceDetailVo setCloseTime(String closeTime) {
        this.closeTime = closeTime;
        return this;
    }



    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    @Override
    public String toString() {
        return "Device{" +
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
                ", province=" + province +
                ", city=" + city +
                ", county=" + county +
                ", addressDetail='" + addressDetail + '\'' +
                ", longitude='" + longitude + '\'' +
                ", latitude='" + latitude + '\'' +
                ", spec='" + spec + '\'' +
                ", remark='" + remark + '\'' +
                ", volume=" + volume +
                ", systemVersion='" + systemVersion + '\'' +
                ", appVersion='" + appVersion + '\'' +
                ", status=" + status +
                ", onlineStatus=" + onlineStatus +
                ", openTime='" + openTime + '\'' +
                ", closeTime='" + closeTime + '\'' +
                '}';
    }
}
