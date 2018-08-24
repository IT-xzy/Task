//package utils;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.stereotype.Component;
//import spring.service.IoccupationService;
//import spring.service.IstudentService;
//import spring.service.IuserService;
//
//import java.util.Random;
//@Component
//public class RimServer {
//
//    @Qualifier("studentServiceOne")
//    @Autowired
//    IstudentService studentService;
//
//    @Qualifier("userServiceOne")
//    @Autowired
//    IuserService userService;
//
//    @Qualifier("occupationServiceTwo")
//    @Autowired
//    IoccupationService occupationServiceB;
//
//    @Qualifier("studentServiceTwo")
//    @Autowired
//    IstudentService studentServiceB;
//
//    @Qualifier("userServiceTwo")
//    @Autowired
//    IuserService userServiceB;
//        }
//    }
//
//    public IstudentService getStudentService() {
//        if (random == 0) {
//            System.out.println("A");
//            return this.studentService;
//        } else {
//            System.out.println("B");
//            return this.studentServiceB;
//        }
//    }
//
//    public IuserService getUserService() {
//        if (random == 0) {
//            System.out.println("A");
//            return userService;
//        } else {
//            System.out.println("B");
//            return userServiceB;
//        }
//    }
//}
