package com.jnshu.dao;

import com.jnshu.model.Count;
import org.springframework.stereotype.Repository;

@Repository
public interface CountMapper {
    int deleteByid(Integer id);

    int insert(Count record);

    int insertSelective(Count record);

    Count selectByid(Integer id);

    int updateByidSelective(Count record);

    int updateByid(Count record);


}