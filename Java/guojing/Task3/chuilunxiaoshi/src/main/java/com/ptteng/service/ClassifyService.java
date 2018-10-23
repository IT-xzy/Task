package com.ptteng.service;


import com.ptteng.dao.ClassifyDao;
import com.ptteng.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassifyService {
    @Autowired
    private ClassifyDao classifyDao;


    public List<Classify> findPageClassify(Integer page, Integer size, String keyword, Long collectionId) {
        int pageStart = (page - 1) * size;
        List<Classify> classifyList = classifyDao.findPageClassify(pageStart, size, keyword, collectionId);
        return classifyList;
    }

    public long countClassify() {
        return classifyDao.countClassify();
    }


    public Classify findById(long id){
        return classifyDao.findById(id);
    }

    public Boolean deleteById(long id){
        return classifyDao.deleteById(id);
    }

    public Boolean updateClassify(Classify classify){
        classify.setUpdateAt(System.currentTimeMillis());
        classify.setUpdateBy(33L);
        return classifyDao.updateClassify(classify);
    }

    public long insertClassify(Classify classify){
        classify.setCreateAt(System.currentTimeMillis());
        classify.setUpdateAt(System.currentTimeMillis());
        classify.setCreateBy(11L);
        classify.setUpdateBy(22L);
        return classifyDao.insertClassify(classify);
    }


}
