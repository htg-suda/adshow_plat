package com.htg.common.dto.adshow;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.List;

public class DevInScheduleDTO {
    /* 排期 ID*/
    @NotNull(message = "排期ID不能为空")
    @ApiModelProperty(value = "排期ID", example = "1")
    private Integer scheduleId;


    @NotNull(message = "设备序列号集合不能为空")
    @ApiModelProperty(value = "设备序列号集合", example = "[abc,efg,iuhiu,ohnon]")
    private List<String> snList;


    public Integer getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Integer scheduleId) {
        this.scheduleId = scheduleId;
    }

    public List<String> getSnList() {
        return snList;
    }

    public void setSnList(List<String> snList) {
        this.snList = snList;
    }

    @Override
    public String toString() {
        return "DevInScheduleDTO{" +
                "scheduleId=" + scheduleId +
                ", snList=" + snList +
                '}';
    }
}
