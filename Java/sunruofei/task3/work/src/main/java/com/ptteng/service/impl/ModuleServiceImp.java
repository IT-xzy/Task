package com.ptteng.service.impl;


import com.ptteng.dao.ModuleMapper;
import com.ptteng.model.Module;
import com.ptteng.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ModuleServiceImp implements ModuleService {
    @Autowired
    ModuleMapper moduleMapper;
    @Override
    public int deleteByPrimaryKey(Long id) {
        return moduleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Module record) {
        return moduleMapper.insert(record);
    }

    @Override
    public int insertSelective(Module record) {
        return moduleMapper.insertSelective(record);
    }

    @Override
    public Module selectByPrimaryKey(Long id) {
        return moduleMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Module record) {
        return moduleMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Module record) {
        return moduleMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Module> selectAll() {
        return moduleMapper.selectAll();
    }

    @Override
    public List<Module> selectByDynamicCondition(String name) {
        return moduleMapper.selectByDynamicCondition(name);
    }
}
