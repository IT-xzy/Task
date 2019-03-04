package com.jnshu.rmi.beans;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@Data
//@JsonIgnoreProperties(value={“hibernateLazyInitializer”,”handler”,”operations”,”roles”,”menus”})
public class Response<T> implements Serializable{
    private Integer code;
    private String message;
    private T data;

    private static final long serialVersionUid = 1L;

    public Response() {
    }

    public Response(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
