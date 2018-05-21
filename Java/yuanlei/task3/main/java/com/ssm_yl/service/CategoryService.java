package com.ssm_yl.service;

import com.ssm_yl.category.Category;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CategoryService {
    List<Category> list();
    public Category select(int id);
    public void insertCategory(Category category);
    public void delete(int id);
    public int update(Category category);
}
