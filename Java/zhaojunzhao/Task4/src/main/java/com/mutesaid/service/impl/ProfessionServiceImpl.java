package com.mutesaid.service.impl;

import com.mutesaid.mapper.ProfessionMapper;
import com.mutesaid.pojo.Profession;
import com.mutesaid.service.ProfessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessionServiceImpl implements ProfessionService {
    @Autowired
    private ProfessionMapper professionMapper;

    @Override
    public List<Profession> getProfesList(String direction) {
        return professionMapper.getProfessList(direction);
    }
}
