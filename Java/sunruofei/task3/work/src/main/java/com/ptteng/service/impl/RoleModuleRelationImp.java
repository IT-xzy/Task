package com.ptteng.service.impl;


import com.ptteng.dao.RoleModuleRelationMapper;
import com.ptteng.model.RoleModuleRelation;
import com.ptteng.service.RoleModuleRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleModuleRelationImp implements RoleModuleRelationService{
@Autowired
    RoleModuleRelationMapper roleModuleRelationMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return roleModuleRelationMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(RoleModuleRelation record) {
        return roleModuleRelationMapper.insert(record);
    }

    @Override
    public int insertSelective(RoleModuleRelation record) {
        return roleModuleRelationMapper.insertSelective(record);
    }

    @Override
    public RoleModuleRelation selectByPrimaryKey(Long id) {
        return roleModuleRelationMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(RoleModuleRelation record) {
        return roleModuleRelationMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(RoleModuleRelation record) {
        return roleModuleRelationMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<RoleModuleRelation> selectAll() {
        return roleModuleRelationMapper.selectAll();
    }

    @Override
    public List<RoleModuleRelation> selectByDynamicCondition(Long id) {
        return roleModuleRelationMapper.selectByDynamicCondition(id);
    }
}
