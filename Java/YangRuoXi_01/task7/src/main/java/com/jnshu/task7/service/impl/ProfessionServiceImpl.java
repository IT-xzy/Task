package com.jnshu.task7.service.impl;

import com.jnshu.task7.beans.Profession;
import com.jnshu.task7.mapper.ProfessionMapper;
import com.jnshu.task7.service.ProfessionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessionServiceImpl implements ProfessionService {
    Logger logger = LoggerFactory.getLogger(ProfessionServiceImpl.class);
    @Autowired
    private ProfessionMapper professionMapper;

    @Override
    public List<Profession> showProfession() {

        return professionMapper.selectAllProfession();
    }

    @Override
    public List<Profession> selectProfessionByName() {


        return professionMapper.selectProfessionByName();
    }
}
