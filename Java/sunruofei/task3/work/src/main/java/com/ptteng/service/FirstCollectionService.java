package com.ptteng.service;

import com.ptteng.model.FirstCollection;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FirstCollectionService {

    int deleteByPrimaryKey(Long id);

    int insert(FirstCollection record);

    int insertSelective(FirstCollection record);

    FirstCollection selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FirstCollection record);

    int updateByPrimaryKey(FirstCollection record);

    List<FirstCollection> selectAll();

    List <FirstCollection> selectByDynamicCondition(@Param("name") String name,@Param("state")Long state);

}
