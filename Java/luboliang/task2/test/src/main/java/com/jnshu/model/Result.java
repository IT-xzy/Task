package com.jnshu.model;

import java.util.List;

public class Result {
    int code ;
    String message;
    List<Student> data;

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

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", messages.properties='" + message + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}
