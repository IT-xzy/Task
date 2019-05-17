package cn.wp.service.impl;

import cn.wp.dao.ModuleDao;
import cn.wp.model.Module;
import cn.wp.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: MoudleServiceImpl
 * @Description:
 * @Author: 老王
 * @Date: 2019/5/10 22:45
 * @Version: 1.0
 */
@Service
public class ModuleServiceImpl implements ModuleService {
    @Autowired
    ModuleDao moduleDao;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return moduleDao.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Module record) {
        return moduleDao.insert(record);
    }

    @Override
    public int insertSelective(Module record) {
        return moduleDao.insertSelective(record);
    }

    @Override
    public Module selectByPrimaryKey(Long id) {
        return moduleDao.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Module record) {
        return moduleDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Module record) {
        return moduleDao.updateByPrimaryKey(record);
    }

    @Override
    public List<Module> selectAll() {
        return moduleDao.selectAll();
    }

    @Override
    public List<Module> selectByDynamicCondition(String name) {
        return moduleDao.selectByDynamicCondition(name);
    }
}
