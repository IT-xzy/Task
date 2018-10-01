package com.ev.service.implement;

import com.ev.DAO.StudentGeneralInfoDAO;
import com.ev.entity.StudentGeneralInfo;
import com.ev.service.StudentGeneralInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("studentGeneralInfoService")
public class StudentGeneralInfoServiceImpl implements StudentGeneralInfoService{

    @Autowired
    StudentGeneralInfoDAO studentGeneralInfoDAO;

    @Override
    public StudentGeneralInfo selectMainInfo() throws Exception {
        return studentGeneralInfoDAO.selectMainStatus();
    }
}
