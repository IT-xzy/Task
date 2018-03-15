package cn.summerwaves.service.impl;

import cn.summerwaves.dao.PositionDao;
import cn.summerwaves.model.Position;
import cn.summerwaves.service.IPositionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class PositionServiceImpl implements IPositionService {

    @Resource
    private PositionDao positionDao;

    @Override
    public List<Position> selectPositionByType(int type) {
        List<Position> positions = positionDao.selectPositionByType(type);

        return positions;
    }
}
