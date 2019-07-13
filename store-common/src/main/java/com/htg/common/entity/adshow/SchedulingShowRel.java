package com.htg.common.entity.adshow;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.htg.common.base.BaseEntity;

/**
 * <p>
 * 排期节目关系表
 * </p>
 *
 * @author htg
 * @since 2019-07-08
 */
@TableName("sr_scheduling_show_rel")
public class SchedulingShowRel extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 关系id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 节目ID
     */
    @TableField("show_id")
    private Integer showId;
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

    public SchedulingShowRel setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getShowId() {
        return showId;
    }

    public SchedulingShowRel setShowId(Integer showId) {
        this.showId = showId;
        return this;
    }

    public Integer getSchedulingId() {
        return schedulingId;
    }

    public SchedulingShowRel setSchedulingId(Integer schedulingId) {
        this.schedulingId = schedulingId;
        return this;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public SchedulingShowRel setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
        return this;
    }

    @Override
    public String toString() {
        return "SchedulingShowRel{" +
        "id=" + id +
        ", showId=" + showId +
        ", schedulingId=" + schedulingId +
        ", delFlag=" + delFlag +
        "}";
    }
}
