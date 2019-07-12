package com.service;


import com.model.User;


import java.util.List;

/**
 * Service接口
 *
 * @author Administrator
 */
public interface UserService {
    /**
     * 查找全表
     *
     * @return
     */
    public List<User> findAll() throws Exception;


    /**
     * @param name 模糊查询
     */
    public List<User> selectByName(String name) throws Exception;

    /**
     * 通过ID查询
     *
     * @param id
     * @return
     */
    public List<User> findById(long id) throws Exception;


    /**
     * 通过条件查询
     *
     * @param number
     * @param name
     * @return
     */
    public List<User> findByCondition(String name, int number) throws Exception;


    /**
     * 增加
     *
     * @param user
     * @return
     */
    public int add(User user) throws Exception;


    /**
     * 删除
     *
     * @param id
     * @return
     */
    public boolean deleteById(Long id) throws Exception;


    /**
     * 更新
     *
     * @param user
     * @return
     */
    public boolean update(User user) throws Exception;


}
