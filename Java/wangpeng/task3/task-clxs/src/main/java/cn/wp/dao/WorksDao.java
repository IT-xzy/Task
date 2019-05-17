package cn.wp.dao;

import cn.wp.model.Works;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WorksDao {
    int deleteByPrimaryKey(Long id);

    int insert(Works record);

    int insertSelective(Works record);

    Works selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Works record);

    int updateByPrimaryKey(Works record);

    List<Works> selectAll();

    List<Works> selectByDynamicCondition(@Param("worksName") String name, @Param("state") Long state);
}