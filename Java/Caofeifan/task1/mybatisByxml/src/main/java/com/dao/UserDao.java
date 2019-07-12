package com.dao;

import com.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * dao层接口
 * @author Administrator
 */
public interface UserDao {
    /**
     * 通过ID查找
     * @param id
     * @return
     */
    public User getUser(Long id)throws Exception;
    /**
     * 通过条件查找
     * @param name
     * @param number
     * @return
     */
    public User getUserByCondition(@Param("name")String name,@Param("number") int number)throws Exception;
    /**
     *查找全表
     * @param
     * @return
     */
    public List<User> getAllUsers()throws Exception;

    /**
     * 模糊查询
     * @param name
     * @return
     */
    public List<User> selectByName(@Param("name") String name)throws Exception;


    /**
     *添加
     * @paramUser
     * @return
     *
     */
    public long insert(User user)throws Exception;
    /**
     *更新
     * @param user
     * @return
     */
    public int update(User user)throws Exception;
    /**
     *删除
     * @param id
     * @return
     */
    public int deleteById(Long id)throws Exception;
}