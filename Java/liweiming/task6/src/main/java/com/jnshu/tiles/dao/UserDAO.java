package com.jnshu.tiles.dao;


import com.jnshu.tiles.entity.User;
import java.util.List;

public interface UserDAO {

        //    获取所有信息

        List<User> getAllUser()throws Exception;
        //    根据id获得对象信息

        User getUserById(int id) throws Exception;

        List<User> getUserMore(User user)throws Exception;
        //    添加信息

         boolean addUser(User user)throws Exception;
        //    根据id删除信息

        boolean deleteUser(int id)throws Exception;
        //    更新信息

         boolean updateUser(User user)throws Exception;



}
