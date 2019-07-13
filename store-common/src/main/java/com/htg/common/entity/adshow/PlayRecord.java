package com.htg.common.entity.adshow;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.htg.common.base.BaseEntity;

import java.util.Date;

/**
 * <p>
 * 播放记录表
 * </p>
 *
 * @author htg
 * @since 2019-07-11
 */
@TableName("sr_play_record")
public class PlayRecord extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 播放记录ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 设备序列号
     */
    @TableField("sn")
    private String sn;
    /**
     * 节目id
     */
    @TableField("show_id")
    private Integer showId;
    /**
     * 播放次数
     */
    @TableField("frequency")
    private Integer frequency;
    /**
     * 播放日期 如 2019-10-10
     */
    @TableField("day")
    private Date day;
    /**
     * 删除状态,0-有效,-1 -删除
     */
    @TableField("del_flag")
    private Integer delFlag;


    public Integer getId() {
        return id;
    }

    public PlayRecord setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getSn() {
        return sn;
    }

    public PlayRecord setSn(String sn) {
        this.sn = sn;
        return this;
    }

    public Integer getShowId() {
        return showId;
    }

    public PlayRecord setShowId(Integer showId) {
        this.showId = showId;
        return this;
    }

    public Integer getFrequency() {
        return frequency;
    }

    public PlayRecord setFrequency(Integer frequency) {
        this.frequency = frequency;
        return this;
    }

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public PlayRecord setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
        return this;
    }

    @Override
    public String toString() {
        return "PlayRecord{" +
        "id=" + id +
        ", sn=" + sn +
        ", showId=" + showId +
        ", frequency=" + frequency +
        ", day=" + day +
        ", delFlag=" + delFlag +
        "}";
    }
}
