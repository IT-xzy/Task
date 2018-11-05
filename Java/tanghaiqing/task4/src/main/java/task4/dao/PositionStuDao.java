package task4.dao;

import task4.pojo.PositionStu;

import java.util.List;

public interface PositionStuDao {
    List<PositionStu> goodShow();
    Integer savePosition(PositionStu positionStu);
}
