package com.mvc.aop;

import com.mvc.model.MonitorTimeAOP;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**@description: DB 接口性能分析
 * @Explain: 此切面的配置文件只能放在spring配置中*/
@Aspect
public class TimeService {

	private Logger logger =LoggerFactory.getLogger(TimeService.class);

	@Pointcut("execution(* com.mvc.service.*Service.*(..))")
	private void userServiceTime(){}

	/** @Description:  UserService 接口环绕通知*/
	@Around(value = "userServiceTime()")
	public Object dbLogTime(ProceedingJoinPoint proceedingJoinPoint)throws Throwable{
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
		logger.debug("---------------UserService接口切面开始---------------");
		// 毫秒为单位的当前时间
		long start = System.currentTimeMillis();
		Object result = proceedingJoinPoint.proceed();
		long time = System.currentTimeMillis() -start;
		monitorTime.setComsumeTime(time);
		logger.info( "性能日志 DB类 " + "响应时间: " + monitorTime.getComsumeTime() + "ms " + "执行信息: 执行 " + monitorTime.getClassName()+" 中方法 "+monitorTime.getMethodName() + " 执行时间: " + monitorTime.getLogTime() );
		return result;
	}
}