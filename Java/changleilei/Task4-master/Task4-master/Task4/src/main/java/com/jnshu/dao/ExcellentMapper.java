package com.jnshu.dao;

import com.jnshu.model.Excellent;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExcellentMapper {
    int deleteByid(Integer id);

    int insert(Excellent record);

    int insertSelective(Excellent record);

    Excellent selectByid(Integer id);

    int updateByidSelective(Excellent record);

    int updateByid(Excellent record);

    List<Excellent> getAllExcellent();
}