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

    @Override
    public List<Profession> findById(String direction) {
        return professionMapper.findById(direction);
    }

    @Override
    public int selectCount() {
        return professionMapper.selectCount();
    }

    @Override
    public int insertProfession(Profession profession) {
        return professionMapper.insertProfession(profession);
    }

    @Override
    public boolean deleteByDirection(String direction) {
        return professionMapper.deleteByDirection(direction);
    }
}
