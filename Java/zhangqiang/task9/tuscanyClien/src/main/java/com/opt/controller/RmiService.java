package com.opt.controller;

import com.opt.service.ProfessionService;
import com.opt.service.StudentService;
import com.opt.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.remoting.RemoteConnectFailureException;
import org.springframework.stereotype.Component;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

@Component
public class RmiService {

    private static Logger logger = Logger.getLogger(RmiService.class);

//    ApplicationContext act = new ClassPathXmlApplicationContext("applicationcontext.xml");
//    public UserService getUserService(){
//        return (UserService) act.getBean("userServiceImpl");
//    }
//    public StudentService getStudentService(){
//        return (StudentService) act.getBean("studentServiceImpl");
//    }
//    public ProfessionService getProfessionService(){
//        return (ProfessionService) act.getBean("professionServiceImpl");
//    }
//    @Autowired
//    @Qualifier("userService")
//    private UserService userService;
//
//    @Autowired
//    @Qualifier("userServiceB")
//    private UserService userServiceB;
//
//    @Autowired
//    @Qualifier("studentServer")
//    private StudentService studentServer;
//
//    @Autowired
//    @Qualifier("studentServerB")
//    private StudentService studentServerB;

//    public UserService getUserService() {
//        return (UserService) act.getBean("userService");
//
//    }
//    public StudentService getStudentService() {
//        return (StudentService) act.getBean("studentServer");
//    }

    public UserService getUserService(){

        try {
//                return (UserService) Naming.lookup("rmi://47.98.50.21:1098/userServer");
//                return (UserService) Naming.lookup("rmi://119.29.17.188:1098/userServer");
                return (UserService) Naming.lookup("rmi://127.0.0.1:1098/userServer");
            } catch (Exception e) {
                e.printStackTrace();return null;
            }

//        int rd = Math.random()>0.5?1:0;
//        if (rd==0){
//            try {
//                return (UserService) Naming.lookup("rmi://47.98.50.21:1098/userServer");
//            } catch (Exception e) {
//                e.printStackTrace();
//                try {
//                    return (UserService) Naming.lookup("rmi://119.29.17.188:1098/userServer");
//                } catch (NotBoundException e1) {
//                    e1.printStackTrace();return null;
//                } catch (MalformedURLException e1) {
//                    e1.printStackTrace();return null;
//                } catch (RemoteException e1) {
//                    e1.printStackTrace();return null;
//                }
//            }
//        }else {
//            try {
//                return (UserService) Naming.lookup("rmi://119.29.17.188:1098/userServer");
//            } catch (Exception e) {
//                e.printStackTrace();
//                try {
//                    return (UserService) Naming.lookup("rmi://47.98.50.21:1098/userServer");
//                } catch (NotBoundException e1) {
//                    e1.printStackTrace();return null;
//                } catch (MalformedURLException e1) {
//                    e1.printStackTrace();return null;
//                } catch (RemoteException e1) {
//                    e1.printStackTrace();return null;
//                }
//            }
//
//        }
    }

    public StudentService getStudentService(){
//        return (StudentService) act.getBean("studentServer");

//        try {
//            return (StudentService) Naming.lookup("rmi://119.29.17.188:1098/studentServer");
//
////            return (StudentService) Naming.lookup("rmi://47.98.50.21:1098/studentServer");
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
        try {
//            return (StudentService) Naming.lookup("rmi://47.98.50.21:1098/studentServer");
//            return (StudentService) Naming.lookup("rmi://119.29.17.188:1098/studentServer");
            return (StudentService) Naming.lookup("rmi://127.0.0.1:1098/studentServer");
        } catch (Exception e) {
            e.printStackTrace();return null;
        }
//
//        int rd = Math.random()>0.5?1:0;
//
//        if (rd==0){
//            try {
//                return (StudentService) Naming.lookup("rmi://47.98.50.21:1098/studentServer");
//            } catch (Exception e) {
//                e.printStackTrace();
//                try {
//                    return (StudentService) Naming.lookup("rmi://119.29.17.188:1098/studentServer");
//                } catch (NotBoundException e1) {
//                    e1.printStackTrace();return null;
//                } catch (MalformedURLException e1) {
//                    e1.printStackTrace();return null;
//                } catch (RemoteException e1) {
//                    e1.printStackTrace();return null;
//                }
//            }
//        }else {
//            try {
//                return (StudentService) Naming.lookup("rmi://119.29.17.188:1098/studentServer");
//            } catch (Exception e) {
//                e.printStackTrace();
//                try {
//                    return (StudentService) Naming.lookup("rmi://47.98.50.21:1098/studentServer");
//                } catch (NotBoundException e1) {
//                    e1.printStackTrace();return null;
//                } catch (MalformedURLException e1) {
//                    e1.printStackTrace();return null;
//                } catch (RemoteException e1) {
//                    e1.printStackTrace();return null;
//                }
//            }
//
//        }
    }

    public ProfessionService getProfessionService(){

        try {
//            return (ProfessionService) Naming.lookup("rmi://47.98.50.21:1098/professionServer");
//            return (ProfessionService) Naming.lookup("rmi://119.29.17.188:1099/professionServer");
            return (ProfessionService) Naming.lookup("rmi://127.0.0.1:1098/professionServer");
        } catch (Exception e) {
            e.printStackTrace();return null;

        }

//        int rd = Math.random()>0.5?1:0;
//            if (rd==0){
//                try {
//                    return (ProfessionService) Naming.lookup("rmi://47.98.50.21:1098/professionServer");
//                } catch (Exception e) {
//                    e.printStackTrace();
//                    try {
//                        return (ProfessionService) Naming.lookup("rmi://119.29.17.188:1098/professionServer");
//                    } catch (NotBoundException e1) {
//                        e1.printStackTrace();return null;
//                    } catch (MalformedURLException e1) {
//                        e1.printStackTrace();return null;
//                    } catch (RemoteException e1) {
//                        e1.printStackTrace();return null;
//                    }
//                }
//            }else {
//                try {
//                    return (ProfessionService) Naming.lookup("rmi://119.29.17.188:1098/professionServer");
//                } catch (Exception e) {
//                    e.printStackTrace();
//                    try {
//                        return (ProfessionService) Naming.lookup("rmi://47.98.50.21:1098/professionServer");
//                    } catch (NotBoundException e1) {
//                        e1.printStackTrace();return null;
//                    } catch (MalformedURLException e1) {
//                        e1.printStackTrace();return null;
//                    } catch (RemoteException e1) {
//                        e1.printStackTrace();return null;
//                    }
//                }
//
//            }
//
        }


}
