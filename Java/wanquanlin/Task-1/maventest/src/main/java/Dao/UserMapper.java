package Dao;

import POJO.User;
import POJO.User3;

import java.io.IOException;
import java.util.List;

public interface UserMapper {
    public User findUserById(int id) throws IOException;//查询
    public List<User> findUserByname(String name)throws IOException;
    //模糊查询（查询结果不一定只有一个，所以将查询结果放入List集合中。
    public void insertUser(User3 user) throws  Exception;//增加
    public  void deleteUser(int id) throws  Exception;//删除指定id的记录
    public void updateUser(User user) throws Exception;//更改指定id的数据
}
