package spring.service.impl;



import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.dao.OccupationDao;
import spring.model.Occupation;
import spring.service.IoccupationService;
import utils.Redis;
import java.util.List;
@Service
public class OccupationService implements IoccupationService {

    @Autowired
    private OccupationDao occupationDao;
    @Autowired
    private Redis redis;

    Logger logger = Logger.getLogger(OccupationService.class);

    @Override
    public List<Occupation> query() {
        if(redis.get("occupation")!=null){
            logger.info("在缓存中取职业");
            return (List<Occupation>) redis.get("occupation");
        } else {
            logger.error("添加职业到缓存，在数据库中取数据");
            redis.set("occupation",occupationDao.query());
            return occupationDao.query();
        }
    }
}
