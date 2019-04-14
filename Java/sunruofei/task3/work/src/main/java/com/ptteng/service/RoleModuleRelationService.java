package com.ptteng.service;

import com.ptteng.model.RoleModuleRelation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleModuleRelationService {

    int deleteByPrimaryKey(Long id);

    int insert(RoleModuleRelation record);

    int insertSelective(RoleModuleRelation record);

    RoleModuleRelation selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RoleModuleRelation record);

    int updateByPrimaryKey(RoleModuleRelation record);

    List<RoleModuleRelation> selectAll();

    List<RoleModuleRelation> selectByDynamicCondition(@Param("roleModuleRelationId") Long id);
}
