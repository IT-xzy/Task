package com.spring_mybatis.Category;

import java.util.List;
public interface CategorySet {
    public int add(Category category);
    public boolean delete(int id);
    public Category get(int id);
    public int update(Category category);
    public List<Category> list();
   // public int count();
}
