package com.xiaobo.demo.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Map;
//import java.util.logging.Logger;
import org.apache.log4j.Logger;

@Component
public class Response {
    private static Logger log = Logger.getLogger(Response.class);
    @Autowired
    public MessageSource messageSource;
    public Map msg(String msg) {
        String error = messageSource.getMessage(msg,null,null);
        log.warn(error);
        System.out.println(error);
        Map map = null;
        return map;
    }
}
