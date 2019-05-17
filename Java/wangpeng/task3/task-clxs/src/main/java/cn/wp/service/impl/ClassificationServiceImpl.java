package cn.wp.service.impl;

import cn.wp.dao.ClassificationDao;
import cn.wp.model.Classification;
import cn.wp.service.ClassificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: CollectionClassImpl
 * @Description:
 * @Author: 老王
 * @Date: 2019/5/10 22:29
 * @Version: 1.0
 */
@Service
public class ClassificationServiceImpl implements ClassificationService {
    @Autowired
    ClassificationDao classificationDao;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return classificationDao.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Classification record) {
        return classificationDao.insert(record);
    }

    @Override
    public int insertSelective(Classification record) {
        return classificationDao.insertSelective(record);
    }

    @Override
    public Classification selectByPrimaryKey(Long id) {
        return classificationDao.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Classification record) {
        return classificationDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Classification record) {
        return classificationDao.updateByPrimaryKey(record);
    }

    @Override
    public List<Classification> selectAll() {
        return classificationDao.selectAll();
    }

    @Override
    public List<Classification> selectByDynamicCondition(String name, Long state) {
        return classificationDao.selectByDynamicCondition(name, state);
    }
}
