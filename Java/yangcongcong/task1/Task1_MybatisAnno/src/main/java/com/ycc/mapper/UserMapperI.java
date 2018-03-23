package com.ycc.mapper;

import com.ycc.model.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserMapperI {
    @Insert("insert into task1 values\n" +
            "            (#{id},#{stu_name},#{number},#{qq},#{type},\n" +
            "            #{university},#{time},#{link},#{pledge},#{senior},\n" +
            "            #{locality},#{create_at},#{update_at})")
    int addUser(List<User> userList);

    @Delete("delete from task1 where id=#{id}")
    int deleteUser(int id);

    @Update("update task1 stu_name=#{stu_name},number=#{number},qq=#{qq},type=#{type},university=#{university},\n" +
            "        time=#{time},link=#{link},pledge=#{pledge},senior=#{senior},locality=#{locality},update_at=#{update_at}  where id=#{id}")
    int updateUser(User user);

    @Select("select * from task1 where id=#{id}")
    User getUserById(int id);

    @Select("select * from task1 where stu_name=#{stu_name}")
    User getUserByName(String stu_name);

    @Select("select * from task1 where number=#{number}")
    User getUserByNumber(int number);

    @Select("select * from task1")
    List<User> getAllUser();
}
