package com.util;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * @author Arike
 * Create_at 2017/12/28 15:42
 */
@Component
public class TimeCountUtil {
    private Long begin;
    Logger logger = Logger.getLogger(TimeCountUtil.class);
    
    public void start(){
        begin = System.currentTimeMillis();
    }
    
    public void end(){
        logger.info("Controller执行耗时:"+(System.currentTimeMillis()-begin)+"毫秒");
    }
}
