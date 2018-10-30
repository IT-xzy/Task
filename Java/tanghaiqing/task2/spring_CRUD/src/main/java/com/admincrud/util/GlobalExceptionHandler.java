package com.admincrud.util;

import com.admincrud.service.ApplicationException;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {
    private Logger logger =Logger.getLogger(GlobalExceptionHandler.class);
    @ExceptionHandler
    @ResponseBody
    public String exHandle(Exception ex){
        System.out.println("..................");
        String str;
        if (ex instanceof ApplicationException){
            System.out.println("看一下你进来没有");
            str=ex.getMessage();
            System.out.println(ex.getMessage());
        }else {
            str="未知错误！";
        }
        return str;
    }
}
