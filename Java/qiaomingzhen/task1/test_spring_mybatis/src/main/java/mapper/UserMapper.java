package mapper;

import model.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserMapper {

    /*
    * 注解的方式:
    * 删除applicationContext.xml文件中的<property name="mapperLocations" value="classpath:UserMapper.xml"/>
    * */
    //增
//    @Insert("insert into user (name ,qq,type) values (#{name},#{qq},#{type})")
    public Long addUser(User user);

    //批量插入
    public Long addAll(List<User> list);

    //查询id
//    @Select("select id from user where name=#{name}")
    public Long findNewId(User user);

    //删
//    @Delete("delete from user where id=#{id}")
    public boolean deleteUser(User user);

    //改
//    @Update(" update user set type=#{type} where name=#{name}")
    public boolean updateUser(User user);

    //通过name查询用户信息
//    @Select("select * from user where name=#{name}")
    public User selectName(User user);

    public List<User> selectUser(User user);
}
