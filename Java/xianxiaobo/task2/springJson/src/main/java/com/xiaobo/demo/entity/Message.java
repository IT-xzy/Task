package com.xiaobo.demo.entity;

import org.springframework.stereotype.Component;

@Component
public class Message {
    private int code;
    private String message;


    public int getCode() {
        return code;
    }
    public String getMessage() {
        return message;
    }


    public Message(int code, String message){
        this.code = code;
        this.message = message;
    }
    public Message(){

    }



    @Override
    public String toString() {
        return "Result{" + "code=" + code + ", message=" + message + "}";
    }
}
