package task04tiles.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import task04tiles.dao.StuDao;
import task04tiles.pojo.Students;
import task04tiles.services.StuServices;

import java.util.List;

/**
 * @author Administrator
 */
@Service
public class StuServicesImpl implements StuServices {
    @Autowired
    private StuDao stuDao;

    @Override
    public int querySum() {
        return stuDao.querySum();
    }

    @Override
    public int queryWorkSum() {
        return stuDao.queryWorkSum();
    }

    @Override
    public List<Students> queryFrontList() {
        return stuDao.queryFrontList();
    }
}
