package com.jnshu.controller;

import com.jnshu.entity.Student4;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.logging.Logger;

@Controller
public class LogTest {
    Logger logger = Logger.getLogger(LogTest.class.getName());

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        Student4 student4 = new Student4();
        logger.warning("student========" + student4);
        logger.info("student========" + student4);
        return "test";
    }
}
