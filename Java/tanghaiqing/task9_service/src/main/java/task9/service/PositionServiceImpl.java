package task9.service;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import task9.dao.PositionStuDao;
import task9.pojo.PositionStu;
import task9.util.ApplicationException;

import javax.annotation.Resource;
import java.util.List;


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

    public static void main(String[] args) {
        new ClassPathXmlApplicationContext("spring-servlet.xml");
        Object lock=new Object();
        synchronized (lock){
            try {
                lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
