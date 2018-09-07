package com.jnshu.service.impl;

import com.jnshu.dao.UserMapper;
import com.jnshu.model.User;
import com.jnshu.service.UserService;
import com.jnshu.tools.TestXMemcache;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userDao;

    TestXMemcache memcache = new TestXMemcache();

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
                memcache.SaveMemcache(userDao.selectByName(addInfo.getName()).toString(), addInfo);
            } catch (Exception e) {
                logger.info("缓存失败");
            }
            return "添加成功";
        }
        return "添加失败";
    }

    @Override
    public List<User> getPage(int pageNo, int SHOW_ITEMS) {
        List<User> list;
        List<String> idList = new ArrayList<>();
        try {
            idList = memcache.GetIdMemcache("P" + pageNo + "S" + SHOW_ITEMS);
            logger.info("id缓存大小" + idList.size());
            list = memcache.list(idList);
            logger.info("缓存获取列表" + list.size());
        } catch (Exception e) {
            if (idList.size() != 0) {
                idList = userDao.getId(pageNo, SHOW_ITEMS);
                logger.info("\n数据库获取id列表" + idList.size() + "第一个值" + idList.get(0));
            }
            try {
                list = memcache.list(idList);
                logger.info("\n缓存获取列表" + list.size());
            } catch (Exception f) {
                idList = new ArrayList<>();
                List<String> nextIdList = new ArrayList<>();
                List<User> nextList;
                list = userDao.getPage(pageNo, SHOW_ITEMS);
                for (User ls : list) {
                    memcache.SaveMemcache(ls.getId().toString(), ls);
                    idList.add(ls.getId().toString());
                    logger.info("\n获取缓存失败，存入" + ls.getId());
                }

                nextList = userDao.getPage(pageNo+1,SHOW_ITEMS);
                for (User ls : nextList) {
                    memcache.SaveMemcache(ls.getId().toString(), ls);
                    nextIdList.add(ls.getId().toString());
                    logger.info("获取缓存失败，存入" + ls.getId());
                }
                memcache.SaveMemcache("P" + (pageNo+1) + "S" + SHOW_ITEMS, nextIdList);

            }
        }
        memcache.SaveMemcache("P" + pageNo + "S" + SHOW_ITEMS, idList);
        return list;
    }

    @Override
    public Integer countAll() {
        Integer countAll;
        try {
            countAll = memcache.GetCountMemcache("countAll");
        } catch (Exception e) {
            countAll = userDao.countAll();
            memcache.SaveMemcache("countAll", countAll);
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
                memcache.DelMemcache(String.valueOf(id));
                logger.info("缓存删除成功" + id);
            } catch (Exception e) {
                logger.info("缓存删除失败");
            }
            return "删除成功";
        }
        return "删除失败";
    }

    @Override
    public User findById(int id) {
        User user;
        try {
            user = memcache.GetMemcache(String.valueOf(id));
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
                memcache.SaveMemcache(String.valueOf(id), t,5);
                logger.info("防止穿透，保存空值");
            } else {
                try {
                    memcache.SaveMemcache(String.valueOf(id), user);
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
                memcache.SaveMemcache(addInfo.getId().toString(), addInfo);
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