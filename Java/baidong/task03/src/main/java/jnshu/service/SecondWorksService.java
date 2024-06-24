package jnshu.service;

import jnshu.model.FirstWorks;
import jnshu.model.SecondWorks;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SecondWorksService {
      int deleteByPrimaryKey(Long id);

    int insert(SecondWorks record);

    int insertSelective(SecondWorks record);

    SecondWorks selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SecondWorks record);

    int updateByPrimaryKey(SecondWorks record);

    List<SecondWorks> selectByDynamicCondition(@Param("secondName") String secondName, @Param("status") Long status);

}
