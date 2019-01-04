package com.xiaobo.demo.dao;

import com.xiaobo.demo.pojo.Category;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public interface CategoryDao {
    public List<Category> getList(@Param("category")Category category, @Param("pageData") Map<String,Object> pageData);
    public Boolean add(Category category);
    public Boolean delete(Category category);
    public Boolean update(Category category);
    public List<Category> getListInCollectionIdList(@Param("category")Category category,
                                                    @Param("collectionIdList")ArrayList collectionIdList,
                                                    @Param("pageData") Map<String,Object> pageData);                                                   ;
}
