package com.ptteng.service.impl;

import com.ptteng.dao.MailMapper;
import com.ptteng.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName MailServiceImp
 * @Description TODO
 * @Author 孙若飞
 * @Date 2019/3/11  19:31
 * @Version 1.0
 **/

@Service
public class MailServiceImp implements MailService {
    @Autowired
    MailMapper  mailMapper;
    @Override
    public int insertCodeMail(String code, String mailAddress, long create) {
        return mailMapper.insertCodeMail(code,mailAddress,create);
    }
}
