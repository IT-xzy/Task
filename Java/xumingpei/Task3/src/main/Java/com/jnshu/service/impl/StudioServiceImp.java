package com.jnshu.service.impl;

import com.jnshu.dao.StudioMapper;
import com.jnshu.pojo.Studio;
import com.jnshu.service.StudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author pipiretrak
 * @date 2019/3/19 - 9:36
 */
@Service
public class StudioServiceImp implements StudioService {
    @Autowired
    StudioMapper studioMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return studioMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Studio record) {
        return studioMapper.insert(record);
    }

    @Override
    public int insertSelective(Studio record) {
        return studioMapper.insertSelective(record);
    }

    @Override
    public Studio selectByPrimaryKey(Long id) {
        return studioMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Studio record) {
        return studioMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Studio record) {
        return studioMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Studio> selectByDynamic(String name, Integer status) {
        return studioMapper.selectByDynamic(name,status);
    }
}
