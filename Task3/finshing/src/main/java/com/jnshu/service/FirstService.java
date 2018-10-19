package com.jnshu.service;

import com.jnshu.entity.First;
import com.jnshu.mapper.FirstDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FirstService {
    @Autowired
    FirstDao firstDao;
    public List select(First first){ return  firstDao.select(first);}
}
