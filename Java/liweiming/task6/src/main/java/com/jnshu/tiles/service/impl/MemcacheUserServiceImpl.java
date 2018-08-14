package com.jnshu.tiles.service.impl;


import com.jnshu.tiles.dao.UserDAO;

import com.jnshu.tiles.entity.User;
import com.jnshu.tiles.service.UserService;
import com.jnshu.tiles.tools.JedisCache;
import com.jnshu.tiles.tools.MemcachedUtils;
import org.apache.commons.lang.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemcacheUserServiceImpl implements UserService {

    @Autowired
    UserDAO userDAO;
    @Autowired
    JedisCache jedisCache;

    @Override
    public List<User> getAllUser() throws Exception {
        return userDAO.getAllUser();
    }

    @Override
    public User getUserById(int id)throws Exception{
        //查找缓存
        Object object = MemcachedUtils.get("user"+ id);
        //当存在缓存时，直接返回缓存数据
        if (object != null){
            return (User) object;
        }
        User user=userDAO.getUserById(id);
        //缓存为空，则添加缓存
        MemcachedUtils.set("user"+id,user);
        return user;
    }


    @Override
    public List<User> getUserMore(User user) throws Exception {
        return userDAO.getUserMore(user);
    }

    @Override
//    保存用户
    public int saveUser(User user) throws Exception {
       //插入成功后返回的值存入user的id中
       userDAO.addUser(user);
       //写入缓存，这里是哟个add当key（id）存在时，不写入缓存
        MemcachedUtils.add("user"+user.getId(),user);
       //返回user的id值
        return user.getId();
    }

    @Override
    public boolean deleteUser(int id) throws Exception {
        //删除缓存
        MemcachedUtils.delete(String.valueOf(id));
        return userDAO.deleteUser(id);
    }

    @Override
    public boolean updateUser(int id,User user) throws Exception {
        user.setId(id);
        //写入缓存，使用replace
        MemcachedUtils.replace("user"+id,user);
        return userDAO.updateUser(user);
    }

}