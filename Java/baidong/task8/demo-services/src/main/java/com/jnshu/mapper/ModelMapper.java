package com.jnshu.mapper;

import com.jnshu.model.Model;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModelMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Model record);

    int insertSelective(Model record);

    Model selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Model record);

    int updateByPrimaryKey(Model record);

    List<String> selectAll();
}