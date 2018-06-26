package com.ptt.mapper;

import com.ptt.pojo.PersistentLogins;
import org.apache.ibatis.annotations.Param;

public interface PersistentLoginsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PersistentLogins record);

    int insertSelective(PersistentLogins record);

    PersistentLogins selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PersistentLogins record);

    int updateByPrimaryKey(PersistentLogins record);
    //通过用户名和UID查询自动登录记录
    PersistentLogins selectByUsernameAndSeries(@Param("username") String username, @Param("series") String series);
    //通过用户名查询自动登录记录
    PersistentLogins selectByUsername(@Param("username") String username);

}