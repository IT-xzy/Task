package com.ptteng.service.impl;


import com.ptteng.dao.ManagerMapper;
import com.ptteng.model.Manager;
import com.ptteng.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerServiceImp implements ManagerService{
    @Autowired
    ManagerMapper managerMapper;
    @Override
    public int deleteByPrimaryKey(Long id) {
        return managerMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Long insert(Manager record) {
        return managerMapper.insert(record);
    }

    @Override
    public int insertSelective(Manager record) {
        return managerMapper.insertSelective(record);
    }

    @Override
    public Manager selectByPrimaryKey(Long id) {
        return managerMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Manager record) {
        return managerMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Manager record) {
        return managerMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Manager> selectAll() {
        return managerMapper.selectAll();
    }

    @Override
    public List<Manager> selectByDynamicCondition(Long roleId, String name) {

        return managerMapper.selectByDynamicCondition(roleId,name);
    }
}
