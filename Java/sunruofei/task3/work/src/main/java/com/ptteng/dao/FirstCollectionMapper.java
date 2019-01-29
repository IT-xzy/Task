package com.ptteng.dao;

import com.ptteng.model.FirstCollection;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface FirstCollectionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(FirstCollection record);

    int insertSelective(FirstCollection record);

    FirstCollection selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FirstCollection record);

    int updateByPrimaryKey(FirstCollection record);

    List<FirstCollection> selectAll();

    List <FirstCollection> selectByDynamicCondition(@Param("name") String name,@Param("state")Long state);
}