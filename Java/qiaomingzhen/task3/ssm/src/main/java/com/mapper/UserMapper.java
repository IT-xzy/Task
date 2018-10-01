package com.mapper;

import com.model.Page;
import com.model.User;

import java.util.List;

/**
 * @Author qmz
 * @Description
 * @Data 2018/7/4$ 10:33$
 **/
public interface UserMapper {
    void addUser(User user);
    boolean deleteById(User user);
    User selectById(User user);
    int updateTypeById(User user);

    boolean deleteByName(User user);
    int updateTypeByName(User user);
    User selectByName(User user);
    List<User> selectList(User user);
    int total();
    List<User> selectAll(Page page);
    void deleteById1(List<User> list);
}
