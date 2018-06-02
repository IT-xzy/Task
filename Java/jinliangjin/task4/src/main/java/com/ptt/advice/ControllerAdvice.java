package com.ptt.advice;

import com.ptt.util.TimeTranslateUtil;
import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @ProjectName: task4
 * @Package: com.ptt.advice
 * @ClassName: ControllerAdvice
 * @Description:
 * @Author: Jin
 * @CreateDate: 2018/5/24 10:59
 * @UpdateUser:
 * @UpdateDate: 2018/5/24 10:59
 * @UpdateRemark:
 * @Version: 1.0
 */
@Component
public class ControllerAdvice {
    private Long startTime;
    private Long endTime;
    private Logger logger = Logger.getLogger(ControllerAdvice.class);

    public void before() {
        startTime = System.currentTimeMillis();
        logger.info(TimeTranslateUtil.LongToString(startTime) + "开始执行请求。");
    }
    public void after() {
        endTime = System.currentTimeMillis();
        logger.info(TimeTranslateUtil.LongToString(endTime) + "执行请求结束。");
        logger.info("执行请求用时：" + (endTime - startTime) + "ms");
    }
}
