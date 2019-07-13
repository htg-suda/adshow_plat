package com.htg.common.dto.adshow;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

public class ReleaseScheduleDTO {
    @Length(max = 16,message = "节目名称最长不超过16个字符")
    @NotBlank(message = "排期名称不能为空")
    @ApiModelProperty(value = "排期名称", example = "tomcat")
    private String name;

    @NotNull(message = "发布类型不能为空")
    @ApiModelProperty(value = "发布类型 1-默认独播放,2-轮播,3-插播", example = "1")
    private Integer releaseType;


    @NotNull(message = "播放模式不能为空")
    @ApiModelProperty(value = "播放模式 1-在线播放,2-本地播放", example = "2")
    private Integer playMode;

    @NotNull(message = "节目开始时间不能为空")
    @ApiModelProperty(value = "节目开始时间", example = "2")
    private Long startTime;

    @NotNull(message = "节目结束时间不能为空")
    @ApiModelProperty(value = "节目结束时间", example = "2")
    private Long endTime;

    @NotBlank(message = "节目播放周次不能为空")
    @ApiModelProperty(value = "节目播放周次", example = "1,2,3,4,5,6")
    private String dayInWeek;

    @NotNull(message = "下载时间不能为空")
    @ApiModelProperty(value = "下载时间", example = "979789")
    private Long downloadTime;

    @Length(max = 255,message = "备注最长不超过255个字符")
    @ApiModelProperty(value = "备注", example = "hello world")
    private String remark ;

    /* 节目id 集合*/
    @NotNull(message = "节目id集合不能为空")
    @ApiModelProperty(value = "节目id集合", example = "[1,2,3,4]")
    private List<Integer> showIdList;

    @NotNull(message = "设备序列号集合不能为空")
    @ApiModelProperty(value = "设备序列号集合", example = "[abc,efg,iuhiu,ohnon]")
    private List<String> snList;


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

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public String getDayInWeek() {
        return dayInWeek;
    }

    public void setDayInWeek(String dayInWeek) {
        this.dayInWeek = dayInWeek;
    }

    public Long getDownloadTime() {
        return downloadTime;
    }

    public void setDownloadTime(Long downloadTime) {
        this.downloadTime = downloadTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<Integer> getShowIdList() {
        return showIdList;
    }

    public void setShowIdList(List<Integer> showIdList) {
        this.showIdList = showIdList;
    }

    public List<String> getSnList() {
        return snList;
    }

    public void setSnList(List<String> snList) {
        this.snList = snList;
    }
}
