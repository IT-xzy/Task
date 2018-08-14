package com.service.impl;

import com.Plug.PageBean;
import com.mapper.UserMapper;
import com.pojo.User;
import com.service.UserService;
import com.tool.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    public UserMapper userMapper;
    //变动标志位
    private boolean change=false;

    @Override
    //添加一个用户
    public boolean addUser(User user) {
        if(userMapper.insertUser(user)!=0){
            RedisUtils.addObject(""+user.getId(),user);
            change=false;
            return true;
        }
        return false;
    }

    //减少一个用户
    @Override
    public boolean cutUserById(long id) {
        if(userMapper.deleteUserById(id) != 0){
            RedisUtils.delKey(""+id);
            change=false;
            return true;
        }
        return false;
    }

    @Override
    //更新一个用户
    public boolean reviseUserById(User user) {
        if(userMapper.updateUserById(user) != 0){
            RedisUtils.delKey(""+user.getId());
            change=false;
            return true;
        }
        return false;
    }

    @Override
    //查询一个用户
    public User queryUserById(long id) {
        User user=(User)RedisUtils.getObject(""+id,User.class);
        if(user==null){
            user=userMapper.selectUserById(id);
            RedisUtils.addObject(""+id,user);
        }
        return user;
    }

    //查询所有用户
    @Override
    public List<User> queryUser() {
        return userMapper.selectUser();
    }

    //分页
    public PageBean findAllUserWithPage(int pageNum,int pageSize){
        PageBean pageBean=(PageBean) RedisUtils.getObject("page"+pageNum,PageBean.class);
        if(!change||pageBean==null){
            System.out.println("进入");
            //在这里要将pageBean中的数据创建好，然后将该对象传回去
            //先要从数据库中获取所有用户的数据量有多少，获得totalRecord
            List<User> allUser = userMapper.selectUser();
            //获得总记录数
            int totalRecord = allUser.size();
            //有了三个初始数据，将能够创建PageBean对象了
            pageBean = new PageBean(pageNum, pageSize, totalRecord);

            System.out.println(RedisUtils.addObject(""+pageNum,pageBean));

            int totalPage=pageBean.getTotalPage();
            for(int pageNumNew=1;pageNumNew<=totalPage;pageNumNew++) {
                System.out.println(pageNumNew);
                PageBean pageBeanNow = new PageBean(pageNumNew, pageSize, totalRecord);
                //获取pageBean对象中的starIndex
                int starIndex = pageBeanNow.getStartIndex();
                System.out.println(starIndex);
                //有了starIndex和pageSize,就可以拿到每页的数据了
                List<User> list = userMapper.selectPage(starIndex, pageSize);
                pageBeanNow.setList(list);
                boolean o=RedisUtils.addObject("page" + pageNumNew, pageBeanNow);
                System.out.println(o);
                change = true;
            }
        }else{
            return pageBean;
        }
        pageBean=(PageBean) RedisUtils.getObject("page"+pageNum,PageBean.class);
        return pageBean;
    }


}
