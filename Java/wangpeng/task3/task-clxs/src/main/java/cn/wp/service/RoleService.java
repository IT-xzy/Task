package cn.wp.service;

import cn.wp.model.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleService {
    int deleteByPrimaryKey(Long id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    List<Role> selectAll();

    List<Role> selectByDynamicCondition(@Param(value = "name") String name);

    List<Role> selectByIds(List<Long> ids);
}
