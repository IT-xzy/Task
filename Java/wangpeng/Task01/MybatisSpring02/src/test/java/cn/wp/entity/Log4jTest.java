/**
 * Author: 老王
 * Date: 2019/4/7 20:31
 */
package cn.wp.entity;

import org.junit.Test;
import org.apache.log4j.Logger;

public class Log4jTest {
    private static Logger logger = Logger.getLogger(Log4jTest.class);

    @Test
    public void test() {
        logger.debug("看这里");
    }
}