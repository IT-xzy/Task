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
    private Redis redisStudent;
    Logger logger = Logger.getLogger(StudentService.class);

    @Override
    public List<Occupation> query() {
        if(redisStudent.get("occupation")!=null){
            logger.error("在缓存中取职业");
            return (List<Occupation>) redisStudent.get("occupation");
        } else {
            logger.error("添加职业到缓存，在数据库中取数据");
            redisStudent.set("occupation",occupationDao.query());
            return occupationDao.query();
        }
    }

}
