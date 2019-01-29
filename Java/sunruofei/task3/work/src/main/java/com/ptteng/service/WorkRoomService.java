package com.ptteng.service;

import com.ptteng.model.WorkRoom;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WorkRoomService {
    int deleteByPrimaryKey(Long id);

    int insert(WorkRoom record);

    int insertSelective(WorkRoom record);

    WorkRoom selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(WorkRoom record);

    int updateByPrimaryKey(WorkRoom record);

    List<WorkRoom> selectAll();

    List<WorkRoom> selectByDynamicCondition (@Param("workRoomName")String name, @Param("state")Long state);
}
