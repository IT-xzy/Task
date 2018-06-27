package mybatis.service;

import java.util.List;


import mybatis.modle.User;


public interface UserService {

    int add(User user) throws Exception;

    boolean delete(int id);
    //根据id查询
    User findById(int id);
    //根据姓名模糊查询
    List<User> findByName(String name) throws Exception;

    boolean update(User user) throws Exception;

    void reset() throws Exception;

}

