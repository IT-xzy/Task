package com.xiaobo.demo.service;

import com.xiaobo.demo.pojo.PhoneCode;
import org.springframework.stereotype.Service;

@Service
public interface PhoneCodeService {
    public Integer insert(PhoneCode phoneCode);
    public PhoneCode selectByPhone(String phone);
    public Boolean updateByPrimaryKeySelective(PhoneCode phoneCode);
}
