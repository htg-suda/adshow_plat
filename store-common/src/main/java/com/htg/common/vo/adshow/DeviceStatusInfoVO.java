package com.htg.common.vo.adshow;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DeviceStatusInfoVO {
    @ApiModelProperty(value = "设备状态,-1,设备不存在; 0,设备待认证; 1,设备已经启用 2,设备被停用", example = "0")
    private Integer status;

    @ApiModelProperty(value = "设备序列号", example = "abcd")
    private String sn;

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

    @Override
    public String toString() {
        return "DeviceStatusInfoVO{" +
                "status=" + status +
                ", sn='" + sn + '\'' +
                '}';
    }
}
