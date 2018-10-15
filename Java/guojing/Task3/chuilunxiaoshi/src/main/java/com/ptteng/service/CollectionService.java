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

    public List<Collection> findPageCollection(int page, int size, String keyword) {
        int pageStart = (page - 1) * size;
        List<Collection> collections = collectionDao.findPageCollection(pageStart, size, keyword);
        return collections;
    }

    public int findCollectionAllPage(int size) {
        int total = collectionDao.countCollection();
        int allPage;
        if (total % size == 0) {
            allPage = total / size;
        } else {
            allPage = total / size + 1;
        }
        return allPage;
    }


    public Collection findById(long id){
        return collectionDao.findById(id);
    }


    public Boolean deleteById(long id){
        return collectionDao.deleteById(id);
    }


    public Boolean updateCollection(Collection collection){
        return collectionDao.updateCollection(collection);
    }

    public long insertCollection(Collection collection){
        return collectionDao.insertCollection(collection);
    }


}
