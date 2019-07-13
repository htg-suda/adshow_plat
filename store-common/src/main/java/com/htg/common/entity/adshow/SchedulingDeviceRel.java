package com.htg.common.entity.adshow;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.htg.common.base.BaseEntity;

/**
 * <p>
 * 排期设备关系表
 * </p>
 *
 * @author htg
 * @since 2019-07-02
 */
@TableName("sr_scheduling_device_rel")
public class SchedulingDeviceRel extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 关系id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 设备ID
     */
    @TableField("device_id")
    private Integer deviceId;
    /**
     * 排期ID
     */
    @TableField("scheduling_id")
    private Integer schedulingId;
    /**
     * 删除状态,0-有效,-1 -删除
     */
    @TableField("del_flag")
    private Integer delFlag;


    public Integer getId() {
        return id;
    }

    public SchedulingDeviceRel setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getDeviceId() {
        return deviceId;
    }

    public SchedulingDeviceRel setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
        return this;
    }

    public Integer getSchedulingId() {
        return schedulingId;
    }

    public SchedulingDeviceRel setSchedulingId(Integer schedulingId) {
        this.schedulingId = schedulingId;
        return this;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public SchedulingDeviceRel setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
        return this;
    }

    @Override
    public String toString() {
        return "SchedulingDeviceRel{" +
        "id=" + id +
        ", deviceId=" + deviceId +
        ", schedulingId=" + schedulingId +
        ", delFlag=" + delFlag +
        "}";
    }
}
