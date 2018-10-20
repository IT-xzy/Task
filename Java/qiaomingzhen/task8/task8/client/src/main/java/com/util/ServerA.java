//package com.util;
///*
// * @ClassName:ServerA
// * @Description:TODO
// * @Author qiao
// * @Date 2018/9/13 9:41
// **/
//
//import com.service.CompanyService;
//import com.service.ProfService;
//import com.service.TelCodeService;
//import com.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//
//public class ServerA {
//
//    @Autowired
//    @Qualifier("userServiceA")
//    UserService userService;
//
//    @Autowired
//    @Qualifier("profServiceA")
//    ProfService profService;
//
//    @Autowired
//    @Qualifier("companyServiceA")
//    CompanyService companyService;
//
//    @Autowired
//    @Qualifier("telCodeServiceA")
//    TelCodeService telCodeService;
//
//    public UserService getUserService() {
//        return userService;
//    }
//
//    public ProfService getProfService() {
//        return profService;
//    }
//
//    public CompanyService getCompanyService() {
//        return companyService;
//    }
//
//    public TelCodeService getTelCodeService() {
//        return telCodeService;
//    }
//
//}
