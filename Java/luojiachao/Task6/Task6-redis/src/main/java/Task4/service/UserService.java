package Task4.service;


import Task4.pojo.User;

import java.util.List;

public interface UserService{

    void add(User user) throws Exception;

    int findAll();

    int findByStudy() throws Exception;

    int findByWork() throws Exception;

    boolean delete(int id);
    //根据id查询
    User findById(int id) throws Exception;
    //根据姓名模糊查询
    List<User> findByName(String name) throws Exception;

    boolean update(User user) throws Exception;

    void reset() throws Exception;

    List<User> list();

    User findByUsername(String username) throws Exception;
    //用户注册
    void regist(User user);
    //用户登录
    User login(String username) throws Exception;
//    int total();
//
//    List<User> list(Page page);
}