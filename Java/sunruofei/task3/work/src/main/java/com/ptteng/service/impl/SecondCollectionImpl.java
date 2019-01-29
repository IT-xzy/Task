package com.ptteng.service.impl;

import com.ptteng.dao.SecondCollectionMapper;
import com.ptteng.model.SecondCollection;
import com.ptteng.service.SecondCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SecondCollectionImpl implements SecondCollectionService{
@Autowired
    SecondCollectionMapper secondCollectionMapper;
    @Override
    public int deleteByPrimaryKey(Long id) {
        return secondCollectionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(SecondCollection record) {
        return secondCollectionMapper.insert(record);
    }

    @Override
    public int insertSelective(SecondCollection record) {
        return secondCollectionMapper.insertSelective(record);
    }

    @Override
    public SecondCollection selectByPrimaryKey(Long id) {
        return secondCollectionMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(SecondCollection record) {
        return secondCollectionMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SecondCollection record) {
        return secondCollectionMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<SecondCollection> selectAll() {
        return secondCollectionMapper.selectAll();
    }

    @Override
    public List<SecondCollection> selectByDynamicCondition(String name, Long state) {
        return secondCollectionMapper.selectByDynamicCondition(name,state);
    }
}
