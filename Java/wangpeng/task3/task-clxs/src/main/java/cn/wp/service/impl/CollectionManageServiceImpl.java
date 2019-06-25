package cn.wp.service.impl;

import cn.wp.dao.CollectionManageDao;
import cn.wp.model.CollectionManage;
import cn.wp.service.CollectionManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: CollectionManageImpl
 * @Description:
 * @Author: 老王
 * @Date: 2019/5/10 22:29
 * @Version: 1.0
 */
@Service
public class CollectionManageServiceImpl implements CollectionManageService {
    @Autowired
    CollectionManageDao collectionManageDao;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return collectionManageDao.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(CollectionManage record) {
        return collectionManageDao.insert(record);
    }

    @Override
    public int insertSelective(CollectionManage record) {
        return collectionManageDao.insertSelective(record);
    }

    @Override
    public CollectionManage selectByPrimaryKey(Long id) {
        return collectionManageDao.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(CollectionManage record) {
        return collectionManageDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(CollectionManage record) {
        return collectionManageDao.updateByPrimaryKey(record);
    }

    @Override
    public List<CollectionManage> selectAll() {
        return collectionManageDao.selectAll();
    }

    @Override
    public List<CollectionManage> selectByDynamicCondition(String name, Long state) {
        return collectionManageDao.selectByDynamicCondition(name, state);
    }
}
