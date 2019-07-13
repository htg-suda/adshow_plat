package com.htg.common.dto.adshow;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.htg.common.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * <p>
 * 播放记录表
 * </p>
 *
 * @author htg
 * @since 2019-07-11
 */
public class PlayRecordPageDTO extends BaseEntity {

    @ApiModelProperty(value = "查询开始时间", example = "12345")
    private Long startTime;

    @ApiModelProperty(value = "查询结束时间", example = "123456")
    private Long endTime;


    @ApiModelProperty(value = "设备名", example = "xx")
    private String devName;

    @ApiModelProperty(value = "节目名", example = "xx")
    private String showName;

    @NotNull(message = "第几页不能为空")
    @ApiModelProperty(value = "第几页", example = "0")
    private Integer pageNum;

    @NotNull(message = "每页大小不能为空")
    @ApiModelProperty(value = "每页大小", example = "0")
    private Integer pageSize;


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

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
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
}
