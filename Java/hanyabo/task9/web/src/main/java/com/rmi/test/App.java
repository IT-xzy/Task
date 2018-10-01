package com.rmi.test;


import com.task.service.HelloService;
import com.task.service.StudentService;
import com.task.service.UserService;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class App {

    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {

        HelloService h = (HelloService) Naming.lookup("//localhost:8085/HelloService");
        System.out.println("h=" + h.sayHello("solid......" ));

        StudentService studentService = (StudentService) Naming.lookup("//localhost:8085/StudentService");

        System.out.println("Student:" + studentService.findById(1));

        UserService userService = (UserService) Naming.lookup("//localhost:8085/UserService");

        System.out.println("User:" + userService.checkUsername("hanyabo"));

    }


}
