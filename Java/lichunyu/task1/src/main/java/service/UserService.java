package service;

import pojo.User;

import java.util.List;

/**
 * 业务层进行判断CRUD是否成功
 * 添加数据返回ID，删除或更新数据返回True/False
 */

public interface UserService{
    int insert(User user);
    int delete(int id);
    User select(int id);
    List<User> selectByName(String name);
    int update(User user);


    //    添加数据后返回id
    int returnId(User user) ;

//        删除数据后返回True/False
    boolean isDelete(int id);

//         更新数据后返回True/False
    boolean isUpdate(User user);
}
