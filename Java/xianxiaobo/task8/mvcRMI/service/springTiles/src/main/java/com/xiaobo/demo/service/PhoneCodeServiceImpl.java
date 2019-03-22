package com.xiaobo.demo.service;

import com.xiaobo.demo.dao.PhoneCodeMapper;
import com.xiaobo.demo.pojo.PhoneCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("PhoneCodeServiceImpl")
public class PhoneCodeServiceImpl implements PhoneCodeService{
    @Autowired
    PhoneCodeMapper phoneCodeMapper;
    @Override
    public Integer insert(PhoneCode phoneCode){
        return phoneCodeMapper.insert(phoneCode);
    }
    @Override
    public PhoneCode selectByPhone(String phone){
        return phoneCodeMapper.selectByPhone(phone);
    }
    @Override
    public Boolean updateByPrimaryKeySelective(PhoneCode phoneCode){
        return phoneCodeMapper.updateByPrimaryKeySelective(phoneCode)==1;
    }
}
