package jnshu.service;

import jnshu.model.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleService {
    int deleteByPrimaryKey(Long id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    List<Role> selectByDynamicCondition(@Param("role") String role);

}
