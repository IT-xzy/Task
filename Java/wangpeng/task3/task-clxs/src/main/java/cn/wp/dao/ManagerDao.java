package cn.wp.dao;

import cn.wp.model.Manager;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 老王
 */
public interface ManagerDao {
    int deleteByPrimaryKey(Long id);

    int insert(Manager record);

    int insertSelective(Manager record);

    Manager selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Manager record);

    int updateByPrimaryKey(Manager record);

    List<Manager> selectAll();

    List<Manager> selectByDynamicCondition(@Param("role") Long role, @Param("name") String name);
}