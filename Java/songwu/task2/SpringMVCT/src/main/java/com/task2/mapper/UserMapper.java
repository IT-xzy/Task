package com.task2.mapper;

import com.task2.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
   /* 查询数据总量
    @Select("select count(*) from student1")

    int findUserCount() throws Exception;

    分页查询
    @Select("select *from student1 limit #{start},#{pageSize}")

    List<User> findUserByPage(@Param("start") int start, @Param("pageSize") int pageSize) throws Exception;

*/
//查询总数量
    int findUserCount() throws Exception;
//分页查询
    List<User> findUserByPage(@Param("start") int start, @Param("pageSize") int pageSize) throws Exception;

    //    新增
    long insertUser(User user);

    //    修改
    boolean updateUser(User user);

    //根据id查询
    User findUserById(long id);

    //    根据id删除
    boolean deleteUserById(long id);

    //    动态查询
    List<User> selectUser(User user);


}
