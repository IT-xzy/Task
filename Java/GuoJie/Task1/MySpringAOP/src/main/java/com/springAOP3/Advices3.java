package com.springAOP3;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Advices3 {
    private long startTime;
    private static Log logger= LogFactory.getLog(Advices3.class);
    public static final String POINT="execution(* com.springAOP3.BulkInsert.*(..))";

    @Before(POINT)
    public void Before(JoinPoint jp) {
        this.startTime=System.currentTimeMillis();
    }
    @After(POINT)
    public void After(){
        long endTime=System.currentTimeMillis();
        long time=endTime-startTime;
        System.out.println("方法执行了"+(time)+"ms");

    }
    @Around(POINT)
    public void Around(){

    }
}
