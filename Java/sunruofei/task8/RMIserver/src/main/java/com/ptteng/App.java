package com.ptteng;


import com.ptteng.mapper.StudentMapper;
import com.ptteng.model.Student;
import com.ptteng.service.StudentService;
import com.ptteng.service.serviceImp.StudentServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;


/**
 * Hello world!
 */
public class App {


    public static void main(String[] args) throws RemoteException, AlreadyBoundException, MalformedURLException {

        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        // 创建一个远程对象，同时也会创建stub对象、skeleton对象
        StudentService studentService = (StudentService) context.getBean("studentServiceImp");
        //启动注册服务. 创建并导出接受指定 port 请求的本地主机上的 Registry 实例。
        LocateRegistry.createRegistry(3003);
        System.out.println(studentService + "#####");
        //注册对象，把对象与服务名绑定
        Naming.bind("//127.0.0.1:3003/student", studentService);
        System.out.println("服务正在运行");

    }

}
