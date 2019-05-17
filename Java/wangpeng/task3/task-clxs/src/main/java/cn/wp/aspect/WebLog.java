package cn.wp.aspect;

import java.lang.annotation.*;

/**
 * @ClassName: WebLog
 * @Description: 日志
 * @Author: 老王
 * @Date: 2019/5/16 16:50
 * @Version: 1.0
 */
//定义运行时使用该注解
@Retention(RetentionPolicy.RUNTIME)
//定义作用于方法上
@Target({ElementType.METHOD})
//注解是否将包含在JavaDoc中
@Documented
public @interface WebLog {
    /**
     * 日志描述信息
     *
     * @return
     */
    String description() default "";

}