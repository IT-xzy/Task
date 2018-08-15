package service;

import po.User;

import java.util.List;


//业务层接口
public interface UserService {
    User findUserById(int id);//查询id

    boolean insertUser(User user);//插入

    boolean deleteUser(int id);//删除用户

    List<User> AllId();//查询全部

    boolean updateUser(User user);//更新

    User findName(User user);//模糊查询
}
