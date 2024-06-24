package jnshu.service;

import jnshu.model.Works;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WorksService {
    int deleteByPrimaryKey(Long id);

    int insert(Works record);

    int insertSelective(Works record);

    Works selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Works record);

    int updateByPrimaryKey(Works record);

    List<Works> selectByDynamicCondition(@Param("worksName") String worksName, @Param("status") Long status);

}
