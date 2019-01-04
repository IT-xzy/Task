package task5.dao;

import task5.pojo.PositionStu;

import java.util.List;

public interface PositionStuDao {
    List<PositionStu> goodShow();
    Integer savePosition(PositionStu positionStu);
}
