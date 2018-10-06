package SpringMybatis.service;

import SpringMybatis.User;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;



public interface MySevice {
    public User findById(int id);
    List<User> findAll();
    public void insertUser(User user);
}
