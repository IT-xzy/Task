package com.ev.rmi;

import com.ev.service.GoodOneService;
import com.ev.service.OccupationService;
import com.ev.service.StudentGeneralInfoService;
import com.ev.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ServerB {

    @Autowired
    @Qualifier("userRMIServerB")
    private UserService userService;
    @Autowired
    @Qualifier("studentGeneralInfoRMIServerB")
    private StudentGeneralInfoService studentGeneralInfoService;
    @Autowired
    @Qualifier("goodOneRMIServerB")
    private GoodOneService goodOneService;
    @Autowired
    @Qualifier("occupationRMIServerB")
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
