package com.fml.rmi;

import com.fml.service.EmailService;
import com.fml.service.StudentService;
import com.fml.service.VocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ServerA {
    @Autowired
    @Qualifier("studentRMIClientA")
    private StudentService studentService;

    @Autowired
    @Qualifier("emailRMIClientA")
    private EmailService emailService;

    @Autowired
    @Qualifier("vocationRMIClientA")
    private VocationService vocationService;

    public StudentService getStudentService() {
        return studentService;
    }

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    public EmailService getEmailService() {
        return emailService;
    }

    public void setEmailService(EmailService emailService) {
        this.emailService = emailService;
    }

    public VocationService getVocationService() {
        return vocationService;
    }

    public void setVocationService(VocationService vocationService) {
        this.vocationService = vocationService;
    }
}
