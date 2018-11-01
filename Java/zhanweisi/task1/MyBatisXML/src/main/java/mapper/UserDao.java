package mapper;

import pojo.User;

import java.util.List;

/**
 * @author Weisi Zhan
 * @create 2018-10-23 17:04
 **/
public interface UserDao {
    public User selectUserById(int id) throws Exception;

    public void insertUser(User user) throws Exception;

    public void updateUserById(int id) throws Exception;

    public void deleteUserById(int id) throws Exception;

    public List<User> selectUserAll() throws Exception;

    public List<User> selectLikeUserName() throws Exception;
}
