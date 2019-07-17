package com.htg.common.dto.adshow;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class MsgRecordPageDTO {

    @NotNull(message = "第几页不能为空")
    @ApiModelProperty(value = "第几页", example = "0")
    private Integer pageNum;

    @NotNull(message = "每页大小不能为空")
    @ApiModelProperty(value = "每页大小", example = "0")
    private Integer pageSize;

    @ApiModelProperty(value = "设备序列号")
    private String sn;

    @ApiModelProperty(value = "mac地址")
    private String mac;

    @ApiModelProperty(value = "发起人姓名")
    private String name;

    /**
     * DEV_SYNC_SCHEDULE_MSG(),
     * DEV_CLEAR_ALL_SCH_MSG(2007, "清空节目排期"),
     * DEV_DELETE_SOME_SCH_MSG(2008, "删除某些排期"),
     */
    @ApiModelProperty(value = "消息类型  2004-发送同步排期,2007-清空节目排期,2008-删除某些排期")
    private Integer type;


}
