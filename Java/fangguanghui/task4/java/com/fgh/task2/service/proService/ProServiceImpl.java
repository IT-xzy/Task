package com.fgh.task2.service.proService;

import com.fgh.task2.dao.profession.ProDao;
import com.fgh.task2.model.Pro;
import com.fgh.task2.service.proService.ProService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProServiceImpl implements ProService {
    @Autowired
    ProDao proDao;

    public List<Pro> getListPro()throws Exception{
        return proDao.getListPro();
    }
}
