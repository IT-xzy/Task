package com.ssm_yl.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssm_yl.pojo.Category;


import com.ssm_yl.dao.Mapper;
import com.ssm_yl.service.CategoryService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    Mapper mapper;


    public List<Category> list() {
        return mapper.list();
    }

    public Category select(int id) {
        //不使用缓存
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
    public PageInfo page(Integer pageNum){
        PageHelper.startPage(pageNum,10);
        List<Category> catagory =  mapper.list();
        PageInfo page = new PageInfo(catagory);

        return page;
    }

}
