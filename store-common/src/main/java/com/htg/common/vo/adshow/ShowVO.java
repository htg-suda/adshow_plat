package com.htg.common.vo.adshow;

import com.baomidou.mybatisplus.annotations.TableName;
import com.htg.common.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 节目表
 * </p>
 *
 * @author htg
 * @since 2019-07-08
 */
@TableName("sr_show")
public class ShowVO extends BaseEntity {

    private static final long serialVersionUID = 1L;


    @ApiModelProperty(value = "节目ID", example = "0")
    private Integer id;


    @ApiModelProperty(value = "节目名称", example = "0")
    private String name;


    @ApiModelProperty(value = "节目编号", example = "0")
    private String num;


    @ApiModelProperty(value = "节目URL 地址", example = "0")
    private String url;


    @ApiModelProperty(value = "节目主图url", example = "0")
    private String mainImgUrl;


    @ApiModelProperty(value = "节目制作方 1-平台,2-商户", example = "0")
    private Integer addBy;



    @ApiModelProperty(value = "作者id", example = "0")
    private Integer authorId;



    public Integer getId() {
        return id;
    }

    public ShowVO setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ShowVO setName(String name) {
        this.name = name;
        return this;
    }

    public String getNum() {
        return num;
    }

    public ShowVO setNum(String num) {
        this.num = num;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public ShowVO setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getMainImgUrl() {
        return mainImgUrl;
    }

    public ShowVO setMainImgUrl(String mainImgUrl) {
        this.mainImgUrl = mainImgUrl;
        return this;
    }

    public Integer getAddBy() {
        return addBy;
    }

    public ShowVO setAddBy(Integer addBy) {
        this.addBy = addBy;
        return this;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public ShowVO setAuthorId(Integer authorId) {
        this.authorId = authorId;
        return this;
    }
    @Override
    public String toString() {
        return "Show{" +
        "id=" + id +
        ", name=" + name +
        ", num=" + num +
        ", url=" + url +
        ", mainImgUrl=" + mainImgUrl +
        ", addBy=" + addBy +
        ", authorId=" + authorId +
        "}";
    }
}
