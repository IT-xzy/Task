package com.ptt.advice;

import com.ptt.util.TimeTransferUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @ProjectName: task4
 * @Package: com.ptt.advice
 * @ClassName: ControllerAdvice
 * @Description:
 * @Author: Jin
 * @CreateDate: 2018/5/24 10:59
 * @Version: 1.0
 */
@Component
public class ControllerAdvice {
    private Long startTime;
    private Long endTime;
    private Logger logger = LoggerFactory.getLogger(ControllerAdvice.class);

    public void before() {
        startTime = System.currentTimeMillis();
        logger.info(TimeTransferUtil.long2String(startTime) + "开始执行请求。");
    }
    public void after() {
        endTime = System.currentTimeMillis();
        logger.info(TimeTransferUtil.long2String(endTime) + "执行请求结束。");
        logger.info("执行请求用时：" + (endTime - startTime) + "ms");
    }
}
