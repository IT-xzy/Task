package mapper;

import pojo.User;

import java.sql.ResultSet;

public interface UserMapper {

    void insert(User user);

    User getbyname(String name);

    boolean getname(String name);

}
