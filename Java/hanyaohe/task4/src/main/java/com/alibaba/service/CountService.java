package com.alibaba.service;

import com.alibaba.model.Count;



public interface CountService {

   int deleteById(Integer id);
    int insert(Count record);
    int insertSelective(Count record);
    Count selectById(Integer id);
   int updateByIdSelective(Count record);
   int updateById(Count record);

}


