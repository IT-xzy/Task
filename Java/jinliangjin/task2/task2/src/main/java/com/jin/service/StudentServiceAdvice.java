package com.jin.service;

import com.jin.Util.TimeTranslateUtil;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @ProjectName: task2
 * @Package: com.jin.service
 * @ClassName: CustomerServiceAdvice
 * @Description:
 * @Author: Jin
 * @CreateDate: 2018/5/10 9:14
 * @UpdateUser:
 * @UpdateDate: 2018/5/10 9:14
 * @UpdateRemark:
 * @Version: 1.0
 */
@Aspect
@Component
public class StudentServiceAdvice {
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
        System.out.println(TimeTranslateUtil.LongToString(start) + "开始调用方法。");
    }

    /**
     * @Description: AOP后置增强
     * 〈〉
     * * @param
     * @return: void
     * @since: 1.0.0
     * @Date: 2018/4/28 14:36
     */
    public void afterMethod() {

        finish = System.currentTimeMillis();
        System.out.println(TimeTranslateUtil.LongToString(finish) + "结束方法调用。");
        System.out.println("方法执行了" + (double) (finish - start) / 1000 + "秒");
    }
}
