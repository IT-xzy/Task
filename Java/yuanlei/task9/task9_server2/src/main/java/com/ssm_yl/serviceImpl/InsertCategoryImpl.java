package com.ssm_yl.serviceImpl;

import com.ssm_yl.dao.Mapper;
import com.ssm_yl.pojo.Category;
import com.ssm_yl.service.InsertCategoryInterface;
import org.springframework.beans.factory.annotation.Autowired;

public class InsertCategoryImpl implements InsertCategoryInterface{
    @Autowired
    Mapper mapper;

    public void insertCategory(Category category) {
        mapper.insertCategory(category);
    }
}
