package com.jnshu.aop;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;

public class AdvicesM {
    private static Logger logger = Logger.getLogger("AdvicesM.class");
    long beginm;
    String methodName = null;

    public void before(JoinPoint jp) {
        beginm = System.currentTimeMillis();
    }

    public void after(JoinPoint jp) {
        methodName = jp.getSignature().getName();
        logger.info("方法" + methodName + "处理完成！方法处理耗时: " + ((double) (System.currentTimeMillis() - beginm) / 1000) + " 秒！\n");
    }
}
