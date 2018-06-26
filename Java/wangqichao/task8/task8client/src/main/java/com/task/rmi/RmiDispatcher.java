package com.task.rmi;

import com.task.cache.RedisCacheManager;
import com.task.exception.MyException;
import com.task.rmi.server.ServerA;
import com.task.rmi.server.ServerB;
import com.task.service.ProfessionService;
import com.task.service.StudentService;
import com.task.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RmiDispatcher {
    @Autowired
    ServerA serverA;
    @Autowired
    ServerB serverB;
    @Autowired
    RedisCacheManager redisCacheManager;
    private static int maxNumber = 10;

    public int getRandomNum() {
        int random = (int) (Math.random() * 2 / 1);
        if (random == 1) {
            return 1;
        } else {
            return 0;
        }
    }

    public StudentService getStudentService() throws Exception {

//        for (int i = 0; i < maxNumber; i++) {
//            int random = getRandomNum();
//            if (random == 0 && redisCacheManager.get("serverA") != null) {
//                return serverA.getStudentService();
//            }
//            if (random == 1 && redisCacheManager.get("serverB") != null) {
//                return serverB.getStudentService();
//            }
//        }
//        throw new MyException("所有服务器都挂了");
        int random=getRandomNum();
        if(random==0){
            return  serverA.getStudentService();
        }else {
            return  serverB.getStudentService();
        }
    }

    public UserService getUserService() throws Exception {

//        for (int i = 0; i < maxNumber; i++) {
//            int random = getRandomNum();
//            if (random == 0 && redisCacheManager.get("serverA") != null) {
//                return serverA.getUserService();
//            }
//            if (random == 1 && redisCacheManager.get("serverB") != null) {
//                return serverB.getUserService();
//            }
//        }
//        throw new MyException("所有服务器都挂了");
        int random=getRandomNum();
        if(random==0){
            return  serverA.getUserService();
        }else {
            return  serverB.getUserService();
        }
    }

    public ProfessionService getProfessionService() throws Exception {

//        for (int i = 0; i < maxNumber; i++) {
//            int random = getRandomNum();
//            if (random == 0 && redisCacheManager.get("serverA") != null) {
//                return serverA.getProfessionService();
//            }
//            if (random == 1 && redisCacheManager.get("serverB") != null) {
//                return serverB.getProfessionService();
//            }
//        }
//        throw new MyException("所有服务器都挂了");
        int random=getRandomNum();
        if(random==0){
            return  serverA.getProfessionService();
        }else {
            return  serverB.getProfessionService();
        }
    }
}

