package com.ptteng.service.impl;

import com.ptteng.dao.DirectionMapper;
import com.ptteng.entity.Direction;
import com.ptteng.service.DirectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName DirectionServiceImp
 * @Description TODO
 * @Author 孙若飞
 * @Date 2019/2/12  11:32
 * @Version 1.0
 **/
@Service
public class DirectionServiceImp implements DirectionService {
    @Autowired
    DirectionMapper directionMapper;
    @Override
    public int deleteByPrimaryKey(Long id) {
        return directionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Direction record) {
        return directionMapper.insert(record);
    }

    @Override
    public int insertSelective(Direction record) {
        return directionMapper.insertSelective(record);
    }

    @Override
    public Direction selectByPrimaryKey(Long id) {
        return directionMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Direction record) {
        return directionMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Direction record) {
        return directionMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Direction> selectAll() {
        return directionMapper.selectAll();
    }
}
