package com.token.service.impl;


import com.token.dao.ProfessionMapper;
import com.token.model.Profession;
import com.token.service.ProfessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessionServiceImpl implements ProfessionService {
    @Autowired
    private ProfessionMapper professionMapper;
    @Override
    public List<Profession> getAll() {
        return professionMapper.getAll();
    }

    @Override
    public int addProfession(Profession profession) {
        return professionMapper.addProfession(profession);
    }
}
