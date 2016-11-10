package com.helin.rxsample.enity;

/**
 * Created by helin on 2016/10/10 11:44.
 * 实体的基类
 */
public class HttpResult<T> {

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    private int code;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private String message;

    private T data;
}
