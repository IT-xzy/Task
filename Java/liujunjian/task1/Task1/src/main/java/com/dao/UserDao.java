package com.dao;

import com.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserDao {

    //    根据id查询用户信息
    @Select("select * from tb_test where id=#{id}")
    User findUserById(int id) throws Exception;

    //    根据用户名模糊查询
    @Select("select * from tb_test where name LIKE CONCAT(CONCAT('%', #{number}),'%')")
    List<User> findUserByName(String name) throws Exception;

    //    根据学号模糊查询
    @Select("select * from tb_test where number LIKE CONCAT(CONCAT('%', #{number}),'%')")
    List<User> findUserByNumber(String number) throws Exception;

    @Select("select * from tb_test")
    List<User> findUsers() throws Exception;

    //    添加用户信息
    @Insert("insert into tb_test(id,name,number,create_at,update_at) values(#{id},#{name},#{number},#{create_at},#{update_at})")
    @Options(useGeneratedKeys = true, keyColumn = "id")
    void insertUser(User user) throws Exception;

    //    删除用户信息
    @Delete("delete from tb_test where id=#{id}")
    void deleteUser(int id) throws Exception;

    //    更新用户信息
    @Update("update tb_test set name =#{name},number =#{number},update_at=#{update_at} where id=#{id}")
    void updateUser(User user) throws Exception;
}