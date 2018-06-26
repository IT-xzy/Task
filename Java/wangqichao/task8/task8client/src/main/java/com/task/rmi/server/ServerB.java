package com.task.rmi.server;

import com.task.service.ProfessionService;
import com.task.service.StudentService;
import com.task.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ServerB {
    @Autowired
    @Qualifier("rmiStudentB")
    private StudentService studentService;
    @Autowired
    @Qualifier("rmiUserB")
    private UserService userService;
    @Autowired
    @Qualifier("rmiProfessionB")
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
