package com.service;

import com.pojo.User;

import java.util.List;

/**
 * Service层接口
 */
public interface UserService {
    /**
     * 插入
     * @param user
     * @return
     * @throws Exception
     */
    public Long insert(User user) throws Exception;

    /**
     * 通过ID删除
     * @param id
     * @return
     * @throws Exception
     */
    public boolean deleteById(Long id) throws Exception;

    /**
     * 更新
     * @param user
     * @return
     * @throws Exception
     */
    public boolean update(User user) throws Exception;

    /**
     * 通过ID查找
     * @param id
     * @return
     * @throws Exception
     */
    public User getUser(Long id) throws Exception;

    /**
     * 通过条件查询
     */
    public User getUserByCondition(String name, int number) throws Exception;
    /**
     * 查找全表
     * @return
     * @throws Exception
     */
    public List<User> getAllUsers() throws Exception;
    /**
     * @param name
     * 模糊查询
     */
    public List<User> selectByName(String name)throws Exception;

}