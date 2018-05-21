package lujing.mapper;

import lujing.pojo.Learn;

import java.util.List;

public interface LearnMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Learn record);

    int insertSelective(Learn record);

    Learn selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Learn record);

    int updateByPrimaryKey(Learn record);
    
    List<Learn> selectAll();
}