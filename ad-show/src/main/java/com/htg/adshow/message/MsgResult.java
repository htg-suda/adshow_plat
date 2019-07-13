package com.htg.adshow.message;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MsgResult<T> {
    private int code;
    private String msg;
    private T data;
    private String msgNum;

    private MsgResult(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private MsgResult(int code, String msg, String msgNum) {
        this.code = code;
        this.msg = msg;
        this.msgNum = msgNum;
    }


    private MsgResult(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    private MsgResult(int code, String msg, String msgNum, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.msgNum = msgNum;
    }

    /* success  不参与JSON 序列化 */

    public static MsgResult createMSG(MsgType msgType) {

        return new MsgResult(msgType.getCode(), msgType.getDesc());
    }


    public static <T> MsgResult<T> createMSGWithData(MsgType msgType, T data) {
        return new MsgResult(msgType.getCode(), msgType.getDesc(), data);
    }


    public static  MsgResult createMSGWithNum(MsgType msgType, String msgNum) {
        return new MsgResult(msgType.getCode(), msgType.getDesc(), msgNum);
    }


    public static <T> MsgResult<T> createMSG(MsgType msgType, String msgNum, T data) {
        return new MsgResult(msgType.getCode(), msgType.getDesc(), msgNum, data);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsgNum() {
        return msgNum;
    }

    public void setMsgNum(String msgNum) {
        this.msgNum = msgNum;
    }
}
