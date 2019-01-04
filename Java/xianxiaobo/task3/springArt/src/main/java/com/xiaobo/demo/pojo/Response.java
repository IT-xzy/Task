package com.xiaobo.demo.pojo;

import org.springframework.stereotype.Component;

@Component
public class Response {
    private Integer code;
    private String message;
    private Integer total;

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

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Response(){
        this.code = 200;
        this.message = "success";
    }
    public Response(Integer total){
        this.code = 200;
        this.message = "success";
        this.total = total;
    }
    public Response(Integer code, String message){
        this.code = code;
        this.message = message;
    }
    public Response(Integer code, String message,Integer total){
        this.code = code;
        this.message = message;
        this.total = total;
    }



}
