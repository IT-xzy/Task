package com.wyz.task5.serviec.Impl;

import com.wyz.task5.domain.dao.ProfMapper;
import com.wyz.task5.domain.entity.Prof;
import com.wyz.task5.serviec.ProfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfServiceImpl implements ProfService {

    @Autowired
    private ProfMapper mapper;


    //根据名称查询职业信息
    public Prof getByProf(String profession){
        Prof prof = mapper.getByProf(profession);
        return  prof;
    }



}
