package task2.mapper;

import org.apache.ibatis.annotations.Param;
import task2.pojo.User;

public interface UserMapper {
    public void addUser(User user);

    public User findUserByName(@Param("username")String username, @Param("password")String password);


}
