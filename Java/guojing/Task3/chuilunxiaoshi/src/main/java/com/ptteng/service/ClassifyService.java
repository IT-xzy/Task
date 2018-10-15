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


    public List<Classify> findPageClassify(int page, int size, String keyword, Long collectionId) {
        int pageStart = (page - 1) * size;
        List<Classify> classfyList = classifyDao.findPageClassify(pageStart, size, keyword, collectionId);
        return classfyList;
    }

    public int findClassifyAllPage(int size) {
        int total = classifyDao.countClassify();
        int allPage;
        if (total % size == 0) {
            allPage = total / size;
        } else {
            allPage = total / size + 1;
        }
        return allPage;
    }


    public Classify findById(long id){
        return classifyDao.findById(id);
    }

    public Boolean deleteById(long id){
        return classifyDao.deleteById(id);
    }

    public Boolean updateClassify(Classify classify){
        return classifyDao.updateClassify(classify);
    }

    public long insertClassify(Classify classify){
        return classifyDao.insertClassify(classify);
    }


}
