package com.htg.common.dto.adshow;


import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

public class UploadShotDTO {
    @NotNull(message = "设备序列号不能为空")
    @ApiModelProperty(value = "设备序列号码", example = "1")
    private String sn;

    @NotNull(message = "文件地址")
    @ApiModelProperty(value = "文件地址", example = "xxxx.png")
    private String url;

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "UploadShotDTO{" +
                "sn='" + sn + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
