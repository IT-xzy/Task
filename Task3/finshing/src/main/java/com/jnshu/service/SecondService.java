package com.jnshu.service;

import com.jnshu.entity.Second;
import com.jnshu.mapper.SecondDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SecondService{
        @Autowired
        SecondDao secondDao;
        public List select(Second second){ return  secondDao.select(second);}
}
