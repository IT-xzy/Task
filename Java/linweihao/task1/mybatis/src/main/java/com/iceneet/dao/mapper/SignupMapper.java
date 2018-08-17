package com.iceneet.dao.mapper;

import com.iceneet.Entity.signup;
import org.apache.ibatis.annotations.*;

import java.util.List;


public interface SignupMapper {
    //查
    @Select("select * from signup where name = #{name}")
    List<signup> getSignupPerson(@Param("name") String name);
    //多参数进行更改
    @Update("update signup set name=#{0} where  name=#{1}")
    boolean updateSignup(String name,String name1);
    //删
    @Delete("delete from signup where name = #{name}")
    boolean deleteSignup(@Param("name") String name);
    //增
    @Insert("INSERT INTO signup(name,qq) VALUES(#{name}, #{qq})")
    void save(signup signup);
}
