package jnshu.service;

import jnshu.model.Module;
import org.springframework.ui.Model;

import java.util.List;

public interface ModuleService {
    int deleteByPrimaryKey(Long id);

    int insert(Module record);

    int insertSelective(Module record);

    Module selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Module record);

    int updateByPrimaryKey(Module record);

    List<Module> selectByDynamicCondition(String moduleName);
}
