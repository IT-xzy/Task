package com.util;//package com.util;
///*
// * @ClassName:ServerB
// * @Description:TODO
// * @Author qiao
// * @Date 2018/9/13 9:42
// **/
//
//import com.service.CompanyService;
//import com.service.ProfService;
//import com.service.TelCodeService;
//import com.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.stereotype.Controller;
//
//public class ServerB {
//
//    @Autowired
//    @Qualifier("userServiceB")
//    UserService userService;
//
//    @Autowired
//    @Qualifier("profServiceB")
//    ProfService profService;
//
//    @Autowired
//    @Qualifier("companyServiceB")
//    CompanyService companyService;
//
//    @Autowired
//    @Qualifier("telCodeServiceB")
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
//}
