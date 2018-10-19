package com.zyq.service.Impl;

import com.zyq.mapper.ProfessionMapper;
import com.zyq.pojo.Profession;
import com.zyq.service.ProfessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessionServiceImpl implements ProfessionService {

    @Autowired
    ProfessionMapper professionMapper;


    @Override
    public List<Profession> selectAll() {
        return professionMapper.selectAll();
    }
}
