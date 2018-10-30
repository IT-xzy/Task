package com.java.dao;

import com.java.pojo.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 基于注解的CRUD 演示
 * created by suger on 2018/9/17
 */
@Repository(value = "userAnntionDao")
public interface UserAnnotationDao {
    @Insert("insert into user(user_name,qq,profession,start_time,graduated_from,online_id,daily_link,wish,counselor,way,create_at,update_at)" +
            "values(#{userName},#{qq},#{profession},#{startTime},#{graduatedFrom},#{onlineId},#{dailyLink},#{wish},#{counselor},#{way},#{createAt},#{updateAt})")
    @Options(useGeneratedKeys=true, keyProperty="userId", keyColumn="user_id")
    Long insert(User user);

    @Update("update user set profession=#{profession},update_at=#{updateAt} where user_id = #{userId}")
    int update(User user);

    @Delete("delete from user where user_id = #{userId}")
    int delete(Long userId);

    @Select("select user_name,qq,profession,start_time,graduated_from,online_id,daily_link,wish,counselor,way," +
            "create_at,update_at from user")
    List<User> findAll();

    @Select("select  user_name,qq,profession,start_time,graduated_from,online_id,daily_link,wish,counselor,way," +
            "create_at,update_at from user where user_name like #{userName}")
    List<User> getUserByName(String userName);

    @Select(" select user_name,qq,profession,start_time,graduated_from,online_id,daily_link,wish,counselor,way," +
            "create_at,update_at from user where online_id = #{onlineId}")
    List<User> getUserByonlineId(int onlineId);
}
