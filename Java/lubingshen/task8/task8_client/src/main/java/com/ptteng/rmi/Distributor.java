package com.ptteng.rmi;

import com.ptteng.manager.Redis;
import com.ptteng.pojo.exception.ServerException;
import com.ptteng.pojo.exception.UnavailableException;
import com.ptteng.rmi.server.ServerA;
import com.ptteng.rmi.server.ServerB;
import com.ptteng.service.HomeService;
import com.ptteng.service.LoginService;
import com.ptteng.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Distributor {
    @Autowired
    ServerA serverA;
    @Autowired
    ServerB serverB;
    @Autowired
    Redis cacheManager;

    private static final int MAX_FAIL = 20;

    private int selectByRandom() {
        for (int i = 0; i < MAX_FAIL; i++) {
            int random = (int) (Math.random() * 2);
            if (random == 0 && cacheManager.haskey("serverA", "serverA")) {
                return 0;
            }
            if (random == 1 && cacheManager.haskey("serverB", "serverB")) {
                return 1;
            }
            //for循环的执行效率很高，为了防止过快的缓存操作导致异常，需要阻塞一下
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new UnavailableException("RMI分配器出现异常");
            }
        }
        throw new ServerException("Server端服务器可能全部崩溃");
    }

    public HomeService getHomeService() {
        int random = selectByRandom();
        if (random == 0) {
            return serverA.getHomeService();
        } else {
            return serverB.getHomeService();
        }
    }

    public StudentService getStudentService() {
        int random = selectByRandom();
        if (random == 0) {
            return serverA.getStudentService();
        } else {
            return serverB.getStudentService();
        }
    }

    public LoginService getLoginService() {
        int random = selectByRandom();
        if (random == 0) {
            return serverA.getLoginService();
        } else {
            return serverB.getLoginService();
        }
    }


}
