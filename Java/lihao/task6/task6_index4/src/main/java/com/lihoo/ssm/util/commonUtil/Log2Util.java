package com.lihoo.ssm.util.commonUtil;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.springframework.stereotype.Component;

/**
 * #Title: Log2Util
 * #ProjectName task6_index1
 * #Description: TODO
 * #author lihoo
 * #date 2018/9/17-14:23
 */

@Component
public class Log2Util {
    public static Logger logger = (Logger) LogManager.getLogger(Log2Util.class);
}
