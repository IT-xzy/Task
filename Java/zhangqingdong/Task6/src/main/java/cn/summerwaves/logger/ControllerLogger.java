package cn.summerwaves.logger;

import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

public class ControllerLogger {
    long start;
    long end;

    private static Logger logger = Logger.getLogger("ControllerLogger.class");

    public ControllerLogger() {

    }



    /* imp包下所有的Service中所有的方法都会在依次在前、后添加下面的两个方法 */
    @Pointcut("execution(* cn.summerwaves.util.XMemcachedUtil.getCache())")
    public void cachePoint() {

    }

    @Before("cachePoint()")
    public void beforeTime() {
        start=System.currentTimeMillis();
    }

    @After("cachePoint()")
    public void afterTime() {
        end = System.currentTimeMillis();
        logger.error("控制器的响应时间为: "+(end-start));
    }

}
