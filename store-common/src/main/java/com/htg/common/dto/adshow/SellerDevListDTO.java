package com.htg.common.dto.adshow;

import com.baomidou.mybatisplus.annotations.TableField;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

public class SellerDevListDTO {

    @ApiModelProperty(value = "设备ID", example = "0")
    private Integer deviceId;



    @ApiModelProperty(value = "设备状态 ,0-未认证,1-启用,2-停用", example = "1")
    @TableField("status")
    private Integer status;


    @ApiModelProperty(value = " 设备在线状态,0-离线,1-在线,2-未知", example = "0")
    @TableField("online_status")
    private Integer onlineStatus;


    @NotNull(message = "第几页不能为空")
    @ApiModelProperty(value = "第几页", example = "0")
    private Integer pageNum;

    @NotNull(message = "每页大小不能为空")
    @ApiModelProperty(value = "每页大小", example = "0")
    private Integer pageSize;


    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getOnlineStatus() {
        return onlineStatus;
    }

    public void setOnlineStatus(Integer onlineStatus) {
        this.onlineStatus = onlineStatus;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
