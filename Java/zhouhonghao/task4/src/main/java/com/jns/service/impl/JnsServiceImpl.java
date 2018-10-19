package com.jns.service.impl;

import com.jns.mapper.JnsMapper;
import com.jns.pojo.Jns;
import com.jns.service.JnsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JnsServiceImpl implements JnsService{
    @Autowired
    private JnsMapper jnsMapper;
    public List<Jns> list() {
        return jnsMapper.list();
    }


}
