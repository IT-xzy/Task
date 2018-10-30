package com.jns.service.impl;

import com.jns.mapper.JnsMapper;
import com.jns.entity.Jns;
import com.jns.service.JnsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JnsServiceImpl implements JnsService{
    //调用dao层的方法，来实现service层接口的方法。

    //@autowired相当于默认的getter()和setter();
    @Autowired
    private JnsMapper jnsMapper;
    public List<Jns> list() {
        return jnsMapper.list();
    }


}
