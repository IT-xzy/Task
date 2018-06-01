package com.ssm_yl.dao;


import com.ssm_yl.pojo.Category;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Mapper {
    public void insertCategory(Category category);
    List<Category> list();
    public void delete(int id);
    public  Category select(int id);
    public int update(Category category);
}
