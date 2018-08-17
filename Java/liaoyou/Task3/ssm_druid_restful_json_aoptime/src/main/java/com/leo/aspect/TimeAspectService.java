package com.leo.aspect;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//      DB接口性能分析
//      注：此切面配置只能在spring中

@Aspect
@Component
public class TimeAspectService {
	
	private static Logger logger = (Logger) LogManager.getLogger("TimeAspectServiceLog");
	
	// Pointcut 定义切点：service接口中的所有方法
	// 这里使用的是接口，用它的实现类效果一样
	@Pointcut(value = "execution(* com.leo.service.StudentService.*(..))")
	public void serviceAspect(){
	}
	
	@Around(value = "serviceAspect()")
	public Object timeLog(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		// 获取目标方法
		String methodName = proceedingJoinPoint.getSignature().getName();
		// 统计时间
		long startTime = System.currentTimeMillis();
		Object object = proceedingJoinPoint.proceed();
		long handleTime = System.currentTimeMillis() - startTime;
		logger.debug("DB切面已执行");
		// 如果处理时间大于400毫秒，打印警告信息
		if(handleTime > 400){
			logger.warn("Method:"+methodName+" HandleTime:"+handleTime+" ms");
		} else {
			logger.info("Method:"+methodName+" HandleTime:"+handleTime+" ms");
		}
		
		return object;
	}
}
