package com.mylog4j;
import org.apache.log4j.Logger;
/**
 * @author Arike
 * Create_at 2017/11/21 20:39
 */
public class Test {
    private static Logger logger = Logger.getLogger(Test.class);
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        // System.out.println("This is println message.");
        
        // 记录debug级别以上的信息
        logger.debug("This is debug message.");
        // 记录info级别以上的信息
        logger.info("This is info message.");
        // 记录error级别以上的信息
       logger.error("This is error message.");
       
       logger.warn("This is warnning message");
       
       logger.fatal("This is fatal message");
    }
    
}
