package com.ptteng.service;

import com.ptteng.model.Direction;

import java.util.List;

/**
 * @ClassName DirectionService
 * @Description TODO
 * @Author 孙若飞
 * @Date 2019/2/12  10:45
 * @Version 1.0
 **/
public interface DirectionService {
    int deleteByPrimaryKey(Long id);

    int insert(Direction record);

    int insertSelective(Direction record);

    Direction selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Direction record);

    int updateByPrimaryKey(Direction record);

    List<Direction> selectAll();

}
