package com.htg.common.dto.adshow;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.List;

public class ShowInScheduleDTO {
    /* 排期 ID*/
    @NotNull(message = "排期ID不能为空")
    @ApiModelProperty(value = "排期ID", example = "1")
    private Integer scheduleId;

    /* 节目id 集合*/
    @NotNull(message = "节目id集合不能为空")
    @ApiModelProperty(value = "节目id集合", example = "[1,2,3,4]")
    private List<Integer> showIdList;


    public Integer getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Integer scheduleId) {
        this.scheduleId = scheduleId;
    }

    public List<Integer> getShowIdList() {
        return showIdList;
    }

    public void setShowIdList(List<Integer> showIdList) {
        this.showIdList = showIdList;
    }

    @Override
    public String toString() {
        return "ShowInScheduleDTO{" +
                "scheduleId=" + scheduleId +
                ", showIdList=" + showIdList +
                '}';
    }
}
