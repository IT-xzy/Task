package com.ptteng.service;

import com.ptteng.pojo.*;

import java.util.*;


public interface CategoryService {
    List<Category> list();

    int total();

    List<Category> list(Page page);

    List<Category> list1(String start, String count);

    void add(Category c);

    void update(Category c);

    void delete(Category c);

    Category get(int id);

}
