package cn.wp.service.impl;

import cn.wp.dao.StudioDao;
import cn.wp.model.Studio;
import cn.wp.service.StudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: StudioServiceImpl
 * @Description:
 * @Author: 老王
 * @Date: 2019/5/10 22:47
 * @Version: 1.0
 */
@Service
public class StudioServiceImpl implements StudioService {
    @Autowired
    StudioDao studioDao;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return studioDao.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Studio record) {
        return studioDao.insert(record);
    }

    @Override
    public int insertSelective(Studio record) {
        return studioDao.insertSelective(record);
    }

    @Override
    public Studio selectByPrimaryKey(Long id) {
        return studioDao.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Studio record) {
        return studioDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Studio record) {
        return studioDao.updateByPrimaryKey(record);
    }

    @Override
    public List<Studio> selectAll() {
        return studioDao.selectAll();
    }

    @Override
    public List<Studio> selectByDynamicCondition(String name, Long state) {
        return studioDao.selectByDynamicCondition(name, state);
    }
}
