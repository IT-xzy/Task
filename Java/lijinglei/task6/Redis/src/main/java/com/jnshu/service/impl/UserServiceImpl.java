package com.jnshu.service.impl;

import com.jnshu.dao.UserMapper;
import com.jnshu.model.User;
import com.jnshu.service.UserService;
import com.jnshu.tools.Redis;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userDao;

    Redis cache = new Redis();

    private Logger logger = Logger.getLogger(UserServiceImpl.class);

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
            try {
                cache.setCacheObject(userDao.selectByName(addInfo.getName()).toString(), addInfo);
            } catch (Exception e) {
                logger.info("缓存失败");
            }
            return "添加成功";
        }
        return "添加失败";
    }

    @Override
    public List<User> getPage(int pageNo, int SHOW_ITEMS) throws Exception {
        Object list;
        List<String> idList;
        idList = cache.getCacheList("P" + pageNo + "S" + SHOW_ITEMS);
        list = cache.getCacheList(idList);
        if (list.getClass().getName().equals("java.lang.Integer")) {
            switch ((Integer) list) {
                case 0:
                    logger.info("重新从数据库取所有数据" + list);
                    idList = new ArrayList<>();
                    list = userDao.getPage(pageNo, SHOW_ITEMS + 5);
                    logger.info(((List<User>) list).size());
                    int i = 0;
                    for ( User user : (List<User>) list) {
                        cache.setCacheObject(user.getId().toString(), user);
                        logger.info(user.getName());
                        if (i < SHOW_ITEMS) {
                            idList.add(String.valueOf(user.getId()));
                            logger.info("获取缓存失败，存入" + user.getId());
                            i++;
                        }

                    }
                    list = ((List<User>) list).subList(0, i);
                    break;

                case 1:
                    idList = userDao.getId(pageNo, SHOW_ITEMS);
                    logger.info("重新从数据库取id" + idList.size());
                    list = cache.getCacheList(idList);
                    if (list.getClass().getName().equals("java.lang.Integer")) {
                        if ((Integer) list == 0 | (Integer) list == 1) {
                            idList = new ArrayList<>();
                            list = userDao.getPage(pageNo, SHOW_ITEMS + 5);
                            logger.info(((List<User>) list).size());
                            int j = 0;
                            for (User user : (List<User>) list) {
                                cache.setCacheObject(user.getId().toString(), user);
                                logger.info(user.getName());
                                if (j < SHOW_ITEMS) {
                                    j++;
                                    idList.add(String.valueOf(user.getId()));
                                    logger.info("获取缓存失败，存入" + user.getId());
                                }

                            }
                            list = ((List<User>) list).subList(0, j);
                        }
                    }
                    break;
            }
        }
        cache.setCacheList("P" + pageNo + "S" + SHOW_ITEMS, idList);
        logger.info("存入idList");
        return (List<User>) list;
    }

    @Override
    public Integer countAll() throws Exception {
        Integer countAll;
        countAll = cache.getCacheObject("countAll");
        if (countAll == null) {
            countAll = userDao.countAll();
            cache.setCacheObject("countAll", countAll);
        }
        return countAll;
    }

    @Override
    public Integer findByName(String name) {
        return userDao.selectByName(name);
    }

    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }

    @Override
    public String delete(int id) {
        if (userDao.deleteByPrimaryKey(id) == 1) {

            try {
                cache.delCache(String.valueOf(id));
                logger.info("\n缓存删除成功" + id);
            } catch (Exception e) {
                logger.info("\n缓存删除失败");
            }
            return "删除成功";
        }
        return "删除失败";
    }

    @Override
    public User findById(int id) throws Exception {
        User user;
        try {
            user = cache.getCacheObject(String.valueOf(id));
            logger.info("获取缓存" + id);
            if ("非法id".equals(user.getName())) {
                logger.info(user.getName());
                return user;
            }
        } catch (Exception e) {
            user = userDao.selectByPrimaryKey(id);
            logger.info("从数据库获取" + id);
            if (user == null) {
                User t = new User();
                t.setName("非法id");
                cache.setCacheObject(String.valueOf(id), t,5);
                logger.info("防止穿透，保存空值");
            } else {
                try {
                    cache.setCacheObject(String.valueOf(id), user);
                    logger.info("存入缓存" + id);
                } catch (Exception f) {
                    logger.info("缓存失败");
                }
            }
        }
        return user;
    }

    @Override
    public String update(User addInfo) {
        if (userDao.updateByPrimaryKeySelective(addInfo) == 1) {
            try {
                cache.setCacheObject(addInfo.getId().toString(), addInfo);
                logger.info("修改缓存成功");
            } catch (Exception e) {
                logger.info("修改缓存失败");
            }
            return "更新成功";
        }
        return "更新失败";
    }

    @Override
    public User login(User user) {
        return userDao.selectByIdAndName(user);
    }
}