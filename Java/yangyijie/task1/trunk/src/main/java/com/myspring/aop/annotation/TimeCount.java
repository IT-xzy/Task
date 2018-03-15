package com.myspring.aop.annotation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author Arike
 * Create_at 2017/12/7 15:10
 */
@Aspect
@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TimeCount {
    
    private long timebegin ;
    
    @Pointcut("execution(* com.myspring.aop.annotation.Run.circle(..))")
    public void circles() {
    }
    
    @Before("circles()")
    public void start() {
        timebegin = System.currentTimeMillis();
    }
    
    @After("circles()")
    public void end() {
        System.out.println("总耗时" + ((double)System.currentTimeMillis() - timebegin)/1000+"毫秒");
    }
}
