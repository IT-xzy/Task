package jnshu.service;

import jnshu.mapper.FirstWorksMapper;
import jnshu.model.FirstWorks;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FirstWorksService {

    int deleteByPrimaryKey(Long id);

    int insert(FirstWorks record);

    int insertSelective(FirstWorks record);

    FirstWorks selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FirstWorks record);

    int updateByPrimaryKey(FirstWorks record);

    List<FirstWorks> selectByDynamicCondition(@Param("firstName") String firstName, @Param("status") Long status);

}
