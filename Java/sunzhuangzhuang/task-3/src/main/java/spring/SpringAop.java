package spring;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;

public class SpringAop {
    Logger logger = Logger.getLogger(SpringAop.class);
    Long a;
    public Long before(JoinPoint jp){
        a =System.currentTimeMillis();
        return a;
    }
    public void after(JoinPoint jp){
        Long b =System.currentTimeMillis();
        Long c=b-a;
        logger.info("执行方法耗时："+c);
    }
}
