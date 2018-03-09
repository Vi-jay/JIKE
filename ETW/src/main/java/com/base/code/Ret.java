package com.base.code;

import com.alibaba.fastjson.JSONObject;

public class Ret {

    private int code;
    private String msg;
    private Object data;

    public Ret() {
    }


    public Ret(int code) {
        this.code = code;
    }

    public Ret(RetCode code) {
        this.code = code.getCode();
    }

    public Ret(RetCode code, String msg) {
        this.code = code.getCode();
        this.msg = msg;
    }

    public Ret(RetCode code, Object data) {
        this.code = code.getCode();
        this.data = data;
    }

    public Ret(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Ret(int code, Object data) {
        this.code = code;
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
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

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
