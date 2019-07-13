package com.htg.adshow.constant;

public class DevConst {

    /* 设备不存在 */
    public static final Integer STATUS_DEV_NOT_EXIST = -1;

    /* 设备待认证 */
    public static final Integer STATUS_HAS_NOT_VERFIY = 0;
    /* 设备已经启用 */
    public static final Integer STATUS_ACTIVE = 1;
    /* 商户已经冻结  */
    public static final Integer STATUS_FROZEN = 2;

    /**
     * 在线状态
     **************************************/
    // 离线
    public static final Integer ONLINE_STATUS_OFF = 0;
    // 在线
    public static final Integer ONLINE_STATUS_ON = 1;
    //未知
    public static final Integer ONLINE_STATUS_UNKNOW = 2;


    /**
     * 设备类型
     */
    public static final Integer TYPE_PROJECTOR = 1;
    public static final Integer TYPE_UPRIGHT_SCREEN = 2;
    public static final Integer TYPE_86_BOX = 3;

    public static final Integer[] DEV_TYPE = {TYPE_PROJECTOR, TYPE_UPRIGHT_SCREEN, TYPE_86_BOX};

}
