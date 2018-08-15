package com.stu.main;

import com.stu.service.impl.StudentServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.rmi.RemoteException;

public class Main {
    public static void main(String[] args) throws RemoteException {
//        System.setProperty("java.rmi.server.hostname","47.98.50.21");
        System.setProperty("java.rmi.server.hostname","119.29.17.188");
        new ClassPathXmlApplicationContext("applicationcontext.xml");
//        ApplicationContext ctx  = new FileSystemXmlApplicationContext(getClasspathe());
//        LocateRegistry.createRegistry(4567);
//        StudentServiceImpl studentService = (StudentServiceImpl) ctx.getBean("studentServiceImpl");

//        System.out.println(studentService.findByID(78));

        System.out.println("发布studentService服务成功！");
    }

    @Test
    public static String getClasspathe(){
        String path = new Object() {
            public String getPath() {
                return this.getClass().getClassLoader().getResource("applicationcontext.xml").getPath();
            }
        }.getPath().substring(1);
        System.out.println(path);
        System.out.println(Main.class.getClassLoader().getResource("applicationcontext.xml").getPath());
        return path;
    }




}

