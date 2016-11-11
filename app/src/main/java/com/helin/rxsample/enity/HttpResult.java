package com.helin.rxsample.enity;

/**
 * Created by helin on 2016/10/10 11:44.
 * 实体的基类
 */
public class HttpResult<T> {

    //用来模仿resultCode和resultMessage
    private int count;
    //用来模仿Data
    private T subjects;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public T getSubjects() {
        return subjects;
    }

    public void setSubjects(T subjects) {
        this.subjects = subjects;
    }

    private int start;
    private int total;
    private String title;

//    public T getData() {
//        return data;
//    }
//
//    public void setData(T data) {
//        this.data = data;
//    }
//
//    private int code;
//
//    public int getCode() {
//        return code;
//    }
//
//    public void setCode(int code) {
//        this.code = code;
//    }
//
//    public String getMessage() {
//        return message;
//    }
//
//    public void setMessage(String message) {
//        this.message = message;
//    }
//
//    private String message;
//
//    private T data;
}
