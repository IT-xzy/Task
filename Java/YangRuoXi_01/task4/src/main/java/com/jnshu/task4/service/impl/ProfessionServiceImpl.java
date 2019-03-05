package com.jnshu.task4.service.impl;

import com.jnshu.task4.beans.Profession;
import com.jnshu.task4.mapper.ProfessionMapper;
import com.jnshu.task4.service.ProfessionService;
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
}
