package com.htg.common.entity.adshow;

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
@TableName("sr_device")
public class Device extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "终端设备id", hidden = true)
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;


    @NotBlank(message = "终端名不能为空")
    @ApiModelProperty(value = "设备名", example = "小米投影仪")
    @TableField("name")
    private String name;


    @NotBlank(message = "终端编号不能为空")
    @ApiModelProperty(value = "设备编号", example = "05150")
    @TableField("num")
    private String num;
    /**
     * 终端序列号码
     */
    @NotBlank(message = "终端序列号不能为空")
    @ApiModelProperty(value = "终端序列号", example = "05150")
    @TableField("sn")
    private String sn;


    @NotNull(message = "设备类型不能为空")
    @ApiModelProperty(value = "设备类型, 1-投影仪,2-直立屏幕,3-86盒", example = "1")
    @TableField("type")
    private Integer type;


    @NotBlank(message = "商户编号不能为空")
    @ApiModelProperty(value = "商户编号", example = "10086")
    @TableField("seller_sn")
    private String sellerSn;


    @ApiModelProperty(value = "商户名,对于企业商户就是企业名,对于个人商户就是管理员的名字", example = "招财猫",hidden = true)
    @TableField("seller_name")
    private String sellerName;


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
    @Length(max = 255, min = 1, message = "设备规格不能大于255位")
    @ApiModelProperty(value = "设备规格", example = "从前有坐山,山里有坐庙")
    @TableField("spec")
    private String spec;
    /**
     * 设备备注
     */
    @Length(max = 255, min = 1, message = "设备备注不能大于255位")
    @ApiModelProperty(value = "设备规格", example = "从前有坐山,山里有坐庙")
    @TableField("remark")
    private String remark;
    /**
     * 音量
     */

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


    @ApiModelProperty(value = "设备状态 ,0-未认证,1-启用,2-停用", example = "1")
    @TableField("status")
    private Integer status;


    @ApiModelProperty(value = " 设备在线状态,0-离线,1-在线,2-未知", example = "0")
    @TableField("online_status")
    private Integer onlineStatus;

    @Pattern(regexp = "[0-2][0-3]:[0-5][0-9]:[0-5][0-9]", message = "开机时间格式错误")
    @ApiModelProperty(value = "每天的开机时间", example = "10:00:00")
    @TableField("open_time")
    private String openTime;


    @Pattern(regexp = "[0-2][0-3]:[0-5][0-9]:[0-5][0-9]", message = "关机时间格式错误")
    @ApiModelProperty(value = "每天的关机时间", example = "22:00:00")
    @TableField("close_time")
    private String closeTime;


    @ApiModelProperty(value = " 删除状态,0-有效,-1 -删除", example = "0", hidden = true)
    @TableField("del_flag")
    private Integer delFlag;


    public Integer getId() {
        return id;
    }

    public Device setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Device setName(String name) {
        this.name = name;
        return this;
    }

    public String getNum() {
        return num;
    }

    public Device setNum(String num) {
        this.num = num;
        return this;
    }

    public String getSn() {
        return sn;
    }

    public Device setSn(String sn) {
        this.sn = sn;
        return this;
    }

    public Integer getType() {
        return type;
    }

    public Device setType(Integer type) {
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

    public Device setHeight(Integer height) {
        this.height = height;
        return this;
    }

    public Integer getWidth() {
        return width;
    }

    public Device setWidth(Integer width) {
        this.width = width;
        return this;
    }

    public String getMac() {
        return mac;
    }

    public Device setMac(String mac) {
        this.mac = mac;
        return this;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public Device setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
        return this;
    }

    public String getPort() {
        return port;
    }

    public Device setPort(String port) {
        this.port = port;
        return this;
    }

    public Integer getProvince() {
        return province;
    }

    public Device setProvince(Integer province) {
        this.province = province;
        return this;
    }

    public Integer getCity() {
        return city;
    }

    public Device setCity(Integer city) {
        this.city = city;
        return this;
    }

    public Integer getCounty() {
        return county;
    }

    public Device setCounty(Integer county) {
        this.county = county;
        return this;
    }

    public String getAddressDetail() {
        return addressDetail;
    }

    public Device setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail;
        return this;
    }

    public String getLongitude() {
        return longitude;
    }

    public Device setLongitude(String longitude) {
        this.longitude = longitude;
        return this;
    }

    public String getLatitude() {
        return latitude;
    }

    public Device setLatitude(String latitude) {
        this.latitude = latitude;
        return this;
    }

    public String getSpec() {
        return spec;
    }

    public Device setSpec(String spec) {
        this.spec = spec;
        return this;
    }

    public String getRemark() {
        return remark;
    }

    public Device setRemark(String remark) {
        this.remark = remark;
        return this;
    }

    public Integer getVolume() {
        return volume;
    }

    public Device setVolume(Integer volume) {
        this.volume = volume;
        return this;
    }

    public String getSystemVersion() {
        return systemVersion;
    }

    public Device setSystemVersion(String systemVersion) {
        this.systemVersion = systemVersion;
        return this;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public Device setAppVersion(String appVersion) {
        this.appVersion = appVersion;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public Device setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public Integer getOnlineStatus() {
        return onlineStatus;
    }

    public Device setOnlineStatus(Integer onlineStatus) {
        this.onlineStatus = onlineStatus;
        return this;
    }

    public String getOpenTime() {
        return openTime;
    }

    public Device setOpenTime(String openTime) {
        this.openTime = openTime;
        return this;
    }

    public String getCloseTime() {
        return closeTime;
    }

    public Device setCloseTime(String closeTime) {
        this.closeTime = closeTime;
        return this;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public Device setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
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
                ", delFlag=" + delFlag +
                '}';
    }
}
