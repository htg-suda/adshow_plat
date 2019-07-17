package com.htg.common.dto.adshow;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

public class SellerDevVerifyListDTO {

    @ApiModelProperty(value = "设备ID", example = "0")
    private Integer deviceId;


    @ApiModelProperty(value = "设备类型, 1-投影仪,2-直立屏幕,3-86盒", example = "1")
    private Integer type;


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


    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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


    @Override
    public String toString() {
        return "SellerDevVerifyListDTO{" +
                "deviceId=" + deviceId +
                ", type=" + type +
                ", pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                '}';
    }
}
