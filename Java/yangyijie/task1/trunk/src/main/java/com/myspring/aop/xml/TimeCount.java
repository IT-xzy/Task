package com.myspring.aop.xml;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Arike
 * Create_at 2017/12/7 15:10
 */

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TimeCount {
   
    private long timebegin;
    
    public void start() {
        timebegin = System.currentTimeMillis();
    }
    
    public void end() {
        System.out.println("总耗时" + (System.currentTimeMillis() - timebegin)+"毫秒");
    }
}
