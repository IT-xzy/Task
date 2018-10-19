package com.client;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import service.PaperService;

import java.rmi.RemoteException;



public class TestRun {

    @Autowired
    private PaperService paperService;

    public static void main(String[] args) throws RemoteException {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/rmi-server.xml");
        context.getBean("paperRMIServer");
        System.out.println( "111111111111111111111111111");
        //System.out.println(r`miI.sayHi(" zwp"));
        //TestRun testRun = new TestRun();
        //testRun.a();
        //this.a();
    }

    //public static void a (){
    //    System.out.println(paperService.queryAllPaper().toString());
    //}


}
