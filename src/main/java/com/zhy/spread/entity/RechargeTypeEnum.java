package com.zhy.spread.entity;

/**
 * 充值类型<br>
 * 不全,只存代码中用到的类型,用于不直接写死某个code,完整充值类型在表tab_ipay_recharge_type中
 * 
 * @author ZhangHongyan
 */
public enum RechargeTypeEnum {

    /**
     * 支付宝充值
     */
    ALIPAY_PAY(100, "支付宝充值"),

    /**
     * 支付宝web充值
     */
    ALIPAY_WEB_PAY(101, "支付宝WEB充值"),

    /**
     * 财付通web充值
     */
    TENCENT_PAY(200, "财付通充值"),

    NULL(9999, "未知");

    private RechargeTypeEnum(int code, String comment) {
        this.code = code;
        this.comment = comment;
    }

    private int code;

    private String comment;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public static RechargeTypeEnum code2Type(int code) {
        RechargeTypeEnum[] types = RechargeTypeEnum.values();
        for (RechargeTypeEnum type : types) {
            if (type.getCode() == code) {
                return type;
            }
        }
        return RechargeTypeEnum.NULL;
    }
}