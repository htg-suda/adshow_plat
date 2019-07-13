package com.htg.common.dto.adshow;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.List;

public class DevModifyStatusDTO {

    @NotNull(message = "设备序列号集合")
    @ApiModelProperty(value = "设备序列号集合", example = "['abc','']")
    private List<String> snList;


    @NotNull(message = "设备状态不能为空")
    @ApiModelProperty(value = "设备状态 ,0-未认证,1-启用,2-停用", example = "1")
    private Integer status;

    public List<String> getSnList() {
        return snList;
    }

    public void setSnList(List<String> snList) {
        this.snList = snList;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
