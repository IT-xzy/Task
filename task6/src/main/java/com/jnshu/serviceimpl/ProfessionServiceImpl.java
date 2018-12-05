package com.jnshu.serviceimpl;

import com.jnshu.entity.Profession;
import com.jnshu.mapper.ProfessionMapper;
import com.jnshu.service.ProfessionService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProfessionServiceImpl implements ProfessionService {
    Logger logger = LogManager.getLogger(ProfessionServiceImpl.class.getName());
@Autowired
    ProfessionMapper professionMapper;
    @Override
    public List<Profession> getOneByPrimaryKey(long id) {
        logger.info("getOneByPrimaryKey======\n"+"id=====" + id);
        List<Profession> professionList = new ArrayList<Profession>();
        Profession profession;
        profession = professionMapper.selectByPrimaryKey(id);
        professionList.add(profession);
        return professionList;
    }
}
