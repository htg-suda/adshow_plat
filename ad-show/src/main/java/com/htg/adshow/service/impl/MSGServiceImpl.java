package com.htg.adshow.service.impl;

import com.htg.adshow.constant.MsgStatusConst;
import com.htg.adshow.message.MsgResult;
import com.htg.adshow.message.MsgType;
import com.htg.adshow.service.IMqttSender;
import com.htg.adshow.service.IMsgRecordService;
import com.htg.adshow.utils.JSONUtil;
import com.htg.adshow.utils.SnowFlakeUtil;
import com.htg.common.constant.Del_FLAG;
import com.htg.common.entity.adshow.MsgRecord;
import com.htg.common.msg.SnMsg;
import com.htg.common.utils.AuthUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class MSGServiceImpl {
    @Resource
    private IMqttSender iMqttSender;

    @Autowired
    private IMsgRecordService msgRecordService;

    /**
     * 发送设备认证状态的消息
     */
    public void sendVerifyPassMSG(String topic, SnMsg snMsg) {
        iMqttSender.sendToMqtt(topic, JSONUtil.convertObject(MsgResult.createMSGWithData(MsgType.DEV_VERIFY_PASS_MSG, snMsg)));
    }

    /**
     * 发送启用设备消息
     */
    public void sendActiveMSG(String sn) {
        iMqttSender.sendToMqtt(sn, JSONUtil.convertObject(MsgResult.createMSG(MsgType.DEV_ACTIVE_MSG)));
    }

    /**
     * 发送停用设备消息
     */
    public void sendFrozenMSG(String sn) {
        iMqttSender.sendToMqtt(sn, JSONUtil.convertObject(MsgResult.createMSG(MsgType.DEV_FROZEN_MSG)));
    }


    /**
     * 发送同步排期消息
     */
    public void sendSyncScheduleMsg(String sn) {
        String num = recordSendLog(sn, MsgType.DEV_SYNC_SCHEDULE_MSG);
        iMqttSender.sendToMqtt(sn, JSONUtil.convertObject(MsgResult.createMSGWithNum(MsgType.DEV_SYNC_SCHEDULE_MSG, num)));
    }

    /**
     * 发送 更新APK
     */
    public void sendUpdateAppMsg(String sn) {
        iMqttSender.sendToMqtt(sn, JSONUtil.convertObject(MsgResult.createMSG(MsgType.DEV_UPDATE_APP_MSG)));
    }

    /**
     * 发送截屏消息
     */
    public void sendScreenshotsMsg(String sn) {
        iMqttSender.sendToMqtt(sn, JSONUtil.convertObject(MsgResult.createMSG(MsgType.DEV_SCREENSHOTS_MSG)));
    }


    /**
     * 清空节目排期
     */
    public void sendClearAllSchMsg(String sn) {
        String num = recordSendLog(sn, MsgType.DEV_CLEAR_ALL_SCH_MSG);
        iMqttSender.sendToMqtt(sn, JSONUtil.convertObject(MsgResult.createMSGWithNum(MsgType.DEV_CLEAR_ALL_SCH_MSG, num)));
    }

    /**
     * 删除某些排期
     */
    public void sendDeleteSomeSchMsg(String sn) {
        String num = recordSendLog(sn, MsgType.DEV_DELETE_SOME_SCH_MSG);
        iMqttSender.sendToMqtt(sn, JSONUtil.convertObject(MsgResult.createMSGWithNum(MsgType.DEV_DELETE_SOME_SCH_MSG, num)));
    }


    /**
     * 选择播放
     */
    public void sendSelectToPlayMsg(String sn) {
        iMqttSender.sendToMqtt(sn, JSONUtil.convertObject(MsgResult.createMSG(MsgType.DEV_SELECT_TO_PLAY_MSG)));
    }

    /**
     * 停止播放
     */
    public void sendStopPlayMsg(String sn) {
        iMqttSender.sendToMqtt(sn, JSONUtil.convertObject(MsgResult.createMSG(MsgType.DEV_STOP_PLAY_MSG)));
    }


    /**
     * 远程播放
     */
    public void sendRemotePlayMsg(String sn) {
        iMqttSender.sendToMqtt(sn, JSONUtil.convertObject(MsgResult.createMSG(MsgType.DEV_REMOTE_PLAY_MSG)));
    }

    /**
     * 静音
     */
    public void sendMuteMsg(String sn) {
        iMqttSender.sendToMqtt(sn, JSONUtil.convertObject(MsgResult.createMSG(MsgType.DEV_MUTE_MSG)));
    }

    /**
     * 设置音量
     */
    public void sendSetVolumeMsg(String sn, String vo) {
        iMqttSender.sendToMqtt(sn, JSONUtil.convertObject(MsgResult.createMSGWithData(MsgType.DEV_SET_VOLUME_MSG, vo)));
    }

    /**
     * 重启
     */
    public void sendRebootMsg(String sn) {
        iMqttSender.sendToMqtt(sn, JSONUtil.convertObject(MsgResult.createMSG(MsgType.DEV_REBOOT_MSG)));
    }

    /**
     * 关机
     */
    public void sendShutdownMsg(String sn) {
        iMqttSender.sendToMqtt(sn, JSONUtil.convertObject(MsgResult.createMSG(MsgType.DEV_SHUTDOWN_MSG)));
    }

    /* 记录消息 */
    private String recordSendLog(String sn, MsgType msg) {
        int code = msg.getCode();
        String desc = msg.getDesc();
        String num = SnowFlakeUtil.getFlowIdInstance().nextId() + "";
        MsgRecord msgRecord = new MsgRecord();
        msgRecord.setStartTime(new Date());
        msgRecord.setType(code);
        msgRecord.setTag(desc);
        msgRecord.setDelFlag(Del_FLAG.EXISTED);
        msgRecord.setNum(num);
        msgRecord.setSn(sn);
        msgRecord.setStatus(MsgStatusConst.SEND_SUCCESS);
        msgRecord.setInitiator(AuthUtil.getLoginUserUserName());
        msgRecordService.insert(msgRecord);
        return num;
    }
}
