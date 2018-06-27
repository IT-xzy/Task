package com.jnshu.service;

import com.jnshu.model.StudentCustom;
import org.oasisopen.sca.annotation.Remotable;

@Remotable
public interface ServiceMail {
    Boolean sendMailDefault(String httpUrl, StudentCustom studentCustom);
    Boolean sendMailAddSubject(String httpUrl, StudentCustom studentCustom, String toSubject);
    Boolean sendMailAddSubjectName(String httpUrl, StudentCustom studentCustom, String toSubject, String fromName);
}
