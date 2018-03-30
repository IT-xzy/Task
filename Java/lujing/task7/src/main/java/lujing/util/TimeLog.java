package lujing.util;


import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * 
 * @ClassName:
 * @Description: 日志记录AOP实现
 * @author shaojian.yu
 * @date 2014年11月3日 下午1:51:59
 * 
 */
@Aspect
@Component
public class TimeLog {
	private final Logger logger = Logger.getLogger(this.getClass());
	// 开始时间
	private long startTimeMillis = 0;
	// 结束时间
	private long endTimeMillis = 0;

	/**
	 * 
	 * @Title：doBeforeInServiceLayer
	 * @Description: 方法调用前触发 记录开始时间
	 * @param joinPoint
	 */
	@Before("execution(* lujing.controller..*.*(..))")
	public void doBeforeInServiceLayer(JoinPoint joinPoint) {
		// 记录方法开始执行的时间
		startTimeMillis = System.currentTimeMillis();
		System.out.println("记录方法开始执行的时间");
	}

	/**
	 * 
	 * @Title：doAfterInServiceLayer
	 * @Description: 方法调用后触发 记录结束时间
	 * @param joinPoint
	 */
	@After("execution(* lujing.controller..*.*(..))")
	public void doAfterInServiceLayer(JoinPoint joinPoint) {
		// 记录方法执行完成的时间
		endTimeMillis = System.currentTimeMillis();
		System.out.println("记录方法结束执行的时间");

		this.printOptLog();
	}

	/**
	 * 
	 * @Title：doAround
	 * @Description: 环绕触发
	 * @throws Throwable
	 */
	// @Around("execution(* com.yusj.controller..*.*(..))")
	// public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
	//
	// }

	/**
	 * 
	 * @Title：printOptLog
	 * @Description: 输出日志
	 */
	private void printOptLog() {

		logger.info("方法执行时间：" + (endTimeMillis - startTimeMillis) + "ms ;");
	}
}