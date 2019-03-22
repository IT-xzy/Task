package com.jnshu.service.impl;

import com.jnshu.dao.FirstWorkMapper;
import com.jnshu.pojo.FirstWork;
import com.jnshu.service.FirstWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author pipiretrak
 * @date 2019/3/19 - 9:36
 */
@Service
public class FirstWorkServiceImp implements FirstWorkService {
    @Autowired
    FirstWorkMapper firstWorkMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return firstWorkMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(FirstWork record) {
        return firstWorkMapper.insert(record);
    }

    @Override
    public int insertSelective(FirstWork record) {
        return firstWorkMapper.insertSelective(record);
    }

    @Override
    public FirstWork selectByPrimaryKey(Long id) {
        return firstWorkMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(FirstWork record) {
        return updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(FirstWork record) {
        return firstWorkMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<FirstWork> selectByDynamic(String name, Integer status) {
        return firstWorkMapper.selectByDynamic(name,status);
    }
}
