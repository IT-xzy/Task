package com.suger.service;

import com.suger.pojo.Page;
import com.suger.pojo.User;

import java.util.List;

/**
 * @author suger
 * @date 2018/11/19 15:46
 *
 * 用户的service
 */

public interface UserService {

    /**
     * 新增用户信息
     * @param User 用户信息
     * @return id 插入记录的唯一标识
     */
    Long insertUser(User User);

    /**
     * 更新用户信息
     * @param User
     * @return  更新结果：true-----更新成功，false------更新失败
     */
    Boolean updateUser(User User);

    /**
     * 删除用户信息
     * @param id  用户id
     * @return  删除结果：true-----删除成功，false------更新失败
     */
    Boolean deleteUser(Long id);

    /**
     * 分页查询
     * @param page 分页工具类
     * @return
     */
    List<User> findAll(Page page);

    /**
     * 查询所有
     * @return
     */
    List<User> findAll();

    /**
     * 查询记录总数
     * @return  记录总数
     */
    int total();

    /**
     * 根据id查询
     * @param id
     * @return 具体的用户信息
     */
    User getUserById(Long id);

    /**
     * 根据姓名查询
     * @param name
     * @return
     */

    User getUserByName(String name);

    /**
     * 根据姓名 模糊查询，如果条件为空，则实现查全表
     * @param name
     * @return
     */
    List<User> getUser(String name);

}
