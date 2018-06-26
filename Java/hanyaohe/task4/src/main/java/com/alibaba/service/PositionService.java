package com.alibaba.service;

import com.alibaba.model.Position;

import java.util.List;

public interface PositionService {
    public int deleteById(Integer id);

    public int insert(Position record);

    public int insertSelective(Position record);

    public Position selectById(Integer id);

    public int updateByIdSelective(Position record);

    public int updateById(Position record);

    public List<Position> getAllPosition();
}
