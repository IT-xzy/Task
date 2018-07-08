package com.jnshu.service.impl;

import com.jnshu.service.ServiceSMS;
import com.jnshu.tools.SmsApiRLian;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: SSM_WEB_SERVER
 * @description: 短信 SDK 容联API实现
 * @author: Mr.xweiba
 * @create: 2018-06-09 02:01
 **/
@Service
public class ServiceSMSRLianImpl implements ServiceSMS{
    @Autowired
    SmsApiRLian sendSMSSDK;

    @Override
    public Boolean sendSMS(String telePhone, String SessionId) {
        return sendSMSSDK.sendSMS(telePhone, SessionId);
    }
}
