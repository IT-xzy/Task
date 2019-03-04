package com.jnshu.task6.service.impl;

import com.jnshu.task6.beans.Profession;
import com.jnshu.task6.mapper.ProfessionMapper;
import com.jnshu.task6.service.ProfessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessionServiceImpl implements ProfessionService {

    @Autowired
    private ProfessionMapper professionMapper;

    @Override
    public List<Profession> showProfession() {
        List<Profession> professionList = professionMapper.selectAllProfession();
        return professionList;
    }

    @Override
    public List<Profession> selectProfessionByName() {
        List<Profession> professionList = professionMapper.selectProfessionByName();
        return professionList;
    }
}
