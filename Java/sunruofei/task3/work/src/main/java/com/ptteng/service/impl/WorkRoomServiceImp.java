package com.ptteng.service.impl;

import com.ptteng.dao.WorkRoomMapper;
import com.ptteng.model.WorkRoom;
import com.ptteng.service.WorkRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class WorkRoomServiceImp implements WorkRoomService {
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
    public List<WorkRoom> selectAll() {
        return workRoomMapper.selectAll();
    }

    @Override
    public List<WorkRoom> selectByDynamicCondition(String name, Long state) {
        return workRoomMapper.selectByDynamicCondition(name,state);
    }
}
