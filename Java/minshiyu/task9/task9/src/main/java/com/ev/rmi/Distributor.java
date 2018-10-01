package com.ev.rmi;

import com.ev.service.GoodOneService;
import com.ev.service.OccupationService;
import com.ev.service.StudentGeneralInfoService;
import com.ev.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.UnavailableException;
import java.rmi.ServerException;

@Component
public class Distributor {
    @Autowired
    ServerA serverA;
    @Autowired
    ServerB serverB;

    private static final int MAX_FAIL = 20;

    private int selectByRandom() throws ServerException, UnavailableException {
        for (int i = 0; i < MAX_FAIL; i++) {
            int random = (int) (Math.random() * 2);
            if (random == 0) {
                return 0;
            }
            if (random == 1) {
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

    public UserService getUserService() throws ServerException, UnavailableException {
        int random = selectByRandom();
        if (random == 0) {
            return serverA.getUserService();
        } else {
            return serverB.getUserService();
        }
    }

    public StudentGeneralInfoService getStudentGeneralInfoService() throws ServerException, UnavailableException {
        int random = selectByRandom();
        if (random == 0) {
            return serverA.getStudentGeneralInfoService();
        } else {
            return serverB.getStudentGeneralInfoService();
        }
    }

    public OccupationService getOccupationService() throws ServerException, UnavailableException {
        int random = selectByRandom();
        if (random == 0) {
            return serverA.getOccupationService();
        } else {
            return serverB.getOccupationService();
        }
    }

    public GoodOneService getGoodOneService() throws ServerException, UnavailableException {
        int random = selectByRandom();
        if (random == 0) {
            return serverA.getGoodOneService();
        } else {
            return serverB.getGoodOneService();
        }
    }
}


