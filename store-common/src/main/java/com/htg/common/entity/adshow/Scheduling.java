package com.htg.common.entity.adshow;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.htg.common.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * <p>
 * 节目排期表
 * </p>
 *
 * @author htg
 * @since 2019-07-02
 */
@TableName("sr_scheduling")
public class Scheduling extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 排期id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 排期名称
     */
    @TableField("name")
    private String name;
    /**
     * 发布类型 1-默认独播放,2-轮播,3-插播
     */
    @TableField("release_type")
    private Integer releaseType;
    /**
     * 播放模式 1-在线播放,2-本地播放 
     */
    @TableField("play_mode")
    private Integer playMode;


    @TableField("day_in_week")
    private String  dayInWeek;


    @TableField("download_time")
    private Date downloadTime;





    @TableField("remark")
    private String remark ;
    /**
     * 节目开始时间
     */
    @TableField("start_time")
    private Date startTime;
    /**
     * 节目结束时间
     */
    @TableField("end_time")
    private Date endTime;
    /**
     * 删除状态,0-有效,-1 -删除
     */
    @TableField("del_flag")
    private Integer delFlag;



    public Integer getId() {
        return id;
    }

    public Scheduling setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Scheduling setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getReleaseType() {
        return releaseType;
    }

    public Scheduling setReleaseType(Integer releaseType) {
        this.releaseType = releaseType;
        return this;
    }

    public Integer getPlayMode() {
        return playMode;
    }

    public Scheduling setPlayMode(Integer playMode) {
        this.playMode = playMode;
        return this;
    }

    public Date getStartTime() {
        return startTime;
    }

    public Scheduling setStartTime(Date startTime) {
        this.startTime = startTime;
        return this;
    }

    public Date getEndTime() {
        return endTime;
    }

    public Scheduling setEndTime(Date endTime) {
        this.endTime = endTime;
        return this;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public Scheduling setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
        return this;
    }

    public String getDayInWeek() {
        return dayInWeek;
    }

    public void setDayInWeek(String dayInWeek) {
        this.dayInWeek = dayInWeek;
    }

    public Date getDownloadTime() {
        return downloadTime;
    }

    public void setDownloadTime(Date downloadTime) {
        this.downloadTime = downloadTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }


    @Override
    public String toString() {
        return "Scheduling{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", releaseType=" + releaseType +
                ", playMode=" + playMode +
                ", dayInWeek='" + dayInWeek + '\'' +
                ", downloadTime=" + downloadTime +

                ", remark='" + remark + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", delFlag=" + delFlag +
                '}';
    }
}
