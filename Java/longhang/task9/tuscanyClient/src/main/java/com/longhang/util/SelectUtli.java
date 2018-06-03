package com.longhang.util;

import com.longhang.stuService.StuService;
import org.apache.log4j.Logger;

import java.rmi.Naming;

public class SelectUtli {
    private static final Logger logger =Logger.getLogger(SelectUtli.class);

    public static StuService getStudentService() {
        StuService stuService = null;
        int random = (int) (Math.random() * 2) + 1;

        if (random == 1) {
            try {
                logger.error("get data from server1");
                stuService = (StuService) Naming.lookup("//127.0.0.1:8999/TuscanyService");
                logger.info("**********127.0.0.1:8999连接成功*********");

            } catch (Exception e) {
                try {
                    logger.error("error occurred,turn to server2");
                    stuService = (StuService) Naming.lookup("//127.0.0.1:8998/TuscanyService");
                    logger.info("**********127.0.0.1:8998连接成功*********");
                } catch (Exception e1) {
                    e1.printStackTrace();
                }

            }
            
        } else {
            try {
                logger.error("get data from server1");
                stuService = (StuService) Naming.lookup("//127.0.0.1:8998/TuscanyService");
                logger.info("**********127.0.0.1:8999连接成功*********");
            } catch (Exception e) {
                try {
                    logger.error("error occurred,turn to server1");
                    stuService = (StuService) Naming.lookup("//127.0.0.1:8999/TuscanyService");
                    logger.info("**********127.0.0.1:8999连接成功*********");
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        }
        return stuService;
    }
}
