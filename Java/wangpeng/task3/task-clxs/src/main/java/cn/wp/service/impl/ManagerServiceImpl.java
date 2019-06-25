package cn.wp.service.impl;

import cn.wp.dao.ManagerDao;
import cn.wp.model.Manager;
import cn.wp.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: ManageServiceImpl
 * @Description:
 * @Author: 老王
 * @Date: 2019/5/10 22:40
 * @Version: 1.0
 */
@Service
public class ManagerServiceImpl implements ManagerService {
    @Autowired
    ManagerDao managerDao;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return managerDao.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Manager record) {
        return managerDao.insert(record);
    }

    @Override
    public int insertSelective(Manager record) {
        return managerDao.insertSelective(record);
    }

    @Override
    public Manager selectByPrimaryKey(Long id) {
        return managerDao.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Manager record) {
        return managerDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Manager record) {
        return managerDao.updateByPrimaryKey(record);
    }

    @Override
    public List<Manager> selectAll() {
        return managerDao.selectAll();
    }

    @Override
    public List<Manager> selectByDynamicCondition(Long role, String name) {
        return managerDao.selectByDynamicCondition(role, name);
    }
}
