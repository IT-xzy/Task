package com.xiaobo.demo.dao;

import com.xiaobo.demo.pojo.Collection;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface CollectionDao {
    public List<Collection> getList(@Param("collection")Collection collection, @Param("pageData")Map<String,Object> pageData);
    public Boolean add(Collection collection);
    public Boolean delete(Collection collection);
    public Boolean update(Collection collection);
}
