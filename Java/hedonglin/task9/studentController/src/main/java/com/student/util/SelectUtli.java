package com.student.util;

import com.student.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.rmi.Naming;

public class SelectUtli {
    private static final Logger logger = LoggerFactory.getLogger(SelectUtli.class);

    public static StudentService getStudentService() {
        StudentService studentService = null;
        int random = (int) (Math.random() * 2) + 1;

        if (random == 1) {
            try {
                logger.error("get data from server1");
                studentService = (StudentService) Naming.lookup("//127.0.0.1:8999/TuscanyService");

            } catch (Exception e) {
                try {
                    logger.error("error occurred,turn to server2");
                    studentService = (StudentService) Naming.lookup("//127.0.0.1:8998/TuscanyService");
                } catch (Exception e1) {
                    e1.printStackTrace();
                }

            }
            
        } else {
            try {
                logger.error("get data from server1");
                studentService = (StudentService) Naming.lookup("//127.0.0.1:8998/TuscanyService");

            } catch (Exception e) {
                try {
                    logger.error("error occurred,turn to server1");
                    studentService = (StudentService) Naming.lookup("//127.0.0.1:8999/TuscanyService");
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        }
        return studentService;
    }
}
