package task6_redis.redis_cached;

import task6_redis.pojo.PositionStu;
import java.util.List;

public interface PositionStuRedis {
    /**
     * 跟dao的方法一样，具体逻辑在业务层实现
     * @return
     */
    List<PositionStu> queryPositionStuR();
    Integer savePositionStuR(PositionStu positionStu);
    PositionStu queryPosiM(Integer id);


}
