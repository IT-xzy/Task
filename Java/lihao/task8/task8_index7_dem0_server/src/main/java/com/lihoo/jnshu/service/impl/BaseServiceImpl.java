package com.lihoo.jnshu.service.impl;

import com.lihoo.jnshu.pojo.User;
import com.lihoo.jnshu.service.IBaseService;
import org.springframework.stereotype.Service;

/**
 * #Title: BaseServiceImpl
 * #ProjectName task8_index7
 * #Description: TODO
 * #author lihoo
 * #date 2018/10/12-13:56
 */

@Service
public class BaseServiceImpl implements IBaseService {
    @Override
    public String getHelloWord(String name) {
        return "欢迎"+name+"的到来!!!";
    }

    @Override
    public String getUser(User user) {
        return "名字:"+user.getName()+"--->"+"年龄:"+user.getAge();
    }

}
