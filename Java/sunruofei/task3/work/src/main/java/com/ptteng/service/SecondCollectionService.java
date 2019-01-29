package com.ptteng.service;

import com.ptteng.model.SecondCollection;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SecondCollectionService {
    int deleteByPrimaryKey(Long id);

    int insert(SecondCollection record);

    int insertSelective(SecondCollection record);

    SecondCollection selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SecondCollection record);

    int updateByPrimaryKey(SecondCollection record);
    List<SecondCollection> selectAll();
    List<SecondCollection> selectByDynamicCondition(@Param("collectionName")String name, @Param("state")Long state);
}
