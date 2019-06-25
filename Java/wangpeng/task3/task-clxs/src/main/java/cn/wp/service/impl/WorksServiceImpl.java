package cn.wp.service.impl;

import cn.wp.dao.WorksDao;
import cn.wp.model.Works;
import cn.wp.service.WorksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: WorksServiceImpl
 * @Description:
 * @Author: 老王
 * @Date: 2019/5/10 22:47
 * @Version: 1.0
 */
@Service
public class WorksServiceImpl implements WorksService {
    @Autowired
    WorksDao worksDao;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return worksDao.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Works record) {
        return worksDao.insert(record);
    }

    @Override
    public int insertSelective(Works record) {
        return worksDao.insertSelective(record);
    }

    @Override
    public Works selectByPrimaryKey(Long id) {
        return worksDao.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Works record) {
        return worksDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Works record) {
        return worksDao.updateByPrimaryKey(record);
    }

    @Override
    public List<Works> selectAll() {
        return worksDao.selectAll();
    }

    @Override
    public List<Works> selectByDynamicCondition(String name, Long state) {
        return worksDao.selectByDynamicCondition(name, state);
    }
}
