package com.jnshu.service.impl;

import com.jnshu.dao.WorkMapper;
import com.jnshu.pojo.Work;
import com.jnshu.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author pipiretrak
 * @date 2019/3/19 - 9:36
 */
@Service
public class WorkServiceImp implements WorkService {
    @Autowired
    WorkMapper workMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return workMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Work record) {
        return workMapper.insert(record);
    }

    @Override
    public int insertSelective(Work record) {
        return workMapper.insertSelective(record);
    }

    @Override
    public Work selectByPrimaryKey(Long id) {
        return workMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Work record) {
        return workMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Work record) {
        return workMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Work> selectByDynamic(String name, Integer status) {
        return workMapper.selectByDynamic(name,status);
    }
}
