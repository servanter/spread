package com.zhy.spread.entity;

public enum AccountStatusEnum {

    AVALIABLE(1, "可用");

    private int code;

    private String alias;

    private AccountStatusEnum(int code, String alias) {
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
