package cn.wp.dao;

import cn.wp.model.RoleModule;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleModuleDao {
    int deleteByPrimaryKey(Long id);

    int insert(RoleModule record);

    int insertSelective(RoleModule record);

    RoleModule selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RoleModule record);

    int updateByPrimaryKey(RoleModule record);

    List<RoleModule> selectAll();

    List<RoleModule> selectByDynamicCondition(@Param("roleModuleRelationId") Long id);
}