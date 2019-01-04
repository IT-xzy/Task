package com.xiaobo.demo.entity;

import org.springframework.stereotype.Component;

@Component
public class Result<T> {
    private int code;
    private String message;
    private T data;

    public Result(int code,String message,T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
    public Result(){

    }
    public Result(int code,String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }
    public String getMessage() {
        return message;
    }
    public T getData() {
        return data;
    }

    public void setCode(int code) {
        this.code = code;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public void setData(T data) {
        this.data = data;
    }


    @Override
    public String toString() {
        return "Result{" + "code=" + code + ", message=" + message + ",data=" + data + "}";
    }
}
