package com.baidu.interceptor;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;

//@Aspect
public class TimeInterceptorUtil {
	private static Logger log = org.slf4j.LoggerFactory.getLogger(TimeInterceptor.class);

	public Object around(ProceedingJoinPoint proceedingJoinPoint){
		Object obj = null;
		Object[] args = proceedingJoinPoint.getArgs();
		long startTime = System.currentTimeMillis();
		try {
			obj = proceedingJoinPoint.proceed(args);
		} catch (Throwable e) {
			log.error("统计某方法执行耗时环绕通知出错", e);
		}
		// 获取执行的方法名
		long endTime = System.currentTimeMillis();
		MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
		String methodName = signature.getDeclaringTypeName() + "." + signature.getName();
		// 打印耗时的信息
		this.printExecTime(methodName, startTime, endTime);
		return obj;
	}
	//打印执行方法的时间
	private void printExecTime(String methodName, long startTime, long endTime) {
		long diffTime = endTime - startTime;
		log.warn(" "+ methodName + " 方法执行耗时: " + diffTime + " ms");
	}
}
