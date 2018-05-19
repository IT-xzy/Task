package com.fml.rmi;

import com.fml.service.EmailService;
import com.fml.service.StudentService;
import com.fml.service.VocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DistributeServer {
    @Autowired
    ServerA serverA;
    @Autowired
    ServerB serverB;
    /*定义随机数*/
    private static int random;

    public StudentService getStudentService(){
        if (random == 1){
            return serverA.getStudentService();
        } else {
            return serverB.getStudentService();
        }
    }

    public EmailService getEmailService(){
        if (random == 1){
            return serverA.getEmailService();
        } else {
            return serverB.getEmailService();
        }
    }

    public VocationService getVocationService(){
        if (random == 1){
            return serverA.getVocationService();
        } else {
            return serverB.getVocationService();
        }
    }

    private int getRandom(){
        random = (int)(Math.random() * 2);
        return random;
    }
}
