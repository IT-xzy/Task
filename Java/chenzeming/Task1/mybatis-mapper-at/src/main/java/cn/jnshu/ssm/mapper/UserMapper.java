package cn.jnshu.ssm.mapper;

import cn.jnshu.ssm.po.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    //根据id查询用户
    @Select("select * from user where id=#{id}")
    public User findUserById(int id) throws Exception;

    //删除用户
    @Delete("delete from user where id=#{id}")
    public boolean deleteUser(int id) throws Exception;

    //添加用户信息
    @Insert("insert into user(id,username) value (#{id},#{username})")
    public boolean insertUser(User user) throws Exception;

    //模糊查询用户信息
    @Select(" select * from user where username like '%${value}%'")
    public List<User> findUserName(String username) throws Exception;

    //查询全部用户
    @Select("select * from user")
    public List<User> findAll()throws Exception;

    //更改信息
    @Update("update user set id=#{id},username=#{username} where id=#{id}")
    public int updateUser(User user)throws Exception;
}
