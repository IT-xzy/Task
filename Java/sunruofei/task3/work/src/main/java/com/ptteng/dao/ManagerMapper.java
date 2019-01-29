package com.ptteng.dao;

import com.ptteng.model.Manager;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ManagerMapper {
    int deleteByPrimaryKey(Long id);

    Long insert(Manager record);

    int insertSelective(Manager record);

    Manager selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Manager record);

    int updateByPrimaryKey(Manager record);

    List<Manager> selectAll();

    List<Manager> selectByDynamicCondition(@Param("roleId")Long roleId,@Param("name")String name);

}