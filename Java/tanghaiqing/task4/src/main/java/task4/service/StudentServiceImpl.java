package task4.service;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import task4.dao.StudentDao;
import task4.util.ApplicationException;

import javax.annotation.Resource;

@Service
public class StudentServiceImpl implements StudentService {
    private Logger logger =Logger.getLogger(StudentServiceImpl.class);
    @Resource(name = "studentDao")
    private StudentDao studentDao;

    @Override
    public Integer countService() {
        logger.info("countService()");
        Integer count =studentDao.count();
        logger.info(count);
        if (count==null){
            logger.info("countService() Exception");
            throw new ApplicationException("取值为null");
        }
        return count;
    }

    @Override
    public Integer countJobService() {
        logger.info("countJobService()");
        Integer countJob =studentDao.countJob();
        logger.info(countJob);
        if (countJob==null){
            logger.info("countJobService() Exception");
            throw new ApplicationException("取值为null");
        }
        return countJob;
    }
}
