package com.fml.service.impl;

import com.fml.mapper.EmailMapper;
import com.fml.pojo.Email;
import com.fml.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {
    @Autowired
    EmailMapper emailMapper;

    @Override
    public boolean add(Email email) {
        return emailMapper.add(email);
    }

    @Override
    public int getCount(long stuId, long sendTime) {
        return emailMapper.getCount(stuId, sendTime);
    }

    @Override
    public boolean delete() {
        return emailMapper.delete();
    }
}
