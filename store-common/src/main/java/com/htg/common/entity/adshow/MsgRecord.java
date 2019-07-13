package com.htg.common.entity.adshow;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.htg.common.base.BaseEntity;

import java.util.Date;

/**
 * <p>
 * 消息记录表
 * </p>
 *
 * @author htg
 * @since 2019-07-11
 */
@TableName("sr_msg_record")
public class MsgRecord extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 消息ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 消息编号
     */
    @TableField("num")
    private String num;
    /**
     * 消息类型
     */
    @TableField("type")
    private Integer type;
    /**
     * 消息说明
     */
    @TableField("tag")
    private String tag;
    /**
     * 设备序列号
     */
    @TableField("sn")
    private String sn;
    /**
     * 消息发起人
     */
    @TableField("initiator")
    private String initiator;
    /**
     * 消息发起时间
     */
    @TableField("start_time")
    private Date startTime;
    /**
     * 消息结束时间
     */
    @TableField("end_time")
    private Date endTime;
    /**
     * 0-待完成, 1-已完成,2-未知
     */
    @TableField("status")
    private Integer status;
    /**
     * 删除状态,0-有效,-1 -删除
     */
    @TableField("del_flag")
    private Integer delFlag;


    public Integer getId() {
        return id;
    }

    public MsgRecord setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getNum() {
        return num;
    }

    public MsgRecord setNum(String num) {
        this.num = num;
        return this;
    }

    public Integer getType() {
        return type;
    }

    public MsgRecord setType(Integer type) {
        this.type = type;
        return this;
    }

    public String getTag() {
        return tag;
    }

    public MsgRecord setTag(String tag) {
        this.tag = tag;
        return this;
    }

    public String getSn() {
        return sn;
    }

    public MsgRecord setSn(String sn) {
        this.sn = sn;
        return this;
    }

    public String getInitiator() {
        return initiator;
    }

    public MsgRecord setInitiator(String initiator) {
        this.initiator = initiator;
        return this;
    }

    public Date getStartTime() {
        return startTime;
    }

    public MsgRecord setStartTime(Date startTime) {
        this.startTime = startTime;
        return this;
    }

    public Date getEndTime() {
        return endTime;
    }

    public MsgRecord setEndTime(Date endTime) {
        this.endTime = endTime;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public MsgRecord setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public MsgRecord setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
        return this;
    }

    @Override
    public String toString() {
        return "MsgRecord{" +
        "id=" + id +
        ", num=" + num +
        ", type=" + type +
        ", tag=" + tag +
        ", sn=" + sn +
        ", initiator=" + initiator +
        ", startTime=" + startTime +
        ", endTime=" + endTime +
        ", status=" + status +
        ", delFlag=" + delFlag +
        "}";
    }
}
