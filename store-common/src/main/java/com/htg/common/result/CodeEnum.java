package com.htg.common.result;

public enum CodeEnum {
    SUCCESS(0, "操作成功"),
    ERROR(-1, "操作失败"),
    PARAM_ERROR(-1000, "参数异常"),
    TOKEN_ERROR(-1001, "Token异常"),
    PARENT_CATEGORY_NOT_EXISTS(-1002, "父分类不存在"),
    CATEGORY_HAS_EXISTS(-1003, "该分类已经存在"),
    BRAND_HAS_EXISTS(-1004, "品牌已经存在"),
    BRAND_HAS_IN_CATEGORY(-1006, "分类中已经存在该品牌"),
    CATEGORY_NOT_EXIST(-1007, "分类不存在"),
    BRAND_NOT_EXIST(-1008, "品牌不存在"),
    BRAND_IN_USER(-1009, "品牌使用中"),
    CATEGORY_IN_USER(-1010, "分类使用中"),
    BRAND_NOT_PASS(-1011, "品牌未审核通过"),
    BRAND_CAN_NOT_CHANGE_NAME(-1012, "品牌一旦添加将无法修改名字"),
    SPEC_GROUP_HAS_EXIST(-1013, "规格组已经存在"),
    SPEC_GROUP_NOT_EXIST(-1014, "规格组不存在"),
    SPEC_ITEM_CATEGORT_ERROR(-1015, "规格组分类异常"),
    SPEC_ITEM_HAS_EXIST(-1016, "规格参数已存在"),
    SPU_NOT_EXIST(-1017, "商品SPU不存在"),
    SPU_DETAIL_NOT_EXIST(-1018, "商品SPU DETAIL不存在"),
    SPU_ID_ERROR(-1019, "商品SPU ID 错误"),
    CATEGORY_BRAND_IS_ERROR(-1020, "品牌和分类不对应"),
    ADD_GOOD_SPU_ERROR(-1021, "添加商品SPU异常"),
    Modify_GOOD_SPU_ERROR(-1022, "修改商品SPU异常"),
    Modify_GOOD_SPU_STATE_ERROR(-1023, "修改SPU状态异常"),
    Modify_GOOD_SPU_VERIFY_ERROR(-1024, "修改SPU审核状态异常"),
    GOOD_SPU_VERIFY_UNPASS(-1025, "商品SPU未审核通过"),
    GOOD_SPU_STATE_NOT_ON_SALE(-1026, "商品SPU 不是在售状态"),
    ADD_GOOD_SKU_ERROR(-1027, "添加商品SKU异常"),
    ADD_SELLER_INFO_ERROR(-1028, "添加商户信息异常"),
    ADD_ENTERPRISE_INFO_ERROR(-1029, "添加企业信息异常异常"),
    ADD_SELLER_TYPE_ERROR(-1030, "添加商户类型异常"),
    ADD_SELLER_LEGAL_PERSON_ERROR(-1031, "企业法人信息异常"),
    ADD_SELLER_BANK_ACCOUNT_PERMIT_NUM_ERROR(-1032, "开户许可证编码不能为空"),
    ADD_BANK_INFO_ERROR(-1033, "添加银行信息异常"),
    SELLER_NOT_EXIST(-1034, "商户不存在"),
    SELLER_STATE_ERROR(-1035, "商户状态异常"),
    SELLER_HAS_EXIST(-1036, "此用户已经存在商户了"),
    SELLER_SN_ERROR(-1037, "当前用户不持有该商户编号"),
    USERNAME_HAS_EXIST(-1038, "用户名已经存在"),
    TEL_HAS_EXIST(-1039, "手机号码已经存在"),
    EMAIL_HAS_EXIST(-1040, "邮箱已存在"),
    REGISTER_USER_ERROR(-1041, "用户注册异常"),
    SELLER_STORE_HAS_EXIST(-1042, "您的店铺已存在,且只能创建一个店铺"),
    SELLER_STORE_NOT_EXIST(-1043, "您还未创建店铺,无法获取商品"),
    YOU_ARE_NOT_SELLER(-1044, "您还不是商户"),
    SELLER_STORE_NOT_ACTIVE(-1045, "店铺被冻结"),
    SKU_GOOD_NOT_EXIST(-1046, "sku 商品不存在"),
    MSG_CODE_VALID_FAILED(-1047, "验证码校验失败"),
    SELLER_HAS_NO_BANK_INFO(-1048, "商户没有银行信息"),
    SELLER_VERIDY_STATE_ERROR(-1049, "审核状态异常"),
    SELLER_VERIDY_STATE_REMARK_ERROR(-1050, "冻结或则审核不通过必须给出理由且不可为空"),
    ADD_USER_INFO_ERROR(-1052, "添加用户信息异常"),
    USER_NOT_EXIST(-1053, "用户不存在"),
    CUSTOM_SERVICE_HAS_EXIST(-1054, "该用户已被添加为客服,不能重复添加"),
    YOU_ARE_NOT_CUSTOM_SERVICE(-1055, "您还不是客服!"),
    CUSTOM_SERVICE_NOT_EXIST(-1056, "客服不存在"),
    MUST_HAVE_CUSTOM_SERVICE(-1057, "审核通过必须分配客服"),
    MODIFY_SELLER_INFO_ERROR(-1058, "更新商户基本信息异常"),
    MODIFY_SELLER_ENTERPRISE_INFO_ERROR(-1059, "更新商户企业信息异常"),
    MODIFY_SELLER_BANK_INFO_ERROR(-1060, "更新商户银行信息异常"),
    SELLER_TO_USER_ERROR(-1061, "商户信息写入用户异常"),
    SELLER_HAS_NOT_VERIFY_PASS(-1062, "商户还没有审核通过"),
    AGENCY_NOT_EXIST(-1063, "机构不存在"),
    ADD_DEVICE_TYPE_ERROR(-1064, "添加的设备类型异常"),
    VERIFY_DEVICE_STATUS_ERROR(-1065, "认证设备状态异常"),
    DEVICE_NOT_EXIST(-1065, "设备不存在"),
    AGENCY_PARENT_NOT_EXIST(-1066, "父机构不存在"),
    ENTERPRISE_INFO_NOT_EXIST(-1067, "企业商户未找到企业信息"),
    ADD_CUSTOM_SERVICE_ERROR(-1068, "添加客服信息异常"),
    MODIFY_CUSTOM_SERVICE_ERROR(-1069, "修改客服信息异常"),
    AGENCY_NAME_HAS_EXIST(-1070, "机构名已经存在"),
    MUST_HAVE_AGENCY(-1071, "审核通过必须分配机构"),
    DEVICE_HAS_EXIST(-1072, "设备已经存在,如要再次添加请联系管理员"),
    DEVICE_HAS_NOT_ACTIVE(-1073, "设备未认证通过"),
    PLAY_MODE_ERROR(-1074, "播放模式错误"),
    RELEASE_TYPE_ERROR(-1075, "发布类型错误"),
    SCHEDULE_ADD_SHOW_FAILED(-1076, "排期添加节目失败"),
    START_TIME_SHOULD_AFTER_NOW(-1077, "开始时间必须在当前时间之后"),
    END_TIME_SHOULD_AFTER_NOW(-1078, "结束时间必须在当前时间之后"),
    DOWNLOAD_TIME_SHOULD_AFTER_NOW(-1079, "下载时间必须在当前时间之后"),
    START_TIME_SHOULD_BEFORE_END_TIME(-1080, "结束时间必须在开始时间之后"),
    DOWNLOAD_TIME_SHOULD_BEFORE_START_TIME(-1081, "下载时间必须在开始时间之前"),
    SCHEDULE_ADD_DEV_FAILED(-1082, "排期添加设备失败"),
    SCHEDULE_DELETE_DEV_FAILED(-1083, "排期删除失败"),
    ADD_SCHEDULE_FAILED(-1084, "排期添加失败"),
    DEV_CHANGE_STATUS_FAILED(-1085, "更新设备状态失败"),
    DEVICE_STATUS_ERROR(-1086, "设备状态异常"),
    DEVICE_INVALID_PLAY_RECORD_BY_DEV_STATUS(-1087, "无效的播放记录,设备已经停用或未认证"),
    DEVICE_INVALID_PLAY_RECORD_BY_SCHEDULING_NOT_EXIST(-1088, "无效的播放记录,排期不存在"),
    DEVICE_INVALID_PLAY_RECORD_BY_SCHEDULING_HAS_END(-1089, "无效的播放记录,排期已经过期"),
    DEVICE_INVALID_PLAY_RECORD_BY_SCHEDULING_HAS_NOT_START(-1090, "无效的播放记录,排期还未开始"),
    DEVICE_INVALID_PLAY_RECORD_BY_SHOW_NOT_EXIST(-1091, "无效的播放记录,播放节目不存在"),
    SCREEN_SHOT_NOT_EXIST(-1092, "截屏不存在或已经过期");

    private int code;
    private String msg;

    CodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
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
}
