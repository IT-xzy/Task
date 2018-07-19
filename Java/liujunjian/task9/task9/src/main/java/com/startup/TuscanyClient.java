package com.startup;

import com.service.TestService;

import java.rmi.Naming;

public class TuscanyClient {
    public static void main(String[] args) throws Exception{
        TestService testService = (TestService) Naming.lookup("rmi://127.0.0.1:8082/TestService");
        System.out.println(testService.average(23424,8768));
        System.out.println(testService.read());
    }
}
