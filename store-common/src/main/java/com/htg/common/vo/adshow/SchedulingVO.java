package com.htg.common.vo.adshow;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;

public class SchedulingVO {
    /**
     * 排期id
     */
    @ApiModelProperty(value = " 排期id", example = "0")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;


    @ApiModelProperty(value = "排期名称", example = "0")
    @TableField("name")
    private String name;

    @ApiModelProperty(value = "发布类型 1-默认独播放,2-轮播,3-插播", example = "0")
    @TableField("release_type")
    private Integer releaseType;


    @ApiModelProperty(value = "播放模式 1-在线播放,2-本地播放", example = "0")
    @TableField("play_mode")
    private Integer playMode;

    @ApiModelProperty(value = "节目播放周次", example = "1,2,3,4,5,6")
    private String dayInWeek;


    @ApiModelProperty(value = "节目开始时间", example = "0")
    @TableField("start_time")
    private Date startTime;

    @ApiModelProperty(value = "节目结束时间", example = "0")
    @TableField("end_time")
    private Date endTime;

    @ApiModelProperty(value = "节目发布时间", example = "0")
    @TableField("release_time")
    private Date releaseTime;

    @ApiModelProperty(value = "节目列表", example = "0")
    private List<ShowVO> showVOList;

    @ApiModelProperty(value = "节目列表", example = "0")
    private Date downloadTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getReleaseType() {
        return releaseType;
    }

    public void setReleaseType(Integer releaseType) {
        this.releaseType = releaseType;
    }

    public Integer getPlayMode() {
        return playMode;
    }

    public void setPlayMode(Integer playMode) {
        this.playMode = playMode;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }


    public List<ShowVO> getShowVOList() {
        return showVOList;
    }

    public void setShowVOList(List<ShowVO> showVOList) {
        this.showVOList = showVOList;
    }


    public Date getDownloadTime() {
        return downloadTime;
    }

    public void setDownloadTime(Date downloadTime) {
        this.downloadTime = downloadTime;
    }


    public Date getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }

    public String getDayInWeek() {
        return dayInWeek;
    }

    public void setDayInWeek(String dayInWeek) {
        this.dayInWeek = dayInWeek;
    }

    @Override
    public String toString() {
        return "SchedulingVO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", releaseType=" + releaseType +
                ", playMode=" + playMode +
                ", dayInWeek='" + dayInWeek + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", releaseTime=" + releaseTime +
                ", showVOList=" + showVOList +
                ", downloadTime=" + downloadTime +
                '}';
    }
}


