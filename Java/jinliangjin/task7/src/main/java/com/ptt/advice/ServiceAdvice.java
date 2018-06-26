package com.ptt.advice;

import com.ptt.util.TimeTransferUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @ClassName: ServiceAdvice
 * @Description: Statistics of service time.
 * @Author: Jin
 * @CreateDate: 2018/6/12 10:19
 * @Version: 1.0
 */
@Component
public class ServiceAdvice {
    private Long start;
    private Long end;
    private Logger logger = LoggerFactory.getLogger(ServiceAdvice.class);

    public void serviceStart(){
        start = System.currentTimeMillis();
        logger.info(TimeTransferUtil.long2String(start) + "开始执行service层。");
    }

    public void serviceEnd(){
        end = System.currentTimeMillis();
        logger.info(TimeTransferUtil.long2String(end) + "service层执行完成。");
        logger.info("执行service层用时" + (end-start) + "ms");
    }
}
