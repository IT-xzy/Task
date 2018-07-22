package service;

import mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.Category;
import util.Page;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryMapper categoryMapper;

    public List <Category> list() {
        return categoryMapper.list ( );
    }


    @Override
    public List <Category> list(Page page) {
        // TODO Auto-generated method stub
        return categoryMapper.list ( page );
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
