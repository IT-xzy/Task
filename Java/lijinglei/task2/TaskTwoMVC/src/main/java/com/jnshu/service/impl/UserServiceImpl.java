package com.jnshu.service.impl;

import com.jnshu.dao.UserMapper;
import com.jnshu.model.User;
import com.jnshu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("userService")
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userDao;
    public UserMapper getUserMapper() {
        return userDao;
    }
    public void setUserMapper(UserMapper userDao) {
        this.userDao = userDao;
    }

    //表示一个方法声明的目的是覆盖父类方法声明。如果一个方法是注释，该注释类型但不重写基类方法，编译器必须生成一个错误消息。
    @Override
    public String addInfo(User addInfo) {
        if (userDao.insertSelective(addInfo) == 1) {
            return "添加成功";
        }
        return "添加失败";
    }
    @Override
    public List<User> getPage(int pageNo, int SHOW_ITEMS) {
        return userDao.getPage(pageNo, SHOW_ITEMS);
    }
    @Override
    public int countAll() {
        return userDao.countAll();
    }

    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }
    @Override
    public String delete(int id) {
        if (userDao.deleteByPrimaryKey(id) == 1) {
            return "删除成功";
        }
        return "删除失败";
    }
    @Override
    public User findById(int id) {
        return userDao.selectByPrimaryKey(id);
    }
    @Override
    public String update(User addInfo) {
        if (userDao.updateByPrimaryKeySelective(addInfo) == 1) {
            return "更新成功";
        }
        return "更新失败";
    }
   @Override
    public User login(User user) {
        return userDao.selectByIdAndName(user);
    }
}