package cn.wp.service;

import cn.wp.model.Module;

import java.util.List;

public interface ModuleService {
    int deleteByPrimaryKey(Long id);

    int insert(Module record);

    int insertSelective(Module record);

    Module selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Module record);

    int updateByPrimaryKey(Module record);

    List<Module> selectAll();

    List<Module> selectByDynamicCondition(String name);
}
