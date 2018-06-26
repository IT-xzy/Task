package com.task.rmi.server;

import com.task.service.ProfessionService;
import com.task.service.StudentService;
import com.task.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ServerA {
    @Autowired
    @Qualifier("rmiStudentA")
    private StudentService studentService;
    @Autowired
    @Qualifier("rmiUserA")
    private UserService userService;
    @Autowired
    @Qualifier("rmiProfessionA")
    private ProfessionService professionService;

    public StudentService getStudentService() {
        return studentService;
    }

    public UserService getUserService() {
        return userService;
    }

    public ProfessionService getProfessionService() {
        return professionService;
    }
}
