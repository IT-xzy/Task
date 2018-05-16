package com.task.service.Impl;

import com.task.dao.ProfessionDao;
import com.task.models.Profession;
import com.task.service.ProfessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfessionServiceImpl implements ProfessionService{
    @Autowired
    private  ProfessionDao professionDao;
    @Override
    public int justAdd(Profession profession) throws Exception {
      professionDao.addPro(profession);
        return profession.getId();
    }

    @Override
    public Boolean justDelete(int id) throws Exception {
        return professionDao.deletePro(id);
    }

    @Override
    public Boolean justUpdate(Profession profession) throws Exception {
        return professionDao.updatePro(profession);
    }

    @Override
    public Profession justListByName(String name) throws Exception {
       Profession profession=professionDao.getProByName(name);
        return profession;
    }
}
