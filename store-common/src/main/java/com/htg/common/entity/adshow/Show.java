package com.htg.common.entity.adshow;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.htg.common.base.BaseEntity;

/**
 * <p>
 * 节目表
 * </p>
 *
 * @author htg
 * @since 2019-07-08
 */
@TableName("sr_show")
public class Show extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 节目ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 节目名称
     */
    @TableField("name")
    private String name;
    /**
     * 节目编号
     */
    @TableField("num")
    private String num;
    /**
     * 节目URL 地址
     */
    @TableField("url")
    private String url;
    /**
     * 节目主图url
     */
    @TableField("main_img_url")
    private String mainImgUrl;
    /**
     * 节目制作方 1-平台,2-商户
     */
    @TableField("add_by")
    private Integer addBy;
    /**
     * 作者id
     */
    @TableField("author_id")
    private Integer authorId;
    /**
     * 删除状态,0-有效,-1 -删除
     */
    @TableField("del_flag")
    private Integer delFlag;


    public Integer getId() {
        return id;
    }

    public Show setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Show setName(String name) {
        this.name = name;
        return this;
    }

    public String getNum() {
        return num;
    }

    public Show setNum(String num) {
        this.num = num;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public Show setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getMainImgUrl() {
        return mainImgUrl;
    }

    public Show setMainImgUrl(String mainImgUrl) {
        this.mainImgUrl = mainImgUrl;
        return this;
    }

    public Integer getAddBy() {
        return addBy;
    }

    public Show setAddBy(Integer addBy) {
        this.addBy = addBy;
        return this;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public Show setAuthorId(Integer authorId) {
        this.authorId = authorId;
        return this;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public Show setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
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
        ", delFlag=" + delFlag +
        "}";
    }
}
