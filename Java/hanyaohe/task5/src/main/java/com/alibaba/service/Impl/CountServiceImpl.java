package com.alibaba.service.Impl;


import com.alibaba.dao.CountMapper;
import com.alibaba.model.Count;
import com.alibaba.service.CountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CountServiceImpl implements CountService {
    private static final Logger log = LoggerFactory.getLogger(CountServiceImpl.class);
    @Resource

    private CountMapper countMapper;

    @Override
    public int deleteById(Integer id) {
        return countMapper.deleteById(id);
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
    public Count selectById(Integer id) {

        return countMapper.selectById(id);
    }

    @Override
    public int updateByIdSelective(Count record) {

        return countMapper.updateByIdSelective(record);
    }

    @Override
    public int updateById(Count record) {

        return countMapper.updateById(record);
    }


    public Count selectByName(String name) throws Exception{
        return countMapper.selectByName(name);
    }
    public int countByName(String user) throws Exception{
        return countMapper.countByName(user);
    }
}





