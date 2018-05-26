package com.enroll.service;

import com.enroll.util.TimeTransformUtil;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @ProjectName: task1
 * @Package: com.enroll.service
 * @ClassName: ServiceAdvice
 * @Description:
 * @Author: Jin
 * @CreateDate: 2018/4/27 20:12
 * @UpdateUser:
 * @UpdateDate: 2018/4/27 20:12
 * @UpdateRemark:
 * @Version: 1.0
 */
@Aspect//AspectJ自动代理
@Component("serviceAdvice")
public class ServiceAdvice {
    private Long start;
    private Long finish;

    /**
     * @Description: AOP前置增强
     * 〈〉
     * * @param
     * @return: void
     * @since: 1.0.0
     * @Date: 2018/4/28 14:35
     */
    public void beforeMethod() {
        start = System.currentTimeMillis();
        //将start转化为date形式的字符串，并且按照年月日时分秒的格式输出
        System.out.println(TimeTransformUtil.LongToString(start) + "开始调用方法。");
    }

    /**
     * @Description: AOP后置增强
     * 〈〉
     * * @param
     * @return: void
     * @since: 1.0.0
     * @Date: 2018/4/28 14:36
     */
//通过注解自动代理，切点好像不能用xml文件中的定义的切点所对应的id
    @After("execution(* com.enroll.service.EntryFormService.*(..))")
    public void afterMethod() {

        finish = System.currentTimeMillis();
        System.out.println(TimeTransformUtil.LongToString(finish) + "结束方法调用。");
        System.out.println("方法执行了" + (double) (finish - start) / 1000 + "秒");
    }
}
