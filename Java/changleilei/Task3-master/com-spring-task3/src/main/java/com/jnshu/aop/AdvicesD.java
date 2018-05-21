package com.jnshu.aop;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;

public class AdvicesD {
    private static Logger logger = Logger.getLogger("AdvicesD.class");
    long dbegin;
    String serviceName = null;

    public void before(JoinPoint jp) {
        dbegin = System.currentTimeMillis();
    }

    public void after(JoinPoint jp) {
        serviceName = jp.getSignature().getName();
        logger.info("数据库" + serviceName + "处理完成！DB处理耗时： " + ((double) (System.currentTimeMillis() - dbegin) / 1000) + " 秒！\n");
    }
}
