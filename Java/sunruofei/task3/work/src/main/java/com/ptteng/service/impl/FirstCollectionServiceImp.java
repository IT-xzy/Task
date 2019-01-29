package com.ptteng.service.impl;

import com.ptteng.dao.FirstCollectionMapper;
import com.ptteng.model.FirstCollection;
import com.ptteng.service.FirstCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FirstCollectionServiceImp implements FirstCollectionService {
    @Autowired
    FirstCollectionMapper firstCollectionMapper;
    @Override
    public int deleteByPrimaryKey(Long id) {
        return firstCollectionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(FirstCollection record) {
        return firstCollectionMapper.insert(record);
    }

    @Override
    public int insertSelective(FirstCollection record) {
        return firstCollectionMapper.insertSelective(record);
    }

    @Override
    public FirstCollection selectByPrimaryKey(Long id) {
        return firstCollectionMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(FirstCollection record) {
        return firstCollectionMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(FirstCollection record) {
        return firstCollectionMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<FirstCollection> selectAll() {
        return firstCollectionMapper.selectAll();
    }

    @Override
    public List<FirstCollection> selectByDynamicCondition( String name,Long state) {
        return firstCollectionMapper.selectByDynamicCondition(name,state);
    }
}
