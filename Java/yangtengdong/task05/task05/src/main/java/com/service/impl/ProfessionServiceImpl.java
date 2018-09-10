package com.service.impl;

import com.dao.ProfessionDao;
import com.entity.Profession;
import com.service.ProfessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessionServiceImpl implements ProfessionService {
    @Autowired
    private ProfessionDao professionDao;

    @Override
    public Profession findById(Integer id) {
        return  professionDao.findById(id);
    }

    @Override
    public List<Profession> listAll() {
        return professionDao.listAll();
    }

    @Override
    public void insert(Profession profession) {
        professionDao.insert(profession);
    }

    @Override
    public List<Profession> findByStyle(String style) {
        return professionDao.findByStyle(style);
    }
}
