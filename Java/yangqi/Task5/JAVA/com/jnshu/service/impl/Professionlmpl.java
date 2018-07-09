package com.jnshu.service.impl;

import com.jnshu.entity.Profession;
import com.jnshu.mapper.ProfessionDao;
import com.jnshu.service.ProfessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Professionlmpl implements ProfessionService {

    @Autowired
    private ProfessionDao professionDao;

    @Override
    public List<Profession> findAlls(){
        return professionDao.findAlls();
    }

    @Override
    public int findName() {
        return professionDao.findName();
    }

    @Override
    public Profession addlist(Profession profession){
        return professionDao.addlist(profession);
    }
}
