package com.artist.pojo;

public class StatusCode<T> {//responseResult
    private Integer code;
    private String message;
    private T date;

    public StatusCode() {
    }

    public StatusCode(Integer code, String message, T date) {
        this.code = code;
        this.message = message;
        this.date = date;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getDate() {
        return date;
    }

    public void setDate(T date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "StatusCode{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", date=" + date +
                '}';
    }
}
