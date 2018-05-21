package com.ssm_yl.serviceImpl;

import com.ssm_yl.category.Category;


import com.ssm_yl.mapper.Mapper;
import com.ssm_yl.service.CategoryService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class ServiceImpl implements CategoryService {
    @Autowired
    Mapper mapper;
    public List<Category> list() {
        return mapper.list();
    }

    public Category select(int id) {
        return mapper.select(id);
    }

    public void insertCategory(Category category) {
         mapper.insertCategory(category);
    }

    public void delete(int id) {
         mapper.delete(id);
    }

    public int update(Category category) {
        System.out.println(category.toString());
        return mapper.update(category);
    }
}
