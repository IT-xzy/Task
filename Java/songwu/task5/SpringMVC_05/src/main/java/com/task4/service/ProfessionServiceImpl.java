package com.task4.service;

import com.task4.mapper.ProfessionMapper;
import com.task4.pojo.Profession;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProfessionServiceImpl implements ProfessionService {
    @Autowired
    ProfessionMapper professionMapper;

    public ProfessionServiceImpl() {
        super();
    }




    @Override
    public List<Profession> selectProfession() {
     List<Profession> list= professionMapper.selectProfession();
        return list;
    }


}
