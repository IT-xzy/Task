package Dao;

import POJO.User;
import POJO.UserQueryVO;

import java.io.IOException;
import java.util.List;

public interface UserMapperIn {
    public List<User> findUserList(UserQueryVO userQueryVO)throws IOException;
}
