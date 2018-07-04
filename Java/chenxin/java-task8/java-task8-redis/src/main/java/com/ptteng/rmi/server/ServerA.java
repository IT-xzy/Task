package com.ptteng.rmi.server;

import com.ptteng.service.OccupationService;
import com.ptteng.service.SignUserService;
import com.ptteng.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.remoting.rmi.RmiClientInterceptor;
import org.springframework.stereotype.Component;

import java.rmi.ConnectException;

@Component
public class ServerA {
    @Autowired
    @Qualifier("occupationRMIServerA")
    private OccupationService occupationService;
    @Autowired
    @Qualifier("signUserRMIServerA")
    private SignUserService signUserService;
    @Autowired
    @Qualifier("userRMIServerA")
    private UserService userService;

    public OccupationService getOccupationService() {
        return occupationService;
    }

    public SignUserService getSignUserService() {
        return signUserService;
    }

    public UserService getUserService() throws ConnectException {
        return userService;
    }
}
