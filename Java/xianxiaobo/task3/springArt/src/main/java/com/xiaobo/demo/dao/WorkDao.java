package com.xiaobo.demo.dao;

import com.xiaobo.demo.pojo.Work;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface WorkDao {
    public List<Work> getList(@Param("work")Work work, @Param("pageData") Map<String,Object> pageData);
    public Boolean add(Work work);
    public Boolean delete(Work work);
    public Boolean update(Work work);
    public List<Work> getWorkSearchList(@Param("searchText")String searchText,
                                        @Param("categoryIdList") ArrayList categoryIdList,
                                        @Param("pageData") Map<String,Object> pageData);
}
