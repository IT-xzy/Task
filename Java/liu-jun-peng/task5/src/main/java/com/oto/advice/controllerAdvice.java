package com.oto.advice;

import com.oto.controller.pttController;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author: 刘军鹏
 * @program: task4
 * @description:
 * @create: 2018/6/7 下午12:31
 */
@Component
public class controllerAdvice {
    private Long start;
    private Long end;
    private Logger logger = Logger.getLogger(pttController.class);
    
    public void before(){
        start = System.currentTimeMillis();
        Date date = new Date(start);
        logger.info(date + "开始执行");
    }
    
    public void after(){
        end = System.currentTimeMillis();
        Date date = new Date(end);
        logger.info(date+ "执行完成");
        logger.info("执行用时"+(double)(end-start)/1000+"秒");
    }
    
    
    

}
