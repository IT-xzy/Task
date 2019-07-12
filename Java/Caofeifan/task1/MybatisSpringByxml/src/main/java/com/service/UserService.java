package com.service;

import com.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service层接口
 */
@Service
public interface UserService {
    /**
     * 查询全表
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
    public List<User> findById(Long id) throws Exception;


    /**
     * 条件查找
     *
     * @param name
     * @param number
     * @return
     */
    public List<User> getUserByCondition(String name, int number) throws Exception;


    /**
     * 插入
     *
     * @param user
     * @return
     */
    public int insert(User user) throws Exception;


    /**
     * 更新
     *
     * @param user
     * @return
     */
    public boolean update(User user) throws Exception;



    /**
     * 删除
     *
     * @param id
     * @return
     */
    public boolean delete(Long id) throws Exception;



}
