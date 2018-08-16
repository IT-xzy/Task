package com.ssmTest.service;

import com.ssmTest.dao.UserDao;
import com.ssmTest.entity.Page;
import com.ssmTest.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;

    @Override
    public int deleteById(Integer id) {
        return userDao.deleteById(id);
    }

    @Override
    public int insertSelective(User record) {
        return userDao.insertSelective(record);
    }

    @Override
    public User selectById(Integer id) {
        return userDao.selectById(id);
    }

    @Override
    public User loginByUserNameAndPassword(User record) {
        return userDao.loginByUserNameAndPassword(record);
    }

    @Override
    public int updateSelective(User record) {
        return userDao.updateSelective(record);
    }

    @Override
    public List<User> selectUserList() {
        return userDao.selectUserList();
    }

    @Override
    public int selectCount() {
        return userDao.selectCount();
    }

    @Override
    public Page<User> findByPage(int currentPage) {
        HashMap<String,Object> map = new HashMap<String, Object>();
        Page<User> page = new Page<User>();
        //封装当前页数
        page.setCurrPage(currentPage);

        //每页显示的数据条数
        int pageSize = 2;
        page.setPageSize(pageSize);

        //封装总记录数
        int totalCount = userDao.selectCount();
        page.setTotalCount(totalCount);

        //封装总页数
        double tc = totalCount;
        Double num = Math.ceil(tc/pageSize);//向上取整
        page.setTotalPage(num.intValue());//intValue()转化为int类型

        map.put("start",(currentPage-1)*pageSize);
        map.put("size",page.getPageSize());

        //封装每页显示的数据信息
        List<User> lists = userDao.findByPage(map);
        page.setLists(lists);
        return page;
    }
}
