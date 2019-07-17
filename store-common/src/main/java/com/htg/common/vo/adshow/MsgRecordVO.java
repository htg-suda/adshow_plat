package com.htg.common.vo.adshow;

import io.swagger.annotations.ApiModelProperty;

public class MsgRecordVO {
    /**
     * 消息编号
     */
    @ApiModelProperty(value = "消息编号", example = "abcd")
    private String num;

    /**
     * 消息说明
     */
    @ApiModelProperty(value = "消息说明", example = "abcd")
    private String tag;
    /**
     * 设备序列号
     */
    @ApiModelProperty(value = "设备序列号", example = "abcd")
    private String sn;
    /**
     * 消息发起人
     */
    @ApiModelProperty(value = "消息发起人", example = "abcd")
    private String initiator;


    @ApiModelProperty(value = "mac", example = "abcd")
    private String mac;

    @ApiModelProperty(value = "消息发起时间", example = "abcd")
    private String startTime;

    @ApiModelProperty(value = "消息结束时间", example = "abcd")
    private String endTime;


    @ApiModelProperty(value = "更新时间", example = "abcd")
    private String updateTime;

    @ApiModelProperty(value = "0-待完成, 1-已完成,2-未知", example = "0")
    private Integer status;


    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getInitiator() {
        return initiator;
    }

    public void setInitiator(String initiator) {
        this.initiator = initiator;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }


    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    @Override
    public String toString() {
        return "MsgRecordVO{" +
                "num='" + num + '\'' +
                ", tag='" + tag + '\'' +
                ", sn='" + sn + '\'' +
                ", initiator='" + initiator + '\'' +
                ", mac='" + mac + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", status=" + status +
                '}';
    }
}
