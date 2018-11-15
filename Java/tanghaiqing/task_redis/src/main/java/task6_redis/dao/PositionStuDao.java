package task6_redis.dao;

import task6_redis.pojo.PositionStu;

import java.util.List;

public interface PositionStuDao {
    List<PositionStu> goodShow();
    Integer savePosition(PositionStu positionStu);
    PositionStu queryPos(Integer id);
}
