package com.ptteng.dao;

import com.ptteng.model.Direction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DirectionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Direction record);

    int insertSelective(Direction record);

    Direction selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Direction record);

    int updateByPrimaryKey(Direction record);
    List<Direction> selectAll();
}