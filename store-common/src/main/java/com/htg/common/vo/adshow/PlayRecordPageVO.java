package com.htg.common.vo.adshow;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

import java.util.Date;

public class PlayRecordPageVO {
    /**
     * 播放记录ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 设备序列号
     */

    private String devName;
    /**
     * 节目id
     */

    private String showName;
    /**
     * 播放次数
     */
    @TableField("frequency")
    private Integer frequency;
    /**
     * 播放日期 如 2019-10-10
     */
    @TableField("day")
    private String day;


    private String updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDevName() {
        return devName;
    }

    public void setDevName(String devName) {
        this.devName = devName;
    }

    public String getShowName() {
        return showName;
    }

    public void setShowName(String showName) {
        this.showName = showName;
    }

    public Integer getFrequency() {
        return frequency;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }


    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "PlayRecordPageVO{" +
                "id=" + id +
                ", devName='" + devName + '\'' +
                ", showName=" + showName +
                ", frequency=" + frequency +
                ", day='" + day + '\'' +
                ", updateTime='" + updateTime + '\'' +
                '}';
    }
}
