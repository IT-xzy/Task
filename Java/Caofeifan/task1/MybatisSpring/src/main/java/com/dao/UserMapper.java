package com.dao;

import com.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Dao接口
 * @author Administrator
 */
public interface UserMapper {
    /**
     * 查找全表
     *
     * @return
     */
    @Select("select * from stu")
    public List<User> findAll()throws Exception;

    /**
     * 模糊查询
     *
     * @param name
     * @return
     */
    @Select("SELECT * FROM stu WHERE name LIKE #{name}")
    public List<User> selectByName(@Param("name") String name)throws Exception;

    /**
     * 通过ID查询
     *
     * @param id
     * @return
     */
    @Select("select * from stu where id=#{id}")
    public List<User> findById(Long id)throws Exception;

    /**
     * 通过条件查询
     * @param name
     * @param number
     * @returnn
     */
    @Select("select * from stu where name=#{name} and number=#{number}")
    public List<User> findByCondition(@Param("name") String name, @Param("number") int number)throws Exception;

    /**
     * 插入
     *
     * @param user
     * @return
     */
    @Insert("insert into stu(id,createAt,updateAt,name,qq,job,startTime,college,number,dailyUrl,wish,brother,referee,city,review)\n" +
            "             values(#{id},#{createAt},#{updateAt},#{name},#{qq},#{job},#{startTime},#{college},#{number},#{dailyUrl},#{wish},#{brother},#{referee},#{city},#{review}) ")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    public int add(User user)throws Exception;

    /**
     * 删除
     */
    @Delete("delete from stu where id=#{id}")
    public int deleteById(long id)throws Exception;

    /**
     * 更新
     *
     * @param user
     * @return
     */
    @Update("update stu set name=#{name},qq=#{qq} where id=#{id}")
    public int update(User user)throws Exception;
}


