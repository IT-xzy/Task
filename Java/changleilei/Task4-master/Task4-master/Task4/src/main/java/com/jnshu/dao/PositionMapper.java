package com.jnshu.dao;

import com.jnshu.model.Position;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PositionMapper {
    int deleteByid(Integer id);

    int insert(Position record);

    int insertSelective(Position record);

    Position selectByid(Integer id);

    int updateByidSelective(Position record);

    int updateByid(Position record);

    List<Position> getAllPosition();
}