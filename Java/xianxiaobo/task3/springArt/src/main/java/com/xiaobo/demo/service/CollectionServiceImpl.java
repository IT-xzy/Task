package com.xiaobo.demo.service;

import com.xiaobo.demo.dao.CollectionDao;
import com.xiaobo.demo.pojo.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CollectionServiceImpl implements CollectionService{
    @Autowired
    private CollectionDao collectionDao;
    @Override
    public List<Collection> getList(Collection collection,Map<String,Object> pageData){
        return collectionDao.getList(collection,pageData);
    }
    @Override
    public Boolean add(Collection collection){
        return collectionDao.add(collection);
    }
    @Override
    public Boolean update(Collection collection){
        return collectionDao.update(collection);
    }
    @Override
    public Boolean delete(Collection collection){
        return collectionDao.delete(collection);
    }
}
