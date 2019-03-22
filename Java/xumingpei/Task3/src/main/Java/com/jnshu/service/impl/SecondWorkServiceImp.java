package com.jnshu.service.impl;

import com.jnshu.dao.SecondWorkMapper;
import com.jnshu.pojo.SecondWork;
import com.jnshu.service.SecondWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author pipiretrak
 * @date 2019/3/19 - 9:36
 */
@Service
public class SecondWorkServiceImp implements SecondWorkService {
    @Autowired
    SecondWorkMapper secondWorkMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return secondWorkMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(SecondWork record) {
        return secondWorkMapper.insert(record);
    }

    @Override
    public int insertSelective(SecondWork record) {
        return secondWorkMapper.insertSelective(record);
    }

    @Override
    public SecondWork selectByPrimaryKey(Long id) {
        return secondWorkMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(SecondWork record) {
        return secondWorkMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SecondWork record) {
        return secondWorkMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<SecondWork> selectByDynamic(String name, Integer status) {
        return secondWorkMapper.selectByDynamic(name,status);
    }
}
