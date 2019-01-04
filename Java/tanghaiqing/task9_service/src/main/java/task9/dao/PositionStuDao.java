package task9.dao;

import task9.pojo.PositionStu;

import java.util.List;

public interface PositionStuDao {
    List<PositionStu> goodShow();
    Integer savePosition(PositionStu positionStu);
}
