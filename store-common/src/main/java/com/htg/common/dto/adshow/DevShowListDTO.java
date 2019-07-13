package com.htg.common.dto.adshow;

import com.baomidou.mybatisplus.annotations.TableField;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

public class DevShowListDTO {

    @ApiModelProperty(value = "设备序列号", example = "0")
    private String sn;


    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    @Override
    public String toString() {
        return "DevShowListDTO{" +
                "sn='" + sn + '\'' +
                '}';
    }
}
