package com.dao;

import com.pojo.User;
import org.apache.ibatis.annotations.*;

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
    @Select("select * from stu where id=#{id}")
    public User getUser(Long id)throws Exception;

    /**
     * 通过name、number查找
     *
     * @param name
     * @param number
     * @return
     */
    @Select("select * from stu where name=#{name} and number=#{number}")
    public User getUserByCondition(@Param("name") String name, @Param("number") int number)throws Exception;

    /**
     *查找全表
     * @param
     * @return
     */
    @Select("select * from stu")
    public List<User> getAllUsers()throws Exception;

    /**
     * 模糊查询
     * @param name
     * @return
     */
    @Select("SELECT * FROM stu WHERE name LIKE #{name}")
    public List<User> selectByName(@Param("name") String name)throws Exception;
    /**
     *添加
     * @paramUser
     * @return
     *
     */
    @Insert("insert into stu (id,createAt,updateAt,name,qq,job,startTime,college,number,dailyUrl,wish,brother,referee,city,review)values(#{id},#{createAt},#{updateAt},#{name},#{qq},#{job},#{startTime},#{college},#{number},#{dailyUrl},#{wish},#{brother},#{referee},#{city},#{review})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    public long insert(User user)throws Exception;
    /**
     *更新
     * @param user
     * @return
     */
    @Update("update stu set name=#{name},qq=#{qq} where id=#{id}")
    public int update(User user)throws Exception;
    /**
     *删除
     * @param id
     * @return
     */
    @Delete("delete from stu where id=#{id}")
    public int deleteById(Long id)throws Exception;
}