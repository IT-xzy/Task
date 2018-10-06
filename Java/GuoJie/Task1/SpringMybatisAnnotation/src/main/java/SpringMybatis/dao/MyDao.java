package SpringMybatis.dao;

import SpringMybatis.User;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface MyDao {
    public User findById(int id);
    List<User> findAll();
    public void insertUser(User user);
}
