package com.ptteng.service.ServiceImpl;

import com.ptteng.CahcheUtil.CacheDao;
import com.ptteng.dao.UserDao;
import com.ptteng.entity.User;
import com.ptteng.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {
    static Logger logger=Logger.getLogger(UserServiceImpl.class);
    @Autowired
    private UserDao userDao;
    @Autowired
    @Qualifier("RedisImpl")
    private CacheDao cacheDao;


    @Override
    public Long insertUser(User user) {
        user.setUpdateAt(System.currentTimeMillis());
        user.setCreateAt(System.currentTimeMillis());
        userDao.insertUser(user);
        Long id=user.getId();
        logger.info("注册用户返回主键id"+id);
        String key=String.valueOf(id)+"user";
        Boolean flag=cacheDao.set(key,user);
        logger.info("注册用户后将用户信息放入缓存中是否成功"+flag);
        return id;
    }

    @Override
    public User findById(Long id) {
        User user;
        String key=String.valueOf(id)+"user";
        user= (User) cacheDao.get(key);
        logger.info("从缓存中获取单条信息"+user);
        if(user==null){
            user=userDao.findById(id);
            logger.info("从数据库查询的数据"+user);
            Boolean flag=cacheDao.set(key,user);
            logger.info("将数据放入缓存中是否成功"+flag);
        }
       return user;

    }

    @Override
    public Boolean updateUser(User user) {
        user.setUpdateAt(System.currentTimeMillis());
        Long id=user.getId();
        Boolean flag1=userDao.updateUser(user);
        logger.info("修改数据库=="+flag1);
        String key=String.valueOf(id)+"user";
//        Boolean
//        因为修改数据，这里的入参不一定就是这个用户的所有数据，
//        想要修改缓存中信息的话，还要再查询一次，所以直接将缓存中的删除
        if(cacheDao.get(key)!=null){
            Boolean flag2=cacheDao.delete(key);
            logger.info("修改数据后删除缓存"+flag2);
        }
        return flag1;
    }

    @Override
    public Boolean deleteUser(Long id) {
        Boolean flag1=userDao.deleteUser(id);
        String key=String.valueOf(id)+"user";
        logger.info("删除用户信息是否成功"+flag1);
        if(cacheDao.get(key)!=null){
            Boolean flag2=cacheDao.delete(key);
            logger.info("输出数据时输出缓存是否成功"+flag2);
        }
        return flag1;
    }


}
