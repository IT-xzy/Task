package com.task1.mybatis.dao;

import com.task1.mybatis.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Dao {


    /**
     * 查询表数据的方法
     */
    public User lookupId(int id);

    /**
     * 删除表数据的方法
     */
    public boolean delete(Integer id);

    /**
     * 更新表数据的方法
     */
    public boolean update(@Param("id") Integer id, @Param("qq") String qq);
    public List<User> selectAll();
    public int countAll();
    /**
     * 插入表数据的方法
     */
    public void insert(User user);
    /**
     * 根据名字查询表数据
     */
    public User lookupName(String name);

    /**
     * 根据学号查询表数据
     */
    public User lookupNum(String student_num);
}
