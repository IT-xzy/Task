package com.alibaba.aop;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;

public class AdvicesD {

private  static Logger logger = Logger.getLogger("AdvicesD.class");
long begin;
String serviceName = null;
public void before (JoinPoint jp){
    begin = System.currentTimeMillis();
}
public void after(JoinPoint jp){
    serviceName = jp.getSignature().getName();
    logger.info("database " + serviceName + "Time consuming: " +((double) (System.currentTimeMillis()-begin)) + "ms! ");
}
}
