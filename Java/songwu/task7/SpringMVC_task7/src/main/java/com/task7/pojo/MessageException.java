package com.task7.pojo;

/**
 * Create by SongWu on 2018/8/10
 */
public class MessageException extends Exception{
    //异常信息
    public String message;

    public MessageException(String message) {
        super(message);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
