package cn.wp.service.impl;

import cn.wp.dao.RoleDao;
import cn.wp.model.Role;
import cn.wp.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: RoleServiceImpl
 * @Description:
 * @Author: 老王
 * @Date: 2019/5/10 22:46
 * @Version: 1.0
 */
@Service
public class RoleServiceImpl implements RoleService {
@Autowired
RoleDao roleDao;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return roleDao.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Role record) {
        return roleDao.insert(record);
    }

    @Override
    public int insertSelective(Role record) {
        return roleDao.insertSelective(record);
    }

    @Override
    public Role selectByPrimaryKey(Long id) {
        return roleDao.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Role record) {
        return roleDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Role record) {
        return roleDao.updateByPrimaryKey(record);
    }

    @Override
    public List<Role> selectAll() {
        return roleDao.selectAll();
    }

    @Override
    public List<Role> selectByDynamicCondition(String name) {
        return roleDao.selectByDynamicCondition(name);
    }

    @Override
    public List<Role> selectByIds(List<Long> ids) {
        return roleDao.selectByIds(ids);
    }
}
