package com.service.ServiceImpl;


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
    public List<Profession> findProfession() {
        return professionDao.findProfession();
    }
}
