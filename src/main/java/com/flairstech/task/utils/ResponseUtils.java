package com.flairstech.task.utils;

public class ResponseUtils {
    private Object data;
    protected String status;
    protected String code;


    public void success(Object data) {
        this.status = ResponseState.SUCCESS.name();
        this.data = data;
        this.code = "Success";
    }

    public void fail(Object code) {
        this.status = ResponseState.FAIL.name();
        this.code = (String) code;
    }

    public enum ResponseState {
        SUCCESS,
        FAIL,
        ERROR
    }
}
