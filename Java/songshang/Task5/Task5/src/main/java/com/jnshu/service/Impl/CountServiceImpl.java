package com.jnshu.service.Impl;
import com.jnshu.dao.CountMapper;
import com.jnshu.model.Count;
import com.jnshu.service.CountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service(value = "countServiceImpl")
public class CountServiceImpl implements CountService {
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

    @Override
    public List<Count> getAllCount() {
        return countMapper.getAllCount();
    }
    @Override
    public Count selectByName(String name) throws Exception{
        return countMapper.selectByName(name);
    }
    @Override
    public int countByName(String user) throws Exception{
        return countMapper.countByName(user);
    }
}

