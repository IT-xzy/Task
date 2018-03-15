package cn.summerwaves.dao;

import cn.summerwaves.model.Position;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PositionDao {
    List<Position> selectPositionByType(int type);
}
