package com.ssm_yl.mapper;

import com.ssm_yl.category.Category;
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
