package com.htg.adshow.message;

public enum MsgType {
    DEV_VERIFY_PASS_MSG(2001, "认证通过消息"),
    DEV_ACTIVE_MSG(2002, "启用设备消息"),
    DEV_FROZEN_MSG(2003, "停用设备消息"),
    DEV_SYNC_SCHEDULE_MSG(2004, "发送同步排期"),
    DEV_UPDATE_APP_MSG(2005, "更新应用消息"),
    DEV_SCREENSHOTS_MSG(2006, "截屏消息"),
    DEV_CLEAR_ALL_SCH_MSG(2007, "清空节目排期"),
    DEV_DELETE_SOME_SCH_MSG(2008, "删除某些排期"),
    DEV_SELECT_TO_PLAY_MSG(2009, "选择播放"), // 只发命令
    DEV_STOP_PLAY_MSG(2010, "停止播放"),
    DEV_REMOTE_PLAY_MSG(2011, "远程播放"), // 只发命令
    DEV_MUTE_MSG(2012, "静音"),
    DEV_SET_VOLUME_MSG(2013, "设置音量"),
    DEV_REBOOT_MSG(2014, "重启"),
    DEV_SHUTDOWN_MSG(2015, "关机");


    private int code;
    private String desc;

    MsgType(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "MsgType{" +
                "code=" + code +
                ", desc='" + desc + '\'' +
                '}';
    }
}
