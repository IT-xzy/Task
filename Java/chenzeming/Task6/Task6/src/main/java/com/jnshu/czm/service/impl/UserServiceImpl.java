package com.jnshu.czm.service.impl;

import com.jnshu.czm.dao.UserDao;
import com.jnshu.czm.model.PageBean;
import com.jnshu.czm.model.User;
import com.jnshu.czm.service.UserService;
import net.rubyeye.xmemcached.MemcachedClient;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;


@Service("userService")
public class UserServiceImpl implements UserService {


    private static org.slf4j.Logger logger= LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserService userService;

    @Autowired
    private MemcachedClient memcachedClient;

    @Override
    //添加用户
    public void insertUser(User user)throws Exception{
        userDao.insertUser(user);
        boolean insert=false;
        insert = memcachedClient.set(String.valueOf(user.getId()), 0, userService.findUserById(user.getId()));
        logger.info("\n" + "是否有新增的缓存：" + insert);
        if (insert){
            memcachedClient.delete("userList");
            logger.info("\n" +"因添加操作删除了列表以获得最新列表");
        }
    }


    @Override
    //删除用户
    public boolean deleteUserById(int id)throws Exception {
        boolean delete=false;
        if (memcachedClient.get(String.valueOf(id)) != null) {
            delete = memcachedClient.delete(String.valueOf(id));
            logger.info("\n" + "是否删除缓存数据：" + delete);
        }else {
            logger.info("\n" + "没有此条数据可以删除：");
        }
        if (delete){
            memcachedClient.delete("userList");
            logger.info("\n" +"因删除操作删除了列表以获得最新列表");
        }
        return userDao.deleteUserById(id);
    }

    //修改用户
    @Override
    public boolean updateUser(User user)throws Exception {

        boolean update=false;
        if(memcachedClient.get(String.valueOf(user.getId()))!=null) {
            update = memcachedClient.replace(String.valueOf(user.getId()), 0, user);
            logger.info("\n" + "是否修改缓存数据：" + update);
        }else {
            logger.info("\n" + "没有此条数据可以修改：");
        }
        if (update){
            memcachedClient.delete("userList");
            logger.info("\n" +"因修改操作删除了列表以获得最新列表");
        }
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
    public List<User> findAll()throws Exception {

        List<User> userList = memcachedClient.get("userList");
        try {
            if (userList !=null){
                logger.info("\n"+"从缓存中查询所有");
                //userList =memcachedClient.get("userList");
            }else {
                logger.info("\n"+"从数据库中查询所有");
                userList=userDao.findAll();
                boolean list=memcachedClient.set("userList",0,userList);
                logger.info("\n"+"新增所有数据缓存:"+list);
            }
        }catch (Throwable t){
            t.printStackTrace();
        }
        return userList;
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