package com.htg.common.dto.adshow;
import com.baomidou.mybatisplus.annotations.TableField;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class PlayRecordDTO {
    @NotNull(message = "排期id,不能为空")
    @ApiModelProperty(value = "排期ID", example = "0")
    private Integer schedulingId;

    @NotBlank(message = "设备序列号不能为空")
    @ApiModelProperty(value = "设备序列号", example = "xxxxxxx")
    private String sn;


    @NotNull(message = "节目id不能为空")
    @ApiModelProperty(value = "节目id", example = "0")
    @TableField("show_id")
    private Integer showId;

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public Integer getShowId() {
        return showId;
    }

    public void setShowId(Integer showId) {
        this.showId = showId;
    }

    public Integer getSchedulingId() {
        return schedulingId;
    }

    public void setSchedulingId(Integer schedulingId) {
        this.schedulingId = schedulingId;
    }

    @Override
    public String toString() {
        return "PlayRecordDTO{" +
                "schedulingId=" + schedulingId +
                ", sn='" + sn + '\'' +
                ", showId=" + showId +
                '}';
    }
}
