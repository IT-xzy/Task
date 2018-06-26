package com.alibaba.aop;
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
        logger.info("method " + methodName + "Time consuming： " + ((double) (System.currentTimeMillis() - beginm) ) + " 毫秒！\n");
    }
}
