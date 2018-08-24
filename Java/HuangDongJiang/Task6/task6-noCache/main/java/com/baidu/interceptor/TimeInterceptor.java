package com.baidu.interceptor;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;
@Aspect
@Component
public class TimeInterceptor  {
    private static Logger log = org.slf4j.LoggerFactory.getLogger(TimeInterceptor.class);

    public static final String CONTROLLER_POINT = "execution(* com.baidu.controller.*.*(..))";
    public static final String DAO_POINT = "execution(* com.baidu.dao.*.*(..))";

    @Around(CONTROLLER_POINT)
    public Object aroundControler(ProceedingJoinPoint proceedingJoinPoint){
		TimeInterceptorUtil timeInterceptorUtil = new TimeInterceptorUtil();
		Object obj = timeInterceptorUtil.around(proceedingJoinPoint);
		return obj;
	}
	@Around(DAO_POINT)
	public Object aroundDaao(ProceedingJoinPoint proceedingJoinPoint){
		TimeInterceptorUtil timeInterceptorUtil = new TimeInterceptorUtil();
		Object obj = timeInterceptorUtil.around(proceedingJoinPoint);
		return obj;
	}
}

