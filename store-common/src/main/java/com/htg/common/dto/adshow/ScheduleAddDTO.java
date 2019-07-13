package com.htg.common.dto.adshow;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.htg.common.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
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
public class ScheduleAddDTO extends BaseEntity {

    private static final long serialVersionUID = 1L;

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


    @ApiModelProperty(value = " 删除状态,0-有效,-1 -删除", example = "0", hidden = true)
    private Integer delFlag;




    public String getName() {
        return name;
    }

    public ScheduleAddDTO setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getReleaseType() {
        return releaseType;
    }

    public ScheduleAddDTO setReleaseType(Integer releaseType) {
        this.releaseType = releaseType;
        return this;
    }

    public Integer getPlayMode() {
        return playMode;
    }

    public ScheduleAddDTO setPlayMode(Integer playMode) {
        this.playMode = playMode;
        return this;
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

    public Integer getDelFlag() {
        return delFlag;
    }

    public ScheduleAddDTO setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
        return this;
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

    @Override
    public String toString() {
        return "ScheduleAddDTO{" +
                "name='" + name + '\'' +
                ", releaseType=" + releaseType +
                ", playMode=" + playMode +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", dayInWeek='" + dayInWeek + '\'' +
                ", downloadTime=" + downloadTime +
                ", remark='" + remark + '\'' +
                ", delFlag=" + delFlag +
                '}';
    }
}
