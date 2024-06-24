package jnshu.service.Impl;

import jnshu.mapper.ModuleMapper;
import jnshu.model.Module;
import jnshu.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModuleServiceImpl implements ModuleService {
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
    public List<Module> selectByDynamicCondition(String moduleName){return moduleMapper.selectByDynamicCondition(moduleName);}
}
