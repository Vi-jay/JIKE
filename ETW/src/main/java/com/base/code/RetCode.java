package com.base.code;

public enum RetCode {
    SUCCESS(200),
    NOT_FOUND(404),
    ERROR(505);

    private int code;
    private RetCode(int code){
        this.code = code;
    }
    public int getCode(){
        return this.code;
    }
}
