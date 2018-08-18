package com.leo.aspect;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//      controller性能时间
//      注：此切面配置只能在springmvc中

@Aspect
@Component
public class TimeAspectController {
	
	private static final Logger logger = (Logger) LogManager.getLogger("TimeAspectControllerLog");
	// Pointcut 定义切点：StudentController类中的所有方法
	@Pointcut(value = "execution(* com.leo.controller.StudentController.*(..))")
	public void controllerAspect(){
	}
	
	// joinPint 连接点
	@Around(value = "controllerAspect()")
	public Object timeLog(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		// 获取目标方法名
		String methodName = proceedingJoinPoint.getSignature().getName();
		// 计时并调用目标函数
		long startTime = System.currentTimeMillis();
		// 执行代理类（不懂）
		Object object = proceedingJoinPoint.proceed();
		long handleTime = System.currentTimeMillis() - startTime;
		// 如果处理时间大于400毫秒，打印警告信息
		if(handleTime > 400){
			logger.warn("Method:"+methodName+" HandleTime:"+handleTime+" ms");
		} else {
			logger.info("Method:"+methodName+" HandleTime:"+handleTime+" ms");
		}
		
		return object;
	}
}
