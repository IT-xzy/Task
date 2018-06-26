package cn.dao;      // dao层 与映射文件对应
import cn.User.User;

import java.util.List;

public interface UserDao {
    public User getUserById(int id);

    public User getinsertUser(User user);

    public boolean deleteId(int id);
    public List<User> findAllId();
    public boolean UpdateUser(User user);
    public User findname(User user);

}
