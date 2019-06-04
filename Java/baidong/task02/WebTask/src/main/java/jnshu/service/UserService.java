package jnshu.service;

import jnshu.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;
public interface UserService {
    int add(User user);
    int update(User user);
    List<User> findAll();
    int delete(int id);
    User findById(int id);
    List<User> selectPage(@Param("startNum") int start, @Param("pageSize") int pageSize);
    int selectCount();
}
