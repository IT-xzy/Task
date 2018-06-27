package com.alibaba.service.Impl;

import com.alibaba.dao.PositionMapper;
import com.alibaba.model.Position;
import com.alibaba.service.PositionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PositionServiceImpl implements PositionService {
    @Resource
    private PositionMapper positionMapper;
    @Override
    public int deleteById(Integer id){
        return positionMapper.deleteById(id);
    }
    @Override
    public int insert(Position record) {
        return positionMapper.insert(record);
    }

    @Override
    public int insertSelective(Position record) {
        return positionMapper.insertSelective(record);
    }

    @Override
    public Position selectById(Integer id) {
        return positionMapper.selectById(id);
    }

    @Override
    public int updateByIdSelective(Position record) {
        return positionMapper.updateByIdSelective(record);
    }

    @Override
    public int updateById(Position record) {
        return positionMapper.updateById(record);
    }

    @Override
    public List<Position> getAllPosition() {
        return positionMapper.getAllPosition();
    }

}
