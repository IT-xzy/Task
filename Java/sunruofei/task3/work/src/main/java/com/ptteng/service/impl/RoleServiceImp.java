package com.ptteng.service.impl;


import com.ptteng.dao.RoleMapper;
import com.ptteng.model.Role;
import com.ptteng.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImp implements RoleService{
    @Autowired
    RoleMapper roleMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return roleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Role record) {
        return roleMapper.insert(record);
    }

    @Override
    public int insertSelective(Role record) {
        return roleMapper.insertSelective(record);
    }

    @Override
    public Role selectByPrimaryKey(Long id) {
        return roleMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Role record) {
        return roleMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Role record) {
        return roleMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Role> selectAll() {
        return roleMapper.selectAll();
    }

    @Override
    public List<Role> selectByDynamicCondition(String name) {
        return roleMapper.selectByDynamicCondition(name);
    }

    @Override
    public List<Role> selectByIds(List<Long> ids) {
        return roleMapper.selectByIds(ids);
    }
}
