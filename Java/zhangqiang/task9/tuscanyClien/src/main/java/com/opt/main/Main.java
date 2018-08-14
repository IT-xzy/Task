package com.opt.main;

import com.opt.controller.RmiService;
import com.opt.service.StudentService;
import com.opt.service.impl.StudentServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Main {
    public static void main(String[] args){
        System.out.println("开始测试");
//        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationcontext.xml");
//        StudentService studentService = (StudentService) ctx.getBean("studentServiceImpl");
//        StudentService studentService = new RmiService().getStudentService();
//        StudentService studentService = (StudentService) Naming.lookup("rmi://127.0.0.1:1098/studentServer");
//        StudentService studentService = (StudentService) Naming.lookup("rmi://47.98.50.21:1098/studentServer");
//        StudentService studentService = new RmiService().getStudentService();
        StudentService studentService = new StudentServiceImpl();
        Registry registry = null;
//        try {
//            studentService = (StudentService) Naming.lookup("rmi://119.29.17.188:1098/studentServer");
//            System.out.println(studentService.findByID(89));
//        } catch (NotBoundException e) {
//            e.printStackTrace();
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        } catch (RemoteException e) {
//            e.printStackTrace();
//        }

        try {
//            registry= LocateRegistry.getRegistry("119.29.17.188",1098);
//            studentService = (StudentService) Naming.lookup("rmi://119.29.17.188:1098/studentServer");
            registry= LocateRegistry.getRegistry("119.29.17.188",1099);
//            registry= LocateRegistry.getRegistry("127.0.0.1",1098);
            studentService = (StudentService) registry.lookup("studentServer");
            System.out.println(studentService.findByID(89));


        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }

    }
}
