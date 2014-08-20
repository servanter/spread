package com.zhy.spread.common;

import java.sql.Timestamp;

import net.sf.json.JSONObject;

public class CommonResponse {

    private JSONObject data;

    private ReturnCode returnCode;

    private Timestamp responseTime;

    public CommonResponse() {
        responseTime = new Timestamp(System.currentTimeMillis());
    }

    public CommonResponse(ReturnCode returnCode) {
        this.returnCode = returnCode;
        responseTime = new Timestamp(System.currentTimeMillis());
    }

    public ReturnCode getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(ReturnCode returnCode) {
        this.returnCode = returnCode;
    }

    public Timestamp getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(Timestamp responseTime) {
        this.responseTime = responseTime;
    }

    public JSONObject toJSON() {
        JSONObject object = new JSONObject();
        if (data != null) {
            object = data;
        }
        object.put("returnCode", returnCode.getCode());
        object.put("returnMsg", returnCode.getAlias());
        object.put("responseTime", responseTime);
        return object;
    }

    public JSONObject getData() {
        return data;
    }

    public void setData(JSONObject data) {
        this.data = data;
    }

}
