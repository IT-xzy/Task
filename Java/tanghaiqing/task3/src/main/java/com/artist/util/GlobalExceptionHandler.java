package com.artist.util;

import com.artist.pojo.StatusCode;
import com.artist.service.ApplicationException;
import org.apache.log4j.Logger;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {
    private Logger logger =Logger.getLogger(GlobalExceptionHandler.class);
    @ExceptionHandler
    @ResponseBody
    public StatusCode exHandle(Exception ex){
        System.out.println("看一下是不是你处理了");
        logger.info(ex.getMessage());
        StatusCode statusCode =new StatusCode();
        if(ex instanceof ApplicationException){
            statusCode.setMessage(ex.getMessage());
            logger.info(statusCode.toString());
        }
        if(ex instanceof MethodArgumentNotValidException){
            statusCode.setMessage(ex.getMessage());
        }else {
            statusCode.setMessage("未知错误！");
        }
        return statusCode;
    }
}
