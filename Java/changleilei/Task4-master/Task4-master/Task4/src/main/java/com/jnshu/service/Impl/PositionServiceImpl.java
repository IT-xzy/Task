package com.jnshu.service.Impl;
import com.jnshu.dao.PositionMapper;
import com.jnshu.model.Position;
import com.jnshu.service.PositionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service(value = "positionServiceImpl")
public class PositionServiceImpl implements PositionService {
    @Resource
    private PositionMapper positionMapper;

    @Override
    public int deleteByid(Integer id) {
        return positionMapper.deleteByid(id);
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
    public Position selectByid(Integer id) {
        return positionMapper.selectByid(id);
    }

    @Override
    public int updateByidSelective(Position record) {
        return positionMapper.updateByidSelective(record);
    }

    @Override
    public int updateByid(Position record) {
        return positionMapper.updateByid(record);
    }

    @Override
    public List<Position> getAllPosition() {
        return positionMapper.getAllPosition();
    }
}
