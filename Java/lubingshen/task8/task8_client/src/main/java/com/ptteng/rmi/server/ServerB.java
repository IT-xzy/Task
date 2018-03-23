package com.ptteng.rmi.server;

import com.ptteng.service.HomeService;
import com.ptteng.service.LoginService;
import com.ptteng.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ServerB {
    @Autowired
    @Qualifier("homeRMIServerB")
    private HomeService homeService;
    @Autowired
    @Qualifier("loginRMIServerB")
    private LoginService loginService;
    @Autowired
    @Qualifier("studentRMIServerB")
    private StudentService studentService;

    public HomeService getHomeService() {
        return homeService;
    }

    public LoginService getLoginService() {
        return loginService;
    }

    public StudentService getStudentService() {
        return studentService;
    }

}
