package cn.wp.dao;

import cn.wp.model.Classification;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ClassificationDao {
    int deleteByPrimaryKey(Long id);

    int insert(Classification record);

    int insertSelective(Classification record);

    Classification selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Classification record);

    int updateByPrimaryKey(Classification record);

    List<Classification> selectAll();

    List<Classification> selectByDynamicCondition(@Param("name") String name, @Param("state") Long state);
}