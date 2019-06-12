package jnshu.mapper;

import jnshu.model.WorkRoom;
import jnshu.model.Works;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorksMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Works record);

    int insertSelective(Works record);

    Works selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Works record);

    int updateByPrimaryKey(Works record);

    List<Works> selectByDynamicCondition(@Param("worksName") String worksName, @Param("status") Long status);

}