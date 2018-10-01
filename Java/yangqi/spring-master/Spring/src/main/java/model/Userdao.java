package model;

import po.User;

import java.util.List;
//dao 接口
public interface Userdao {

    User getUserById(int id);//查询
    boolean getinsertUser(User user);//插入
    boolean deleteId(int id);//删除
    List<User> findAllId();//查询全部id
    boolean UpdateUser(User user);//更新
    User findName(User user);//根据姓名查询

}
