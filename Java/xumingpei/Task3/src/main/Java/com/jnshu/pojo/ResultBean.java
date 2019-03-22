package com.jnshu.pojo;

/**
 * @author pipiretrak
 * @date 2019/3/20 - 21:34
 */
public class ResultBean<T> {

    private String msg;

    private int code;

    private T data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
