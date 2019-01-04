package com.xiaobo.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class RMIService {
    @Autowired
    @Qualifier("commonService1")
    private RmiProxyFactoryBean commonService1;
    @Autowired
    @Qualifier("EmailCodeService1")
    private RmiProxyFactoryBean emailCodeService1;
    @Autowired
    @Qualifier("ExcellentStudentService1")
    private RmiProxyFactoryBean excellentStudentService1;
    @Autowired
    @Qualifier("PhoneCodeService1")
    private RmiProxyFactoryBean phoneCodeService1;
    @Autowired
    @Qualifier("ProfessionService1")
    private RmiProxyFactoryBean professionService1;
    @Autowired
    @Qualifier("UserService1")
    private RmiProxyFactoryBean userService1;


    @Autowired
    @Qualifier("commonService2")
    private RmiProxyFactoryBean commonService2;
    @Autowired
    @Qualifier("EmailCodeService2")
    private RmiProxyFactoryBean emailCodeService2;
    @Autowired
    @Qualifier("ExcellentStudentService2")
    private RmiProxyFactoryBean excellentStudentService2;
    @Autowired
    @Qualifier("PhoneCodeService2")
    private RmiProxyFactoryBean phoneCodeService2;
    @Autowired
    @Qualifier("ProfessionService2")
    private RmiProxyFactoryBean professionService2;
    @Autowired
    @Qualifier("UserService2")
    private RmiProxyFactoryBean userService2;



    public CommonService getCommonService(){
        Random random = new Random();
        if(random.nextBoolean()){
            try {
                return (CommonService)commonService1.getObject();
            }catch (Exception  e){
                return (CommonService)commonService2.getObject();
            }
        }else{
            try {
                return (CommonService)commonService2.getObject();
            }catch (Exception  e){
                return (CommonService)commonService1.getObject();

            }
        }
    }
    public EmailCodeService getEmailCodeService(){
        Random random = new Random();
        if(random.nextBoolean()){
            try {
                return (EmailCodeService)emailCodeService1.getObject();
            }catch (Exception  e){
                return (EmailCodeService)emailCodeService2.getObject();
            }
        }else{
            try {
                return (EmailCodeService)emailCodeService2.getObject();
            }catch (Exception  e){
                return (EmailCodeService)emailCodeService1.getObject();

            }
        }
    }
    public ExcellentStudentService getExcellentStudentService(){
        Random random = new Random();
        if(random.nextBoolean()){
            try {
                return (ExcellentStudentService)excellentStudentService1.getObject();
            }catch (Exception  e){
                return (ExcellentStudentService)excellentStudentService2.getObject();
            }
        }else{
            try {
                return (ExcellentStudentService)excellentStudentService2.getObject();
            }catch (Exception  e){
                return (ExcellentStudentService)excellentStudentService1.getObject();

            }
        }
    }
    public PhoneCodeService getPhoneCodeService(){
        Random random = new Random();
        if(random.nextBoolean()){
            try {
                return (PhoneCodeService)phoneCodeService1.getObject();
            }catch (Exception  e){
                return (PhoneCodeService)phoneCodeService2.getObject();
            }
        }else{
            try {
                return (PhoneCodeService)phoneCodeService2.getObject();
            }catch (Exception  e){
                return (PhoneCodeService)phoneCodeService1.getObject();

            }
        }
    }
    public ProfessionService getProfessionService(){
        Random random = new Random();
        if(random.nextBoolean()){
            try {
                return (ProfessionService)professionService1.getObject();
            }catch (Exception  e){
                return (ProfessionService)professionService2.getObject();
            }
        }else{
            try {
                return (ProfessionService)professionService2.getObject();
            }catch (Exception  e){
                return (ProfessionService)professionService1.getObject();

            }
        }
    }
    public UserService getUserService(){
        Random random = new Random();
        if(random.nextBoolean()){
            try {
                return (UserService)userService2.getObject();
            }catch (Exception  e){
                return (UserService)userService2.getObject();
            }
        }else{
            try {
                return (UserService)userService2.getObject();
            }catch (Exception  e){
                return (UserService)userService2.getObject();

            }
        }
    }
}
