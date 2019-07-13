package com.htg.common.dto.adshow;

import com.baomidou.mybatisplus.annotations.TableField;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ShowDTO {

    /**
     * 节目名称
     */
    @Length(max = 16,message = "节目名称最长不超过16个字符")
    @NotBlank(message = "节目名称不能为空")
    @TableField("name")
    private String name;

    /**
     * 节目URL 地址
     */
    @NotBlank(message = "节目URL 地址不能为空")
    @TableField("url")
    private String url;
    /**
     * 节目主图url
     */
    @NotBlank(message = "节目主图url 地址不能为空")
    @TableField("main_img_url")
    private String mainImgUrl;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMainImgUrl() {
        return mainImgUrl;
    }

    public void setMainImgUrl(String mainImgUrl) {
        this.mainImgUrl = mainImgUrl;
    }



    @Override
    public String toString() {
        return "ShowDTO{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", mainImgUrl='" + mainImgUrl + '\'' +
                '}';
    }
}
