package com.ptteng.dao;

import com.ptteng.model.SecondCollection;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SecondCollectionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SecondCollection record);

    int insertSelective(SecondCollection record);

    SecondCollection selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SecondCollection record);

    int updateByPrimaryKey(SecondCollection record);
    List<SecondCollection> selectAll();

    List<SecondCollection> selectByDynamicCondition(@Param("collectionName")String name,@Param("state")Long state);
}