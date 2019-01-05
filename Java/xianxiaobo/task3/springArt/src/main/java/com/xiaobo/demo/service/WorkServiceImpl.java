package com.xiaobo.demo.service;

import com.xiaobo.demo.dao.WorkDao;
import com.xiaobo.demo.pojo.Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class WorkServiceImpl implements WorkService{
    @Autowired
    private WorkDao workDao;
    @Override
    public List<Work> getList(Work work, Map<String,Object> pageData){
        return workDao.getList(work,pageData);
    }
    @Override
    public Boolean add(Work work){
        return workDao.add(work);
    }
    @Override
    public Boolean update(Work work){
        return workDao.update(work);
    }
    @Override
    public Boolean delete(Work work){
        return workDao.delete(work);
    }
    @Override
    public List<Work> getWorkSearchList(String searchText, ArrayList categoryIdList, Map<String,Object> pageData){
        return workDao.getWorkSearchList(searchText,categoryIdList,pageData);
    }
}
