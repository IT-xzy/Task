package task6_redis.service;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import task6_redis.dao.PositionStuDao;
import task6_redis.pojo.PositionStu;
import task6_redis.util.ApplicationException;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PositionServiceImpl implements PositionService {
    private static Logger logger =Logger.getLogger(PositionServiceImpl.class);
    @Resource(name = "positionStuDao")
    private PositionStuDao positionStuDao;
    @Override
    public List<PositionStu> goodShowService() {
        logger.info("goodShowService()");
        List<PositionStu> positionStus =positionStuDao.goodShow();
        logger.info(positionStus);
        if (positionStus.size()==0){
            logger.info("goodShowService() Exception");
            throw new ApplicationException("暂时没有优秀学员");
        }
        return positionStus;
    }
}
