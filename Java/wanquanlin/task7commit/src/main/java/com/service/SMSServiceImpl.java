package com.service;

import com.aliyuncs.exceptions.ClientException;
import com.util.aliyunutil.SmsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: Jaime
 * @Author: Jaime
 * @Date: 2018/5/19 22:20
 * @Description: *
 */
@Service
public class SMSServiceImpl implements SMSservice {
    @Autowired
    private SmsUtils smsUtils;

    @Override
    public String smssend(String telephone,String vcode) {
        String code= null;
        try {
            code = smsUtils.sendSms(telephone,vcode);
            return code;
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return code;
    }
}
