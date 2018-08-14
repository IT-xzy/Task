package mapper;

import model.User;

import java.util.List;

public interface UserMapper {
    //增
    public long addUser(User user);

    //删
    public boolean deleteUser(User user);

    //改
    public boolean updateUser(User user);

    //查
    public User selectUser(User user);

    public List<User> selectUsers(User user);

    //批量插入
    public void addAll(List<User> list);
}
