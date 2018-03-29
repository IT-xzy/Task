package task.jnshu.utils;

import org.aspectj.lang.ProceedingJoinPoint;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 *本类为springAOP的通知
 * 针对serviceImpl的类进行环绕通知
 * Created by Administrator on 4/8/2017.
 */
public class LogAdvice {
    private static org.apache.log4j.Logger loggerAdvice = org.apache.log4j.Logger.getLogger(LogAdvice.class);
    public void before() {
        System.out.println("前置通知");
    }

    public void after() {
        System.out.println("这是后置通知");
    }

    public Object around (ProceedingJoinPoint pip)throws Throwable{
        //获取组件类名
        String className = pip.getTarget().getClass().getName();
        //获取调用方法名
        String method = pip.getSignature().getName();
        //取得数据库连接前时间
        long begin = System.currentTimeMillis();
        // 当前系统时间
        String date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss") .format(new Date());
        Object obj = pip.proceed();

        //取得数据库连接后时间
        long end = System.currentTimeMillis();
        //sqlTime为数据库响应时间
        int sqlTime = (int)(end - begin);
        String msg = date + " ，执行了" + className + "." + method + "()";

        loggerAdvice.info(msg + "\t响应时间： "+ sqlTime);
        return  obj;
    }

    public void afterException(){
        System.out.println("这是异常通知");
    }

    public void afterAdvice(){

        System.out.println("这是一个后置异常通知");

    }

}