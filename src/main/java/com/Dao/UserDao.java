package com.Dao;

import com.Pojo.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserDao {
    @Insert("insert into User (userId,userName,userTel,userMail,userPhoto,userSex,userQq, userType, userSchool, userDailyLink, userWords, userBrother,create_at,update_at,create_by,update_by,userPassword) values (#{userId},#{userName},#{userTel},#{userMail},#{userPhoto},#{userSex},#{userQq},#{userType},#{userSchool},#{userDailyLink},#{userWords},#{userBrother},#{create_at},#{update_at},#{create_by},#{update_by},#{userPassword})")
    void doInsert(User user);

    @Delete("delete from User where userId = #{userId}")
    void doDelete(String userId);

    @Update("update User set userId= #{userId},userName= #{userName},userPassword=#{userPassword},userTel= #{userTel},userMail=#{userMail},userPhoto= #{userPhoto},userSex=#{userSex},userQq=#{userQq}, userType=#{userType}, userSchool=#{userSchool}, userDailyLink=#{userDailyLink}, userWords=#{userWords}, userBrother=#{userBrother},create_at= #{create_at},update_at= #{update_at},create_by= #{create_by},update_by= #{update_by}")
    void doUpdate(User user);


    @Select("select * from User where userId =#{userId}")
    User findById(String userId);

    @Select("select * from User")
    List<User> findAll();
}
