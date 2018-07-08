package com.alibaba.dao;

import com.alibaba.model.Position;

import java.util.List;

public interface PositionMapper {
    int deleteById(Integer id);
    int insert(Position record);
    int insertSelective(Position record);
    Position selectById(Integer id);
    int updateByIdSelective(Position record);
    int updateById(Position record);
    List<Position> getAllPosition();

}
