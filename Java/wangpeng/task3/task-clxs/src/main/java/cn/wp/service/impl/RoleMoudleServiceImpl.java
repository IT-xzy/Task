package cn.wp.service.impl;

import cn.wp.dao.RoleModuleDao;
import cn.wp.model.RoleModule;
import cn.wp.service.RoleModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: RoleMoudleServiceImpl
 * @Description:
 * @Author: 老王
 * @Date: 2019/5/10 22:46
 * @Version: 1.0
 */
@Service
public class RoleMoudleServiceImpl implements RoleModuleService {
    @Autowired
    RoleModuleDao roleModuleDao;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return roleModuleDao.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(RoleModule record) {
        return roleModuleDao.insert(record);
    }

    @Override
    public int insertSelective(RoleModule record) {
        return roleModuleDao.insertSelective(record);
    }

    @Override
    public RoleModule selectByPrimaryKey(Long id) {
        return roleModuleDao.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(RoleModule record) {
        return roleModuleDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(RoleModule record) {
        return roleModuleDao.updateByPrimaryKey(record);
    }

    @Override
    public List<RoleModule> selectAll() {
        return roleModuleDao.selectAll();
    }

    @Override
    public List<RoleModule> selectByDynamicCondition(Long id) {
        return roleModuleDao.selectByDynamicCondition(id);
    }
}
