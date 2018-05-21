package com.util;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * @author Arike
 * Create_at 2017/12/23 08:41
 */
@Component
@AllArgsConstructor
@NoArgsConstructor
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
