package com.jnshu.service.impl;

import com.jnshu.mapper.WorksDao;
import com.jnshu.model.Workss;
import com.jnshu.service.WorksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class WorksServiceImpl implements WorksService {

    @Resource
    private WorksDao worksDao;

    @Override
    public long addWorkss(Workss workss) {
        return worksDao.addWorkss(workss);
    }

    @Override
    public boolean deleteWorkss(long id) {
        return worksDao.deleteWorkss(id);
    }

    @Override
    public boolean updateWorkss(Workss workss) {
        return worksDao.updateWorkss(workss);
    }

    @Override
    public Workss findByWorkss(long id) {
        return worksDao.findByWorkss(id);
    }

    @Override
    public List<Workss> findAllWorkss() {

//        return new ArrayList<>(12);
//
        return worksDao.findAllWorkss();
    }


}
