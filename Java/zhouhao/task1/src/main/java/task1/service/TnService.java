package task1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import task1.dao.TnDao;
import task1.domain.Trainees;

import javax.annotation.Resource;
import javax.annotation.Resources;
import java.util.List;

/**
 * @Author: Zhou Hao
 * @Date: 2018/5/19 14:34
 * @Description: service调用TnDao完成业务逻辑
 * @Modify:
 */

@Service
public class TnService {

    @Autowired
    private TnDao tnDao;

    private static ApplicationContext context;

    static {
        context = new
                ClassPathXmlApplicationContext("applicationContext.xml");
    }

    public static void main(String[] args) {
        TnService ts = new TnService();
//        ts.tnDao = (TnDao) context.getBean("tnDao");
        Trainees tn = ts.findById(2033);
        System.out.println(tn);
    }

    public Trainees findById(int id) {
        Trainees tn = tnDao.findById(id);
        return tn;
    }

    public  List<Trainees> findByName(String name) {
        List<Trainees> list = tnDao.findByName(name);
        return list;
    }

    public void addTraninees(Trainees tn) {
        tnDao.addTrainees(tn);
    }

    public void updateTraninees(Trainees tn) {
        tnDao.updateTrainees(tn);
    }

    public void deleteById(int id) {
        tnDao.deleteById(id);
    }

}
