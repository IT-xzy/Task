package com.xiaobo.demo.service;

import com.xiaobo.demo.pojo.Category;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public interface CategoryService{
        public List<Category> getList(Category category, Map<String,Object> pageData);
        public Boolean add(Category category);
        public Boolean update(Category category);
        public Boolean delete(Category category);
        public List<Category> getListInCollectionIdList(Category category,ArrayList collectionIdList, Map<String,Object> pageData);
}
