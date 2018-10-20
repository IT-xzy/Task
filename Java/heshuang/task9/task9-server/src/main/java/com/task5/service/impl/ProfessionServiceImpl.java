package com.task5.service.impl;

import com.task5.mapper.ProfessionDao;
import com.task5.pojo.Profession;
import com.task5.service.ProfessionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("ProfessionServiceImpl")
public class ProfessionServiceImpl implements ProfessionService {
    @Resource
    private ProfessionDao professionDao;

    @Override
    public List<Profession> getAllProfession() throws Exception {
        return professionDao.getAllProfession();
    }
}
