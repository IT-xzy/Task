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


    public List<Work> findPageWork(int page, int size, String keyword, Long classifyId) {
        int pageStart = (page - 1) * size;
        List<Work> Works = workDao.findPageWork(pageStart, size, keyword, classifyId);
        return Works;
    }

    public int findWorkAllPage(int size) {
        int total = workDao.countWork();
        int allPage;
        if (total % size == 0) {
            allPage = total / size;
        } else {
            allPage = total / size + 1;
        }
        return allPage;
    }

    public Work findById(long id){
        return workDao.findById(id);
    }


    public Boolean deleteById(long id){
        return workDao.deleteById(id);
    }


    public Boolean updateWork(Work work){
        return workDao.updateWork(work);
    }

    public long insertWork(Work work){
        return workDao.insertWork(work);
    }



}
