package com.zhy.spread.common;

public enum ReturnCode {

    OK(10000, "成功"),

    CONSUME_USER_HAS_NO_MONEY(10001, "用户没有足够的余额"),

    USER_REGISTER_PARAMETER_USERNAME_ERROR(10002, "用户名已经注册。"),

    USER_REGISTER_PARAMETER_NICKNAME_ERROR(10003, "昵称已经注册"),

    USER_REGISTER_PARAMETER_EMAIL_ERROR(10004, "email已经注册。"),
    
    USER_NAME_OR_PASSWROD_ERROR(10005, "用户名或密码输入有误，请重新输入"),

    IDENTIFY_CODE_ERROR(90001, "验证码错误"),
    
    SYSTEM_ERROR(99999, "操作失败");

    private int code;

    private String alias;

    private ReturnCode(int code, String alias) {
        this.code = code;
        this.alias = alias;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

}
