package wyq.webapp.mapper;

import org.apache.ibatis.annotations.Param;
import wyq.webapp.pojo.User;

public interface UserMapper {
    void addUser(User user);
    User findUserByNameAndPwd(@Param("userName")String userName,@Param("password")String password);
    User findUserName(String userName);
    User getSalt(String userName);
}
