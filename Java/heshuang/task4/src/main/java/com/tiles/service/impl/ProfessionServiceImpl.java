package com.tiles.service.impl;

import com.tiles.mapper.ProfessionDao;
import com.tiles.pojo.Profession;
import com.tiles.service.ProfessionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProfessionServiceImpl implements ProfessionService{
    @Resource
    private ProfessionDao professionDao;

    @Override
    public List<Profession> getAllProfession() throws Exception {
        return professionDao.getAllProfession();
    }
}
