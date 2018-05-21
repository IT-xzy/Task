package com.ptteng.dao;

import com.ptteng.model.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


import java.util.List;

public interface UserDao {
    @Insert("INSERT INTO user (id,username,password) VALUES (#{id},#{username},#{password})")
    public int add(User user);

    @Delete("DELETE FROM user WHERE id=#{id}")
    Boolean delete(int id);

    @Select(" SELECT * FROM user WHERE id=#{id} ")
    public User get(int id);

    @Update("UPDATE user SET password=#{password},username=#{username} WHERE id=#{id}")
    Boolean update(User user);

    @Select("select * from  user")
    public List<User> list();

    public int count();
}
