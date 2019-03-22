package com.xiaobo.demo.pojo;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class Response implements Serializable {
    private Integer code;
    private String message;


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


    public Response(){
        this.code = 200;
        this.message = "success";
    }
    public Response(Integer code, String message){
        this.code = code;
        this.message = message;
    }



}
