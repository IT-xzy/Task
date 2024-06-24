package jnshu.mapper;


import jnshu.model.FirstWorks;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FirstWorksMapper {
    int deleteByPrimaryKey(Long id);

    int insert(FirstWorks record);

    int insertSelective(FirstWorks record);

    FirstWorks selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FirstWorks record);

    int updateByPrimaryKey(FirstWorks record);

    List<FirstWorks> selectByDynamicCondition(@Param("firstName") String firstName, @Param("status") Long status);
}