package com.ev.service;

import com.ev.entity.StudentGeneralInfo;
import org.oasisopen.sca.annotation.Remotable;

@Remotable
public interface StudentGeneralInfoService {

    StudentGeneralInfo selectMainInfo() throws Exception;

}
