package com.suger.dao;

import com.suger.pojo.Page;
import com.suger.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author suger
 * @date 2018/11/19 15:35
 *
 * 用户的 dao 接口 ，主要：CURD ,分页查询用户信息，根据姓名精确查询，以及模糊查询
 *
 */
@Repository
public interface UserDao {

    // 添加用户，返回ID
    Long insertUser(User User);

    // 更新用户信息，返回受影响的行数，1---更新成功，0---更新失败
    int updateUser(User User);

    // 删除用户信息，返回受影响的行数，1---删除成功，0---删除失败
    int deleteUser(Long id);

    // 使用mybatis的动态语句,有参的话,使用limit ; 无参的话，直接查全表
    // 前台已经做好分页显示
    // 分页·查询
    List<User> findAll(Page page);
    // 直接查全表
    List<User> findAll();

    // 查总记录数
    int total();
    //根据id查询，返回用户信息，若结果为null,代表id对应记录不存在
    User getUserById(Long id);

    // 根据姓名查询，非模糊查询
    User getUserByName(String name);

    // 根据姓名模糊查询，返回对应的user信息
    List<User> getUser(@Param("name") String name);

}
