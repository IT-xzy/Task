package com.jnshu.service;

import com.jnshu.model.StudentCustom;

public interface ServiceMail {
    Boolean sendMail(String httpUrl, StudentCustom studentCustom);
    Boolean sendMail(String httpUrl, StudentCustom studentCustom, String toSubject);
    Boolean sendMail(String httpUrl, StudentCustom studentCustom, String toSubject, String fromName);
}
