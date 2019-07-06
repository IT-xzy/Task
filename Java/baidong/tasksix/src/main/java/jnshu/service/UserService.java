package jnshu.service;


import jnshu.entity.User;

import java.util.List;

public interface UserService {
    boolean insert(User User);
    boolean deleteByPrimaryKey(Long id);
    boolean updateByPrimaryKey(User User);
    User selectByPrimaryKey(Long id);
    List<Long> selectAllIds();
    List<User> selectByIdList(List<Long> ids);
List<User> selectAll();

}