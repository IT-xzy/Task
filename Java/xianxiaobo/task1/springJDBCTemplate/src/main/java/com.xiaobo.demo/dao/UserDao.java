package com.xiaobo.demo.dao;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.List;
import java.util.Map;
import com.xiaobo.demo.dto.User;
public interface UserDao {
    public List<User> getAll();
    public  User getUserById(Integer id);
    public Integer addUser(User user);
    public Boolean deleteUser(Integer id);
    public Boolean updateUser(User user);
}
