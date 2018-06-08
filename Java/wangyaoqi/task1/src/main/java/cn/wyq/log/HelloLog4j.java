package cn.wyq.log;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class HelloLog4j {
    public static Logger logger=Logger.getLogger(HelloLog4j.class);
    public static void main(String[] args){
        PropertyConfigurator.configure("D:\\ideaproject\\myproject\\src\\main\\resources\\log4j.properties");
        logger.setLevel(Level.DEBUG);
        logger.trace("跟踪信息");
        logger.debug("调试信息");
        logger.info("输出信息");
        logger.warn("警告信息");
        logger.error("错误信息");
        logger.fatal("致命信息");
    }
}
