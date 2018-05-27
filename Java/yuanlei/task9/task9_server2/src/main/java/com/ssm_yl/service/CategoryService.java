package com.ssm_yl.service;

import com.github.pagehelper.PageInfo;
import com.ssm_yl.pojo.Category;



public interface CategoryService {

    Category select(int id);
    void insertCategory(Category category);
    void delete(int id);
    int update(Category category);
    PageInfo page( Integer pageNum);

}
