package com.ptteng.service.ServiceImpl;


import com.ptteng.dao.ProfessionDao;
import com.ptteng.entity.Profession;
import com.ptteng.service.ProfessionService;
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
