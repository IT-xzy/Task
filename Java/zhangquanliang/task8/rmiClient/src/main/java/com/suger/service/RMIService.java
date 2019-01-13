package com.suger.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;
import org.springframework.stereotype.Component;

/**
 * @author suger
 * @date 2019/1/7 20:02
 * 随机选择RMI 服务端
 */
@Component
public class RMIService {

    private static final Logger logger = LoggerFactory.getLogger(RMIService.class);

    /**
     * 分别注入2个service,其中每个包括4项服务：ProfessionService,UserService,StudentService,UploadService
     */
    @Autowired
    @Qualifier("professionService1")
    private RmiProxyFactoryBean rmiProxyFactoryProfession1;

    @Autowired
    @Qualifier("studentService1")
    private RmiProxyFactoryBean rmiProxyFactoryStudent1;

    @Autowired
    @Qualifier("userService1")
    private RmiProxyFactoryBean rmiProxyFactoryUser1;


    @Autowired
    @Qualifier("uploadService1")
    private RmiProxyFactoryBean rmiProxyFactoryUpload1;

    @Autowired
    @Qualifier("professionService2")
    private RmiProxyFactoryBean rmiProxyFactoryProfession2;

    @Autowired
    @Qualifier("studentService2")
    private RmiProxyFactoryBean rmiProxyFactoryStudent2;

    @Autowired
    @Qualifier("userService2")
    private RmiProxyFactoryBean rmiProxyFactoryUser2;


    @Autowired
    @Qualifier("uploadService2")
    private RmiProxyFactoryBean rmiProxyFactoryUpload2;


    /**
     * 随机数获取 StudentService (利用三目表达式） eg: A?B:C ,A为true,则为B,A为false,则为C
     * 随机生成（0,1）内的数字，大于0.5 启动第1个service,小于0.5，则启动第2个service
     * 如果发生异常，特别是与RMI相关的异常，则直接切换除自己以外的服务端
     * @return studentService
     */
    public StudentService getStudentService() {
        StudentService studentService;
        int randomNum = Math.random() >= 0.5 ? 1 : 0;
        if (1 == randomNum) {
            try {
                studentService = (StudentService) rmiProxyFactoryStudent1.getObject();
            } catch (Exception e) {
                studentService = (StudentService) rmiProxyFactoryStudent2.getObject();
            }
        } else {
            try {
                studentService = (StudentService) rmiProxyFactoryStudent2.getObject();
            } catch (Exception e) {
                studentService = (StudentService) rmiProxyFactoryStudent1.getObject();
            }
        }
        logger.info(" studentService:{}",studentService);
        return studentService;
    }

    public UserService getUserService() {
        UserService userService;
        int randomNum = Math.random() >= 0.5 ? 1 : 0;
        if (1 == randomNum) {
            try {
                userService = (UserService) rmiProxyFactoryUser1.getObject();
            } catch (Exception e) {
                userService = (UserService) rmiProxyFactoryUser2.getObject();
            }
        } else {
            try {
                userService = (UserService) rmiProxyFactoryUser2.getObject();
            } catch (Exception e) {
                userService = (UserService) rmiProxyFactoryUser1.getObject();
            }
        }
        logger.info("userService:{}",userService);
        return userService;
    }


    public ProfessionService getProfessionService() {
        ProfessionService professionService;
        int randomNum = Math.random() >= 0.5 ? 1 : 0;
        if (1 == randomNum) {
            try {
               professionService = (ProfessionService) rmiProxyFactoryProfession1.getObject();
            } catch (Exception e) {
                professionService = (ProfessionService) rmiProxyFactoryProfession2.getObject();
            }
        } else {
            try {
                professionService = (ProfessionService) rmiProxyFactoryProfession2.getObject();

            } catch (Exception e) {
                professionService = (ProfessionService) rmiProxyFactoryProfession1.getObject();
            }
        }
        logger.info("professionService:{}",professionService);
        return professionService;
    }

    public UploadService getUplaodService() {

        UploadService uploadService;
        int randomNum = Math.random() >= 0.5 ? 1 : 0;
        if (1 == randomNum) {
            try {
               uploadService = (UploadService) rmiProxyFactoryUpload1.getObject();
            } catch (Exception e) {
                uploadService = (UploadService) rmiProxyFactoryUpload2.getObject();
            }
        } else {
            try {
                uploadService = (UploadService) rmiProxyFactoryUpload2.getObject();
            } catch (Exception e) {
                uploadService = (UploadService) rmiProxyFactoryUpload2.getObject();
            }
        }
        logger.info("uploadService:{}",uploadService);
        return uploadService;
    }




}
