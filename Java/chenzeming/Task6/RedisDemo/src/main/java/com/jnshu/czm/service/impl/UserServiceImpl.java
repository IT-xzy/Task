package com.jnshu.czm.service.impl;

import com.jnshu.czm.dao.UserDao;
import com.jnshu.czm.model.PageBean;
import com.jnshu.czm.model.User;
import com.jnshu.czm.service.UserService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;


@Service("userService")
public class UserServiceImpl implements UserService {


    private static org.slf4j.Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserService userService;

    @Autowired
    private RedisTemplate redisTemplate;

//    ValueOperations<String, Object> valueOperations = redisTemplate.opsForValue();

    @Override
    //添加用户
    public boolean insertUser(User user) {
        //userDao.insertUser(user);
        boolean insert = userDao.insertUser(user);
        try {
            if (insert) {
                redisTemplate.opsForValue().set(String.valueOf(user.getId()), userService.findUserById(user.getId()));
                redisTemplate.delete(String.valueOf("userList"));
                logger.info("\n" + "已添加数据到缓存");
            } else {
                logger.info("\n" + "没有添加数据到缓存");
            }
        } catch (Throwable t) {
            t.printStackTrace();
        }
        return insert;
    }


    @Override
    //删除用户
    public boolean deleteUserById(int id) {

        boolean delete = userDao.deleteUserById(id);
        try {
            if (delete) {
                if (redisTemplate.opsForValue().get(String.valueOf(id)) != null) {
                    redisTemplate.delete(String.valueOf(id));
                    redisTemplate.delete(String.valueOf("userList"));
                    logger.info("\n" + "已从缓存删除");
                } else {
                    logger.info("\n" + "没有此条数据可以删除：");
                }
            }
        } catch (Throwable t) {
            t.printStackTrace();
        }
        return delete;
    }

    //修改用户
    @Override
    public boolean updateUser(User user) {

        boolean update = userDao.updateUser(user);
        try {
            if (update) {
                if (redisTemplate.opsForValue().get(String.valueOf(user.getId())) != null) {
                    redisTemplate.opsForValue().set(String.valueOf(user.getId()), user);
                    logger.info("\n" + "修改了缓存数据");
                } else {
                    logger.info("\n" + "没有此条数据可以修改：");
                }
            }
        } catch (Throwable t) {
            t.printStackTrace();
        }
        return update;
    }

    @Override
    //单条查询
    public User findUserById(int userId) {
        ValueOperations<String, Object> vos = redisTemplate.opsForValue();

        User user = null;
        if ("".equals(vos.get(String.valueOf(userId)))){

//            (redisTemplate.opsForValue().get(String.valueOf(userId))==null)
            logger.info("\n从缓存返回空值");
            return user;
        }

        try {

            if (vos.get(String.valueOf(userId)) != null) {
                logger.info("\n" + "从缓存中查询单条数据");
                user = (User) vos.get(String.valueOf(userId));
            } else {
                logger.info("\n" + "从数据库中查询单条数据");
                user = userDao.findUserById(userId);
                if (user != null) {
                    vos.set(String.valueOf(userId), user);
                    logger.info("\n" + "新增单条缓存数据:" + vos.get(String.valueOf(userId)));
                } else {
                    vos.set(String.valueOf(userId),"", 60,TimeUnit.SECONDS);
                    logger.info("\n" + "将空值存到缓存");
                }
            }
        } catch (Throwable t) {
            t.printStackTrace();
        }
        return user;


    }



    //查询全部
    @Override
    public List<User> findAll() {

        List<User> userList = (List<User>) redisTemplate.opsForValue().get("userList");
        try {
            if (userList != null) {
                logger.info("\n" + "从缓存中查询所有");
            } else {
                logger.info("\n" + "从数据库中查询所有");
                userList = userDao.findAll();
                redisTemplate.opsForValue().set("userList", userList);
                logger.info("\n" + "新增缓存数据:" + redisTemplate.opsForValue().get("userList"));
            }
        } catch (Throwable t) {
            t.printStackTrace();
        }
        return userList;
    }

    //查询记录条数
    @Override
    public int selectCount() {
        return userDao.selectCount();
    }


    //分页
    @Override
    public PageBean<User> findByPage(int currentPage) {
        HashMap<String, Object> map = new HashMap<>();
        PageBean<User> pageBean = new PageBean<>();

        //封装当前页数
        pageBean.setCurrPage(currentPage);

        //每页显示的数据
        int pageSize = 5;
        pageBean.setPageSize(pageSize);

        //封装总记录数
        int totalCount = userDao.selectCount();
        pageBean.setTotalCount(totalCount);

        //封装总页数
        double tc = totalCount;
        Double num = Math.ceil(tc / pageSize);//向上取整
        pageBean.setTotalPage(num.intValue());

        map.put("start", (currentPage - 1) * pageSize);
        map.put("size", pageBean.getPageSize());
        //封装每页显示的数据
        List<User> lists = userDao.findByPage(map);
        pageBean.setLists(lists);

        return pageBean;
    }

}

//        ValueOperations<String, Object> vos = redisTemplate.opsForValue();
//
//        User user = null;
//        try {
//
//            logger.info("判断缓存是否为空字符串"+("".equals(vos.get(String.valueOf(userId)))));
//            if ("".equals(vos.get(String.valueOf(userId)))) {
//                logger.info("返回空值");
//                return user;
//            }
//
//            if (vos.get(String.valueOf(userId)) != null) {
//                user = (User) vos.get(String.valueOf(userId));
//                logger.info("读取单个缓存数据>>>" + user);
//            } else {
//                user =userDao.findUserById(userId);
//                logger.info("查DB得到的数据：" + user);
//                if (user != null) {
//                    vos.set(String.valueOf(userId), user);
//                    logger.info("添加缓存数据：" + vos.get(String.valueOf(userId)));
//                } else {
//                    vos.set(String.valueOf(userId),"",60, TimeUnit.SECONDS);
//                    logger.info("将空值插入缓存，设置短暂过期时间");
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return user;