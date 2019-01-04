package task6.dao;

import task6.pojo.PositionStu;
import java.util.List;

public interface PositionStuDao {
    List<PositionStu> goodShow();
    Integer savePosition(PositionStu positionStu);
    PositionStu queryPosition(Integer id);






}
