package com.ptt.advice;

import com.ptt.service.ITProfessionServiceImpl;
import com.ptt.util.TimeTranslateUtil;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * @ProjectName: task4
 * @Package: com.ptt.advice
 * @ClassName: ServiceAdvice
 * @Description: Count time used by operating the data base.
 * @Author: Jin
 * @CreateDate: 2018/5/24 10:37
 * @UpdateUser:
 * @UpdateDate: 2018/5/24 10:37
 * @UpdateRemark:
 * @Version: 1.0
 */
@Component
public class ServiceAdvice {
    private Long startTime;
    private Long endTime;
    private Logger logger = Logger.getLogger(ITProfessionServiceImpl.class);


    public void before(){
        startTime = System.currentTimeMillis();
        logger.info(TimeTranslateUtil.LongToString(startTime) + "开始操作数据库。");
    }

    public void after(){
        endTime = System.currentTimeMillis();
        logger.info(TimeTranslateUtil.LongToString(endTime) + "结束数据库操作。");
        logger.info("操作数据库用时：" + (endTime - startTime) + "ms");
    }
}
