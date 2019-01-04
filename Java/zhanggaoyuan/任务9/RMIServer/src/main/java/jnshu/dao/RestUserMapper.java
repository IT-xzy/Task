package jnshu.dao;

import jnshu.model.RestUser;

public interface RestUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(RestUser record);

//    int insertSelective(RestUser record);
//
    RestUser selectByName(String name);
//
//    int updateByPrimaryKeySelective(RestUser record);
//
//    int updateByPrimaryKey(RestUser record);

//    根据id查询盐
    String selectSalt (Long id);
}