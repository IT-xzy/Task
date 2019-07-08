package com.jnshu.mapper;

import com.jnshu.model.Career;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CareerMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Career record);

    int insertSelective(Career record);

    Career selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Career record);

    int updateByPrimaryKey(Career record);

    List<Career> selectAll();
}