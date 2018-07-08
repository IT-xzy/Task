package com.jnshu.dao;
import com.jnshu.model.Position;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PositionMapper {
    int deleteById(Integer id);
    int insert(Position record);
    int insertSelective(Position record);
    Position selectById(Integer id);
    int updateByIdSelective(Position record);
    int updateById(Position record);
    List<Position> getAllPosition();
}