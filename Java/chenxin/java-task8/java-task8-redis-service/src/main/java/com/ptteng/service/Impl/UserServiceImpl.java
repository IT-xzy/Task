package com.ptteng.service.Impl;

import com.ptteng.dao.UserDao;
import com.ptteng.model.Login;
import com.ptteng.model.User;
import com.ptteng.service.UserService;
import com.ptteng.util.MD5CipherTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "userServiceImpl")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    //注册
    @Override
    public boolean register(User user) throws Exception {

        return userDao.saveUser(user);
    }

    //用户身份验证
    @Override
    public long validateUser(Login login) throws Exception{
        List<User> users = userDao.getUserByName(login.getUsername());
        users.size();
        System.out.println("users.size:"+users.size());
        if (users.size() != 0){
            for (User user : users) {
                if (user.getUsername().equals(login.getUsername()) && user.getPassword().equals(login.getPassword())) {
                    return user.getId();
                }
            }
        }
        return  0;
    }
    @Override
    public List<User> getUserByName(String name) throws Exception{
        List<User> userList = userDao.getUserByName(name);
        return userList;
    }
    @Override
    public User getUserById(long id) throws Exception{
        return userDao.getUserById(id);
    }
    //更新密码
    @Override
    public boolean updatePassword(User user) throws Exception {
        return userDao.updateUser(user);
    }
    //注销用户
    @Override
    public boolean deleteUser(User user) throws Exception {
        return userDao.deleteUserById(user.getId());
    }

    @Override
    //注册查询是否已存在相同用户名用户
    public boolean isExist(User user) throws Exception{
        //通过用户提交的信息的得到用户名，以此查找数据库
        List<User> userList =getUserByName(user.getUsername());
        //注册查询结果
        boolean result =false;
        //查找数据库结果，根据集合大小粗判断是否存在相同用户
        if (userList.size() >0){
            for (User user1 : userList){
                //遍历查询结果，查看是否相同
                if (!result){
                    if (user.getUsername().equals(user1.getUsername())){
                        System.out.println("test****");
                        System.out.println(user1);
                        result = true;
                    }else {
                        result = false;
                    }
                }else {
                    result = true;
                }
            }
        }else {
            result=false;
        }
        return result;
    }
    @Override
    public boolean update(User user) throws Exception{
        return userDao.updateUser(user);
    }
}
