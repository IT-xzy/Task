package com.xiaobo.demo.dao;

import com.xiaobo.demo.pojo.About;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface AboutDao {
    public List<About> getList(@Param("about")About about, @Param("pageData") Map<String,Object> pageData);
    public Boolean add(About about);
    public Boolean delete(About about);
    public Boolean update(About about);
}
