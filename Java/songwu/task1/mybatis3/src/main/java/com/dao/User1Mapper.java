package com.dao;

import com.pojo.User1;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface User1Mapper {
    @Select("select * from user1 where id=#{id}")
    public User1 selectById(int id);

    @Select("select * from user1 ")
    public List<User1> selectAll();

    @Insert("insert into user1(name,password,birth)values(#{name},#{password},#{birth})")
    public int insert(User1 user1);

    @Update("update user1 set name=#{name}where id=#{id}")
    public int updateById(User1 user1);

    @Delete("delete from user1 where id=#{id}")
    public int deleteById(int id);

}
