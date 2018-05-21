package com.jnshu.service;
import com.jnshu.model.Position;

import java.util.List;

public interface PositionService {
    public int deleteByid(Integer id);

    public int insert(Position record);

    public int insertSelective(Position record);

    public Position selectByid(Integer id);

    public int updateByidSelective(Position record);

    public int updateByid(Position record);

    public List<Position> getAllPosition();
}
