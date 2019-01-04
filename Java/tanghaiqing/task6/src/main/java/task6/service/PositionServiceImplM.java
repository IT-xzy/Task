package task6.service;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import task6.cache.PositionstuMem;
import task6.pojo.PositionStu;
import task6.util.ApplicationException;
import javax.annotation.Resource;
import java.util.List;

@Service
public class PositionServiceImplM implements PositionService {
    private static Logger logger =Logger.getLogger(PositionServiceImplM.class);
    @Resource(name = "positionstuMemImpl")
    private PositionstuMem positionstuMem;
    @Override
    public List<PositionStu> goodShowService() {
        logger.info("goodShowService()");
        List<PositionStu> positionStus =positionstuMem.queryPositionStuM();
        logger.info(positionStus);
        if (positionStus.size()==0){
            logger.info("goodShowService() Exception");
            throw new ApplicationException("暂时没有优秀学员");
        }
        return positionStus;
    }
}
