package com.alibaba.dao;


import com.alibaba.model.Count;
import com.alibaba.model.Excellent;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ExcellentMapper {

    int deleteById(Integer id);
    int insert(Excellent record);
    int insertSelective(Excellent record);
    Excellent selectById(Integer id);
    int updateByIdSelective(Excellent record);
    int updateById(Excellent record);
    List<Excellent> getAllExcellent();
}
