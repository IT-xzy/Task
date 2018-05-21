package cn.summerwaves.service;

import cn.summerwaves.model.Position;

import java.util.List;

public interface IPositionService {
    List<Position> selectPositionByType(int type);
}
