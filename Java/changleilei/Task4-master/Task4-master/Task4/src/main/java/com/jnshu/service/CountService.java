package com.jnshu.service;
import com.jnshu.model.Count;

public interface CountService {
    int deleteByid(Integer id);

    int insert(Count record);

    int insertSelective(Count record);

    Count selectByid(Integer id);

    int updateByidSelective(Count record);

    int updateByid(Count record);
}
