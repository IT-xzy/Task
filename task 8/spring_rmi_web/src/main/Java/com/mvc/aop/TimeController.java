package com.mvc.aop;

import com.mvc.model.MonitorTimeAOP;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

@Aspect
public class TimeController {
	private static Logger logger = LoggerFactory.getLogger(TimeController.class);

	/** @Description: 定义切入点
	 * @Explain: com.mvc.controller.*Controller*.* 切入所有controller包下类名包含Controller的类的所有方法*/
	@Pointcut(value = "execution(* com.mvc.controller.*Controller*.*(..))")
	private void handlerTime(){}

	/** @Description: 环绕通知
	 * @Explain: handlerTimer() 代表使用 handlerTimer()的切点*/
	@Around(value = "handlerTime()")
	public Object controllerLogTime(ProceedingJoinPoint proceedingJoinPoint)throws Throwable {
		// 创建性能监控信息类
		MonitorTimeAOP monitorTime = new MonitorTimeAOP();
		// 获取目标类名
		String clazzName = proceedingJoinPoint.getTarget().getClass().getName();
		// 获取目标方法名
		String methodName = proceedingJoinPoint.getSignature().getName();

		// 记录目标类名
		monitorTime.setClassName(clazzName);
		// 记录目标方法名
		monitorTime.setMethodName(methodName);
		// 记录开始时间
		monitorTime.setLogTime(new Date());

		// 计时并调用目标函数
		logger.debug("---------------Controller切面开始---------------");
		// System.currentTimeMillis() 返回当前时间,单位毫秒ms
		long start = System.currentTimeMillis();
		// 执行代理类
		Object result = proceedingJoinPoint.proceed();
		long time = System.currentTimeMillis() -start;
		monitorTime.setComsumeTime(time);
		logger.info("性能日志 Controller类 " + "响应时间: " + monitorTime.getComsumeTime() + "ms " + "执行信息: 执行 " + monitorTime.getClassName()+" 中方法 "+monitorTime.getMethodName() + " 执行时间: " + monitorTime.getLogTime() );
		return result;
	}
}
