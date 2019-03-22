package com.suger.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;
import org.springframework.stereotype.Component;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * @author suger
 * @date 2019/1/7 20:02
 * 随机选择RMI 服务端
 */
@Component
public class RMIService {

    private static final Logger logger = LoggerFactory.getLogger(RMIService.class);

    /**
     * 随机数获取 StudentService (利用三目表达式） eg: A?B:C ,A为true,则为B,A为false,则为C
     * 随机生成（0,1）内的数字，大于0.5 启动第1个service,小于0.5，则启动第2个service
     * 如果发生异常，特别是与RMI相关的异常，则直接切换除自己以外的服务端
     * @return studentService
     */
    public StudentService getStudentService()  {
        StudentService studentService =  null ;
        int randomNum = Math.random() >= 0.5 ? 1 : 0;
        if (1 == randomNum) {
            try {
                //studentService = (StudentService) rmiProxyFactoryStudent1.getObject();
                studentService = (StudentService) Naming.lookup("rmi://172.27.0.6:28388/StudentService");
            } catch (Exception e) {
                logger.info("服务器1挂了，{}",e);
                try {
                    //studentService = (StudentService) rmiProxyFactoryStudent2.getObject();
                    studentService = (StudentService) Naming.lookup("rmi://172.27.0.6:38388/StudentService");
                } catch (NotBoundException | MalformedURLException |RemoteException e1) {
                    logger.info("服务器1,2都挂了，{}",e1);
                }
            }
        }
        else {
            try {
                //studentService = (StudentService) rmiProxyFactoryStudent1.getObject();
                studentService = (StudentService) Naming.lookup("rmi://172.27.0.6:38388/StudentService");
            } catch (Exception e) {
                logger.info("服务器2挂了，{}",e);
                try {
                    //studentService = (StudentService) rmiProxyFactoryStudent2.getObject();
                    studentService = (StudentService) Naming.lookup("rmi://172.27.0.6:28388/StudentService");
                } catch (Exception e1) {
                    logger.info("服务器1,2都挂了，{}",e1);
                }
            }
        }
        logger.info(" studentService:{}",studentService);
        return studentService;
    }

    public UserService getUserService() {
        UserService userService = null;
        int randomNum = Math.random() >= 0.5 ? 1 : 0;
        if (1 == randomNum) {
            try {
                userService = (UserService) Naming.lookup("rmi://172.27.0.6:28388/UserService");
            } catch (Exception e) {
                logger.info("服务器1挂了，{}",e);
                try {
                    userService = (UserService) Naming.lookup("rmi://172.27.0.6:38388/UserService");
                } catch (Exception e1) {
                    logger.info("服务器1,2都挂了，{}",e1);
                }
            }
        }
        else {
            try {
                userService = (UserService) Naming.lookup("rmi://172.27.0.6:38388/UserService");
            } catch (Exception e) {
                logger.info("服务器2挂了，{}",e);
                try {
                    userService = (UserService) Naming.lookup("rmi://172.27.0.6:28388/UserService");
                } catch (Exception e1) {
                    logger.info("服务器1,2都挂了，{}",e1);
                }
            }
        }
        logger.info("userService:{}",userService);
        return userService;
    }


    public ProfessionService getProfessionService() {
        ProfessionService professionService = null;
        int randomNum = Math.random() >= 0.5 ? 1 : 0;
        if (1 == randomNum) {
            try {
               professionService = (ProfessionService) Naming.lookup("rmi://172.27.0.6:28388/ProfessionService");
            } catch (Exception e) {
                logger.info("服务器1挂了，{}",e);
                try {
                    professionService = (ProfessionService) Naming.lookup("rmi://172.27.0.6:38388/ProfessionService");
                } catch (Exception e1) {
                    logger.info("服务器1,2都挂了，{}",e1);
                }
            }
        }
        else {
            try {
                professionService = (ProfessionService) Naming.lookup("rmi://172.27.0.6:38388/ProfessionService");
            } catch (Exception e) {
                logger.info("服务器2挂了，{}",e);
                try {
                    professionService = (ProfessionService) Naming.lookup("rmi://172.27.0.6:28388/ProfessionService");
                } catch (Exception e1) {
                    logger.info("服务器1,2都挂了，{}",e1);
                }
            }
        }
        logger.info("professionService:{}",professionService);
        return professionService;
    }

    public UploadService getUplaodService() {

        UploadService uploadService = null;
        int randomNum = Math.random() >= 0.5 ? 1 : 0;
        if (1 == randomNum) {
            try {
                uploadService = (UploadService) Naming.lookup("rmi://172.27.0.6:28388/UploadService");
            } catch (Exception e) {
                logger.info("服务器1挂了，{}",e);
                try {
                    uploadService = (UploadService) Naming.lookup("rmi://172.27.0.6:38388/UploadService");
                } catch (Exception e1) {
                    logger.info("服务器1,2都挂了，{}",e1);
                }
            }
        }
        else {
            try {
                uploadService = (UploadService) Naming.lookup("rmi://172.27.0.6:38388/UploadService");
            } catch (Exception e) {
                logger.info("服务器2挂了，{}",e);
                try {
                    uploadService = (UploadService) Naming.lookup("rmi://172.27.0.6:28388/UploadService");
                } catch (Exception e1) {
                    logger.info("服务器1,2都挂了，{}",e1);
                }
            }
        }
        logger.info("uploadService:{}",uploadService);
        return uploadService;
    }

}
