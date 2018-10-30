package myBatis;

import java.util.List;

public interface UserMapper {
    public User findUserById(long id);

    public List<User> findAll();

    public boolean deleteUser(long id);

    public long addUser(User user);

    public boolean updateUser(User user);
}
