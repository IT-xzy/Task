package com.dao;

import com.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * DAO层接口
 */
@Repository
public interface UserMapper {

    /**
     * 查询全表
     *
     * @return
     */
    List<User> findAll()throws Exception;

    /**
     * 模糊查询
     *
     * @param name
     * @return
     */
    public List<User> selectByName(@Param("name") String name)throws Exception;

    /**
     * 通过ID查询
     *
     * @param id
     * @return
     */
    public List<User> findById(Long id)throws Exception;

    /**
     * 通过条件查找
     *
     * @param name
     * @param number
     * @return
     */
    public List<User> getUserByCondition(@Param("name") String name, @Param("number") int number)throws Exception;

    /**
     * 插入
     *
     * @param user
     * @return
     */
    public int insert(User user)throws Exception;

    /**
     * 更新
     *
     * @param user
     * @return
     */
    public int update(User user)throws Exception;

    /**
     * 删除
     *
     * @param id
     * @return
     */
    public int delete(Long id)throws Exception;


}
