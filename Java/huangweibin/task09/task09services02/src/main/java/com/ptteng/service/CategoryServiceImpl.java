package com.ptteng.service;

import com.ptteng.mapper.*;
import com.ptteng.pojo.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;


@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> list() {
        return categoryMapper.list ( );
    }


    @Override
    public List <Category> list(Page page) {
        System.out.println(page.toString());
        // TODO Auto-generated method stub
        return categoryMapper.list ( page );
    }

    @Override
    public List<Category> list1(String start, String count) {
        System.out.println("11");
        System.out.println(start + count);
        System.out.println(categoryMapper.list1(start, count).toString());
        return categoryMapper.list1(start ,count );
    }


    @Override
    public int total() {
        return categoryMapper.total ( );
    }


    @Override
    public void add(Category c) {
        categoryMapper.add ( c );
    }


    @Override
    public void update(Category c) {
        categoryMapper.update ( c );
    }


    @Override
    public void delete(Category c) {
        categoryMapper.delete ( c.getId ( ) );
    }


    @Override
    public Category get(int id) {
        // TODO Auto-generated method stub
        return categoryMapper.get ( id );
    }


}
