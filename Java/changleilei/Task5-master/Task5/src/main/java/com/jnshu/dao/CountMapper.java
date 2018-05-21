package com.jnshu.dao;
import com.jnshu.model.Count;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountMapper {
    int deleteById(Integer id);
    int insert(Count record);
    int insertSelective(Count record);
    Count selectById(Integer id);
    int updateByIdSelective(Count record);
    int updateById(Count record);
    List<Count> getAllCount();
    Count selectByName(String name) throws Exception;
    int countByName(String user) throws Exception;
}