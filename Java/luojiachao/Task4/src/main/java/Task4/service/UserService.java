package Task4.service;


import Task4.pojo.User;

import java.util.List;

public interface UserService{

    void add(User user) throws Exception;

    int findAll();

    int findByStudy();

    int findByWork();

    boolean delete(int id);
    //根据id查询
    User findById(int id);
    //根据姓名模糊查询
    List<User> findByName(String name) throws Exception;

    boolean update(User user) throws Exception;

    void reset() throws Exception;

    List<User> list();

//    int total();
//
//    List<User> list(Page page);
}