package cn.summerwaves.dao;

import cn.summerwaves.domain.User;
import org.apache.ibatis.annotations.*;

/**
 * Created by summerwaves on 2017/7/18.
 */
public interface UserDao {
    void insertUser(User user)throws Exception;

    User selectUserByName(String userName)throws Exception;

    void updateUserByName(User userName)throws Exception;

    void deleteUserByName(String userName)throws Exception;

    @Insert("INSERT INTO user(user_name,password,sex)VALUE (#{userName},#{password},#{sex});")
    void insertUserByAnnotation(User user);

    @Select("SELECT * FROM user WHERE user_name = #{userName}")
    @Results({
            @Result(column = "user_name", property = "userName"),
            @Result(column = "password", property = "password"),
            @Result(column = "sex", property = "sex")
    })
    User selectByNameByAnnotation(String userName);


    @Update("UPDATE user SET password = #{password} ,sex = #{sex} WHERE user_name = #{userName}" )
    void updateUserByNameByAnnotation(User user);


    @Delete("DELETE FROM user WHERE user_name = #{userName}")
    void deleteUserByNameByAnnotation(String userName);
}
