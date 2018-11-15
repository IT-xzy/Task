package task7.dao;

import task7.pojo.PositionStu;

import java.util.List;

public interface PositionStuDao {
    List<PositionStu> goodShow();
    Integer savePosition(PositionStu positionStu);
}
