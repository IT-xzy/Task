package com.jnshu.service.Impl;
import com.jnshu.dao.CountMapper;
import com.jnshu.model.Count;
import com.jnshu.service.CountService;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service(value = "countServiceImpl")
public class CountServiceImpl implements CountService {
    @Resource
    private CountMapper countMapper;

    @Override
    public int deleteByid(Integer id) {
        return countMapper.deleteByid(id);
    }
    @Override
    public int insert(Count record) {
        return countMapper.insert(record);
    }
    @Override
    public int insertSelective(Count record) {
        return countMapper.insertSelective(record);
    }
    @Override
    public Count selectByid(Integer id) {
        return countMapper.selectByid(id);
    }
    @Override
    public int updateByidSelective(Count record) {
        return countMapper.updateByidSelective(record);
    }
    @Override
    public int updateByid(Count record) {
        return countMapper.updateByid(record);
    }
}

