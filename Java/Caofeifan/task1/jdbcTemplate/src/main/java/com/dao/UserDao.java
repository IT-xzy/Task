package com.dao;
/**
 * dao接口
 */

import com.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserDao {
    /**
     * 增加
     *
     * @param user
     * @return
     */
    public User addUser(User user) throws Exception;

    /**
     * 删除
     *
     * @param id
     * @return
     */
    public boolean deleteUser(Long id)throws Exception;

    /**
     * 更新
     *
     * @param user
     * @return
     */
    public boolean updateUser(User user)throws Exception;

    /**
     * 通过ID查询Name
     *
     * @param id
     * @return
     */
    public String searchUserName(Long id)throws Exception;


    /**
     * 模糊查询
     *
     * @param name
     * @return
     */
    public User getStudentsByCondition(String name)throws Exception;

    /**
     * 根据ID查询
     *
     * @param id
     * @return
     */
    public User searchUser(Long id)throws Exception;

    /**
     * 根据ID查询
     *
     * @param name
     * @return
     */
    public User searchUserByNameAndNumber(String name, int number)throws Exception;

    /**
     * 查询全表
     *
     * @return
     */
    public List<Map<String, Object>> itemsList()throws Exception;

}
