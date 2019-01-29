package com.ptteng.service.impl;


import com.ptteng.dao.WorkMapper;
import com.ptteng.model.Work;
import com.ptteng.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class WorkServiceImp  implements WorkService{
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
    public List<Work> selectAll() {
        return workMapper.selectAll();
    }

    @Override
    public List<Work> selectByDynamicCondition(String name, Long state) {
        return workMapper.selectByDynamicCondition(name,state);
    }
}
