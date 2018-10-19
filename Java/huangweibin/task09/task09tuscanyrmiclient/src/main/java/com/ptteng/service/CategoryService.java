package com.ptteng.service;


import com.ptteng.pojo.*;
import org.apache.ibatis.annotations.*;

import java.util.*;


public interface CategoryService {
    List<Category> list();

    int total();

    List<Category> list(Page page);

    void add(Category c);

    void update(Category c);

    void delete(Category c);

    Category get(int id);

    List<Category> list1(@Param("start") String star, @Param("count") String count);

}
