package com.xiaobo.demo.dao;
import java.util.List;
import com.xiaobo.demo.entity.User;
import org.springframework.stereotype.Repository;
@Repository
public interface UserDao {
    public List<User> getAll(User user);
    public  User getUserById(Integer id);
    public Integer addUser(User user);
    public Boolean deleteUser(Integer id);
    public Boolean updateUser(User user);
}
