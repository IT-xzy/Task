package task6.cache;

import task6.pojo.PositionStu;

import java.util.List;

/**
 * PositionStu缓存接口设计
 */
public interface PositionstuMem {
    /**
     * 跟dao的方法一样，具体逻辑在业务层实现
     * @return
     */
    List<PositionStu> queryPositionStuM();
    Integer savePositionStuM(PositionStu positionStu);
}
