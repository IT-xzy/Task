package spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class RmiService {
    @Qualifier("occupationServiceOne")
    @Autowired
    IoccupationService occupationService;

    @Qualifier("studentServiceOne")
    @Autowired
    IstudentService studentService;

    @Qualifier("userServiceOne")
    @Autowired
    IuserService userService;

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


    public IoccupationService getOccupationService() {
//        Integer random = new Random().nextInt(2);
//        if (random == 0) {
//
//            try{
//                occupationService.query();
//            }catch (Exception e){
//                return occupationServiceB;
//            }
            return occupationService;
//        } else {
//            try{
//                occupationServiceB.query();
//            }catch (Exception e){
//                return occupationService;
//            }
//            return occupationServiceB;
//        }
    }

    public IstudentService getStudentService() {
//        Integer random = new Random().nextInt(2);
//        if (random == 0) {
//            try {
//                studentService.getAll();
//            }catch (Exception e){
//                return studentServiceB;
//            }
            return studentService;
//        } else {
//            try{
//                studentServiceB.getAll();
//            }catch (Exception e){
//                return studentService;
//            }
//            return studentServiceB;
//        }
    }

    public IuserService getUserService() {
//        Integer random = new Random().nextInt(2);
//        if (random == 0) {
//            try{
//                userService.gerServer();
//            }catch (Exception e){
//                return userServiceB;
//            }
            return userService;
//        } else {
//            try{
//                userServiceB.gerServer();
//            }catch (Exception e){
//                return userService;
//            }
//            return userServiceB;
//        }
    }
}
