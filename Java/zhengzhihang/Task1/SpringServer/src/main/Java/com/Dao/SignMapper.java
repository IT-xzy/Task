package com.Dao;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

@Service(value = "DaoInterface")
public interface SignMapper {
    @Select("select * from sign where id=#{id}")
    public Sign findUserById(int id);
    @Select("select * FROM sign where  name like CONCAT('%', #{name}, '%')")
    public Sign findUserByName(String name);
    @Insert("INSERT INTO sign(name,city)VALUES(#{name},#{city})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    public int insertUser(Sign user);
    @Delete("DELETE from sign where id=#{id}")
    public int deleteUserById(int id);
    @Update("UPDATE sign set name=#{name} ,city=#{city} where id=#{id}")
    public int updateUserById(Sign user);
    @Delete("DELETE from sign where name=#{name}")
    public int deleteUserByName(String name);
}