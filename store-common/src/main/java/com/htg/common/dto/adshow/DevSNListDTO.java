package com.htg.common.dto.adshow;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.List;

public class DevSNListDTO {
    @NotNull(message = "设备序列号集合")
    @ApiModelProperty(value = "设备序列号集合", example = "['abc','']")
    private List<String> snList;


    public List<String> getSnList() {
        return snList;
    }

    public void setSnList(List<String> snList) {
        this.snList = snList;
    }
}
