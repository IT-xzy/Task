package com.how2java.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.context.annotation.Bean;

public class TestMain {

    @Bean
    @Test
    public void testMain() {
        Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

        logger.trace("trace level");
        logger.debug("debug level");
        logger.info("info level");
        logger.warn("warn level");
        logger.error("error level");
        logger.fatal("fatal level");
    }
}