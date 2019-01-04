package task6_redis.service;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import task6_redis.pojo.PositionStu;
import task6_redis.redis_cached.PositionStuRedis;
import task6_redis.util.ApplicationException;

import javax.annotation.Resource;
import java.util.List;
@Service
public class PositionServiceImplR implements PositionService {
    private static Logger logger =Logger.getLogger(PositionServiceImplR.class);
    @Resource(name = "positionStuRedisImpl")
    private PositionStuRedis positionStuRedis;
    @Override
    public List<PositionStu> goodShowService() {
        logger.info("goodShowService()");
        List<PositionStu> positionStus =positionStuRedis.queryPositionStuR();
        logger.info(positionStus);
        if (positionStus.size()==0){
            logger.info("goodShowService() Exception");
            throw new ApplicationException("暂时没有优秀学员");
        }
        return positionStus;
    }
}
