package com.ssm_yl.service;

import com.github.pagehelper.PageInfo;
import com.ssm_yl.pojo.Category;

import java.util.List;

public interface CategoryService {
    List<Category> list();
    public Category select(int id);
    public void insertCategory(Category category);
    public void delete(int id);
    public int update(Category category);
    PageInfo page(Integer pageNum);
}
