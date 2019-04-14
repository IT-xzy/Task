package com.ptteng.service.impl;

import com.danga.MemCached.MemCachedClient;
import com.ptteng.dao.UserMapper;
import com.ptteng.model.User;
import com.ptteng.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

/**
 * @ClassName UserServiceImp
 * @Description TODO
 * @Author 孙若飞
 * @Date 2019/2/15  15:49
 * @Version 1.0
 **/

@Service
public class UserServiceImp implements UserService {
    Logger logger = Logger.getLogger(UserServiceImp.class);

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private MemCachedClient memCachedClient;

    /*
     * @Author 孙若飞
     * @Description //插入数据,先插入数据库,然后拿到Id,用Id作为缓存的名字,放入缓存
     * @Date 9:45 2019/2/26
     * @Param [record]
     * @return boolean
     **/
    @Override
    public boolean insert(User record) {
        boolean state = userMapper.insert(record);
        logger.info("插入数据库成功还是失败==========" + state);
        boolean cachState = memCachedClient.set("user" + record.getId(), record);
        logger.info("放入缓存成功还是失败===========" + cachState);
        return state;
    }

    /*
     * @Author 孙若飞
     * @Description //
     * @Date 10:04 2019/2/26
     * @Param [name]
     * @return java.util.List<com.ptteng.model.User>
     **/
    @Override
    public User selectByName(String name) {
        return userMapper.selectByName(name);
    }

    /*
     * @Author 孙若飞
     * @Description //先去数据库里查id,再通过Id去缓存里找,没有的话,就插入缓存中
     * @Date 12:54 2019/2/26
     * @Param
     * @return
     **/

    @Override
    public User  selectByCondition(String name, String password) {

        return  userMapper.selectByCondition(name, password);

    }
    /*
     * @Author 孙若飞
     * @Description //去缓存里取数据,取不到,就去数据库里查,然后放入缓存
     * @Date 14:28 2019/2/26
     * @Param
     * @return
     **/

    @Override
    public User selectById(Long id) {

        User user =(User) memCachedClient.get("user"+id);
        if(ObjectUtils.isEmpty(user)){
            user = userMapper.selectById(id);
            boolean state = memCachedClient.set("user"+id,user);
            System.out.println(user+"qewwwwwwwwwwwwwwwwwwww");
            logger.info("插入与否========="+state);
        }
        return user;
    }

    @Override
    public User selectCodePhone(String code, String phone) {
        return userMapper.selectCodePhone(code,phone);
    }

    @Override
    public User selectCodeMail(String mail, String code) {
        return userMapper.selectCodeMail(mail,code);
    }

    @Override
    public int insertMail(String mail, String phone, String name, String password) {
        return userMapper.insertMail(mail,phone,name,password);
    }


}
