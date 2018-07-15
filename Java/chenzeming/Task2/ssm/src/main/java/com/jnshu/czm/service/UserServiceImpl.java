package com.jnshu.czm.service;

import com.jnshu.czm.dao.UserDao;
import com.jnshu.czm.model.PageBean;
import com.jnshu.czm.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;


@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


    @Override
    //添加用户
    public void insertUser(User user) {
        userDao.insertUser(user);
    }


    @Override
    //删除用户
    public boolean deleteUserById(int id) {
        return userDao.deleteUserById(id);
    }

   //修改用户
    @Override
    public boolean updateUser(User user) {
        return userDao.updateUser(user);

    }

    @Override
    //单条查询
    public User findUserById(int userId) {
        User user = userDao.findUserById(userId);
        return user;
    }


    //查询全部
    @Override
    public List<User> findAll() {
        List<User> user = userDao.findAll();
        return user;
    }

    //查询记录条数
    @Override
    public int selectCount(){
        return userDao.selectCount();
    }


    //分页
    @Override
    public PageBean<User> findByPage(int currentPage){
        HashMap<String,Object> map = new HashMap<>();
        PageBean<User> pageBean = new PageBean<>();

        //封装当前页数
        pageBean.setCurrPage(currentPage);

        //每页显示的数据
        int pageSize=5;
        pageBean.setPageSize(pageSize);

        //封装总记录数
        int totalCount = userDao.selectCount();
        pageBean.setTotalCount(totalCount);

        //封装总页数
        double tc = totalCount;
        Double num =Math.ceil(tc/pageSize);//向上取整
        pageBean.setTotalPage(num.intValue());

        map.put("start",(currentPage-1)*pageSize);
        map.put("size", pageBean.getPageSize());
        //封装每页显示的数据
        List<User> lists = userDao.findByPage(map);
        pageBean.setLists(lists);

        return pageBean;
    }

}

