package com.ev.rmi;

import com.ev.service.GoodOneService;
import com.ev.service.OccupationService;
import com.ev.service.StudentGeneralInfoService;
import com.ev.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ServerA {

    @Autowired
    @Qualifier("userRMIServerA")
    private UserService userService;
    @Autowired
    @Qualifier("studentGeneralInfoRMIServerA")
    private StudentGeneralInfoService studentGeneralInfoService;
    @Autowired
    @Qualifier("goodOneRMIServerA")
    private GoodOneService goodOneService;
    @Autowired
    @Qualifier("occupationRMIServerA")
    private OccupationService occupationService;

    public UserService getUserService() {
        return userService;
    }

    public StudentGeneralInfoService getStudentGeneralInfoService() {
        return studentGeneralInfoService;
    }

    public GoodOneService getGoodOneService() {
        return goodOneService;
    }

    public OccupationService getOccupationService() {
        return occupationService;
    }
}
