package com.java.dao;

import com.java.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 基于Xml的CRUD 演示
 * created by suger on 2018/9/15
 */
@Repository(value = "userDao")
public interface UserDao {

    /**
     * 插入
     * @param user
     * @return userId 用户Id
     */
    Long insert(User user);

    /**
     * 更新
     * @param user
     * @return  fasle:更新失败，true:更新成功
     */
    int update(User user);

    /**
     * 删除
     * @param userId
     * @return  fasle:删除失败，true:删除成功
     */
    int delete(Long userId);

    /**
     * 查询全部用户
     * @return  用户列表
     */
    List<User> findAll();

    /**
     * 根据姓名查询
     * @param userName
     * @return  用户列表
     */
    List<User> getUserByName(String userName);

    /**
     * 根据学号查询
     * @param onlineId 学号
     * @return 用户
     */
    List<User> getUserByonlineId(int onlineId);
}
