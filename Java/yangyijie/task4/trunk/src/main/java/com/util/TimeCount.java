package com.util;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * @author Arike
 * Create_at 2017/12/28 15:42
 */
@Component
public class TimeCount {
    private Long begin;
    Logger logger = Logger.getLogger(TimeCount.class);
    
    public void start(){
        begin = System.currentTimeMillis();
    }
    
    public void end(){
        logger.info("Controller执行耗时:"+(System.currentTimeMillis()-begin)+"毫秒");
    }
}
