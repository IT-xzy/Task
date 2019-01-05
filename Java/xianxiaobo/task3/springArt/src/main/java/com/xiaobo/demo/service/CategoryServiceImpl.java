package com.xiaobo.demo.service;

import com.xiaobo.demo.dao.CategoryDao;
import com.xiaobo.demo.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    private CategoryDao categoryDao;
    @Override
    public List<Category> getList(Category category, Map<String,Object> pageData){
        return categoryDao.getList(category,pageData);
    }
    @Override
    public Boolean add(Category category){
        return categoryDao.add(category);
    }
    @Override
    public Boolean update(Category category){
        return categoryDao.update(category);
    }
    @Override
    public Boolean delete(Category category){
        return categoryDao.delete(category);
    }
    @Override
    public List<Category> getListInCollectionIdList(Category category,ArrayList collectionIdList, Map<String,Object> pageData){
        return categoryDao.getListInCollectionIdList(category,collectionIdList,pageData);
    }
}
