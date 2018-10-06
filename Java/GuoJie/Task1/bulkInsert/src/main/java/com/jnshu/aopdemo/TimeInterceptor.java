package com.jnshu.aopdemo;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TimeInterceptor {
    private long startTime;
    private static Log logger= LogFactory.getLog(TimeInterceptor.class);
    public static final String POINT="execution(* com.jnshu.jdbc.JdbcUntils.*(..))";

    @Before(POINT)
    public void Before(JoinPoint jp) {
            this.startTime=System.currentTimeMillis();
    }
    @After(POINT)
    public void After(){
        long endTime=System.currentTimeMillis();
        System.out.println("方法执行了"+(endTime-startTime)+"ms");

    }
}
