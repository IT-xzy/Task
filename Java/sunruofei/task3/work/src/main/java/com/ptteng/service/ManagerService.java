package com.ptteng.service;

import com.ptteng.model.Manager;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ManagerService {
    int deleteByPrimaryKey(Long id);

    Long insert(Manager record);

    int insertSelective(Manager record);

    Manager selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Manager record);

    int updateByPrimaryKey(Manager record);

    List<Manager> selectAll();

    List<Manager> selectByDynamicCondition(@Param("roleId")Long roleId,@Param("name")String name);


}
