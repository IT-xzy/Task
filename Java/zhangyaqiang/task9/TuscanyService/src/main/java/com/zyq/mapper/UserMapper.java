package com.zyq.mapper;

import com.zyq.pojo.User;
import org.apache.ibatis.annotations.*;

public interface UserMapper {
    @Insert("insert into user values (#{id},#{name},#{username},#{salt},#{password},#{telephone},#{email},#{headPhoto},#{createAt},#{updateAt})")
    @Options(useGeneratedKeys = true, keyColumn = "ID")
    void insert(User user);

    @Results({@Result(column = "head_photo", property = "headPhoto"), @Result(column = "create_at", property = "createAt"), @Result(column = "update_at", property = "updateAt")})
    @Select("select * from user where username = #{username}")
    User selectByUsername(String username);

    @Results({@Result(column = "head_photo", property = "headPhoto"), @Result(column = "create_at", property = "createAt"), @Result(column = "update_at", property = "updateAt")})
    @Select("select * from user where telephone = #{telephone}")
    User selectByTel(String telephone);

    @Results({@Result(column = "head_photo", property = "headPhoto"), @Result(column = "create_at", property = "createAt"), @Result(column = "update_at", property = "updateAt")})
    @Select("select * from user where email = #{email}")
    User selectByEmail(String email);

    @Update("update user set name=#{2},head_photo=#{1} where username = #{0}")
    void updateByUsername(String username, String headPhoto, String name);

    @Select("select id from user where id = #{id}")
    Integer selectIdById(Integer id);

    @Select("select password from user where username = #{username}")
    String selectPwdByUserName(String username);

    @Select("select password from user where telephone = #{telephone}")
    String selectPwdByTelephone(String telephone);

    @Select("select password from user where email = #{email}")
    String selectPwdByEmail(String email);
}
