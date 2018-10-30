package com.jnshu.service.impl;

import com.jnshu.MyBatis.ProfessionDao;
import com.jnshu.model.Profession;
import com.jnshu.service.ProfessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProfessionImpl implements ProfessionService {
    @Autowired
    ProfessionDao professionDao;


    @Override
    public List<Profession> all() {
        return professionDao.all();
    }

    @Override
    public List<Profession> after() {
        return professionDao.after();
    }

    @Override
    public List<Profession> ops() {
        return professionDao.ops();
    }
}
