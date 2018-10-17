package com.ptteng.service;


import com.ptteng.dao.CollectionDao;
import com.ptteng.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectionService {
    @Autowired
    private CollectionDao collectionDao;

    public List<Collection> findPageCollection(Integer page, Integer size, String keyword) {
        int pageStart = (page - 1) * size;
        List<Collection> collections = collectionDao.findPageCollection(pageStart, size, keyword);
        return collections;
    }

    public long countCollection() {
        return collectionDao.countCollection();
    }


    public Collection findById(long id){
        return collectionDao.findById(id);
    }


    public Boolean deleteById(long id){

        return collectionDao.deleteById(id);
    }


    public Boolean updateCollection(Collection collection){

        System.out.println("测试测试==="+collection);
        collection.setUpdateAt(System.currentTimeMillis());
        collection.setUpdateBy(33L);
        System.out.println("测试测试==="+collection);
        return collectionDao.updateCollection(collection);
    }

    public long insertCollection(Collection collection){
        collection.setCreateAt(System.currentTimeMillis());
        collection.setUpdateAt(System.currentTimeMillis());
        collection.setCreateBy(11L);
        collection.setUpdateBy(22L);
        return collectionDao.insertCollection(collection);
    }


}
