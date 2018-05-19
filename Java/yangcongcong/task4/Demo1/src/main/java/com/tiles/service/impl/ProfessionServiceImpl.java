package com.tiles.service.impl;

import com.tiles.dao.ProfessionMapper;
import com.tiles.model.Profession;
import com.tiles.service.ProfessionService;
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
