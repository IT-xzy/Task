package com.alibaba.dao;

import com.alibaba.model.Count;
import org.springframework.stereotype.Repository;

@Repository
public interface CountMapper {
    int deleteById(Integer id);
    int insert (Count record);
    int insertSelective(Count record);
    Count selectById(Integer id);
    int updateByIdSelective(Count record);
    int updateById(Count record);
    Count selectByName(String name) throws Exception;
    int countByName(String user) throws Exception;


}
