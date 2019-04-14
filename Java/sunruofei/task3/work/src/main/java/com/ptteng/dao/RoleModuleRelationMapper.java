package com.ptteng.dao;

import com.ptteng.model.RoleModuleRelation;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RoleModuleRelationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(RoleModuleRelation record);

    int insertSelective(RoleModuleRelation record);

    RoleModuleRelation selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RoleModuleRelation record);

    int updateByPrimaryKey(RoleModuleRelation record);

    List<RoleModuleRelation> selectAll();

    List<RoleModuleRelation> selectByDynamicCondition(@Param("roleModuleRelationId") Long id);
}