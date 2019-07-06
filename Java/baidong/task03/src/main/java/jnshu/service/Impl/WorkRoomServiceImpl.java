package jnshu.service.Impl;

import jnshu.mapper.WorkRoomMapper;
import jnshu.model.WorkRoom;
import jnshu.service.WorkRoomService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkRoomServiceImpl implements WorkRoomService {
    @Autowired
    WorkRoomMapper workRoomMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return workRoomMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(WorkRoom record) {
        return workRoomMapper.insert(record);
    }

    @Override
    public int insertSelective(WorkRoom record) {
        return workRoomMapper.insertSelective(record);
    }

    @Override
    public WorkRoom selectByPrimaryKey(Long id) {
        return workRoomMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(WorkRoom record) {
        return workRoomMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(WorkRoom record) {
        return workRoomMapper.updateByPrimaryKey(record);
    }
    @Override
        public List<WorkRoom> selectByDynamicCondition(@Param("name") String name, @Param("status") Long status){
        return workRoomMapper.selectByDynamicCondition(name,status);
    }

}

