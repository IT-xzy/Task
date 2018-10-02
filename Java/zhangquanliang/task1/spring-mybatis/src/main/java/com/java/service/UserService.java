package com.java.service;

import com.java.pojo.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author suger
 * @date 2018-09-15
 */

public interface UserService {
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
    Boolean update(User user);

    /**
     * 删除
     * @param userId
     * @return  false:删除失败，true:删除成功
     */
    Boolean delete(Long userId);

    /**
     * 查询全部用户
     * @return  用户列表
     */
    List<User>  findAll();

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
