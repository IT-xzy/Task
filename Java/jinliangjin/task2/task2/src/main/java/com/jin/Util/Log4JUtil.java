package com.jin.Util;




import org.apache.log4j.Logger;
import sun.reflect.Reflection;



/**
 * @ProjectName: task2
 * @Package: com.jin.Util
 * @ClassName: Log4JUtil
 * @Description:
 * @Author: Jin
 * @CreateDate: 2018/5/15 16:33
 * @UpdateUser:
 * @UpdateDate: 2018/5/15 16:33
 * @UpdateRemark:
 * @Version: 1.0
 */
public class Log4JUtil {
    private static Logger logger = null;
    public static Logger getLogger(){
        if(null == logger){
            logger = Logger.getLogger(Reflection.getCallerClass().getName());
            logger.info("类名：" + Reflection.getCallerClass().getName());
        }
        return logger;
    }
}
