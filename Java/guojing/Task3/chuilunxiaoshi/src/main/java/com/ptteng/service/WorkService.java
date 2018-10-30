package com.ptteng.service;


import com.ptteng.dao.WorkDao;
import com.ptteng.entity.Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkService {
@Autowired
private WorkDao workDao;


    public List<Work> findPageWork(Integer page, Integer size, String keyword, Long classifyId) {
        int pageStart = (page - 1) * size;
        List<Work> Works = workDao.findPageWork(pageStart, size, keyword, classifyId);
        return Works;
    }

    public long countWork() {

        return workDao.countWork();
    }

    public Work findById(long id){
        return workDao.findById(id);
    }


    public Boolean deleteById(long id){
        return workDao.deleteById(id);
    }


    public Boolean updateWork(Work work){
        work.setUpdateAt(System.currentTimeMillis());
        work.setUpdateBy(33L);
        return workDao.updateWork(work);
    }

    public long insertWork(Work work){
        work.setCreateAt(System.currentTimeMillis());
        work.setUpdateAt(System.currentTimeMillis());
        work.setCreateBy(11L);
        work.setUpdateBy(22L);
        return workDao.insertWork(work);
    }



}
