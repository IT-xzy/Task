package com.jnshu.task7.beans;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@Data
public class Response<T> implements Serializable {
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
