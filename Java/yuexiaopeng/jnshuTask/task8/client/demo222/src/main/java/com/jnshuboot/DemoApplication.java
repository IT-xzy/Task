package com.jnshuboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(DemoApplication.class, args);
        System.out.println("spring boot success");
//        UserInit userInit=new UserInit();
//        userInit.run();
//        System.out.println("运行完毕***********");
    }
}
