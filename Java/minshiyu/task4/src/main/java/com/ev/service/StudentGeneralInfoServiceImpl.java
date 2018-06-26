package com.ev.service;

import com.ev.dao.StudentGeneralInfoDAO;
import com.ev.entity.StudentGeneralInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentGeneralInfoServiceImpl implements StudentGeneralInfoService {

    @Autowired
    StudentGeneralInfoDAO studentGeneralInfoDAO;

    @Override
    public StudentGeneralInfo selectMainInfo()throws Exception {
        return studentGeneralInfoDAO.selectMainStatus();
    }
}
