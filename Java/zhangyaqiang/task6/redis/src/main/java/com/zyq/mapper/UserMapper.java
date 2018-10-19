package com.zyq.mapper;

import com.zyq.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    @Insert("insert into user values (#{id},#{name},#{username},#{salt},#{password},#{createAt},#{updateAt})")
    @Options(useGeneratedKeys = true,keyColumn = "ID")
    void insert(User user);

    @Select("select * from user where username = #{username}")
    User selectByUsername(String username);

    @Select("select id from user where id = #{id}")
    Integer selectIdById(Integer id);

    @Select("select password from user where username = #{username}")
    String selectPwdByUserName(String username);
}
