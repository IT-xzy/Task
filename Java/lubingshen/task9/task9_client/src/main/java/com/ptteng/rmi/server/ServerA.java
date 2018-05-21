package com.ptteng.rmi.server;

import com.ptteng.service.HomeService;
import com.ptteng.service.LoginService;
import com.ptteng.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ServerA {
    @Autowired
    @Qualifier("homeRMIServerA")
    private HomeService homeService;
    @Autowired
    @Qualifier("loginRMIServerA")
    private LoginService loginService;
    @Autowired
    @Qualifier("studentRMIServerA")
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
