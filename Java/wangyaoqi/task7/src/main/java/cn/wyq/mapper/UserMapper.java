package cn.wyq.mapper;

import cn.wyq.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    void addUser(User user);
    User findUserByNameAndPwd(@Param("userName")String userName, @Param("password")String password);
    User findUserByNameAndPhone(@Param("userName")String userName, @Param("telephone")String telephone);
    User findUserByNameAndEmail(@Param("userName")String userName, @Param("email")String email);
    User findUserName(String userName);
    User findPhone(String telephone);
    User findEmail(String email);
    User getSalt(String userName);
}
