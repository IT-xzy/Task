package com.task1.service;

import com.task1.dao.UserMapper;
import com.task1.pojo.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

//基于注解
//@Transactional
public class UserMapperService {


    //    注入依赖
    private UserMapper userMapper;

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    //    事务管理基于AspectJ 注解方式
//    @Transactional(rollbackFor=Exception.class)
    public long insert(User user) {
        for (int i = 0; i < 100; i++) {
            userMapper.insert(user);
        }
        return user.getId();
    }

    public boolean delete(long id) {

        return userMapper.deleteById(id);

    }

    public boolean updateById(User user) {
        return userMapper.updateById(user);

    }

    public User selectById(long id) {
        return userMapper.selectById(id);

    }

    public List<User> selectAll() {
        return userMapper.selectAll();
    }

    public List<User> selectByOnlineNum(String onlineNum) {
        return userMapper.selectByOnlineNum(onlineNum);

    }

    public List<User> selectByName(String name) {
        return userMapper.selectByName(name);
    }

    public void insertBatch(List<User> list) {

        userMapper.insertBatch(list);
    }


    public static void main(String[] agrs) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserMapperService userMapperService = (UserMapperService) applicationContext.getBean("userMapperService");





//        批量操作2
        List<User> lst = new ArrayList<User>();
        long t1 = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {


            User user = new User("陈哲铭", "396154482", "JAVA", "2018年5月10日", "无", "java-257", "http://www.jnshu.com/daily/55619?dailyType=others&total=8&page=1&uid=23652&sort=0&orderBy=3",
                    "既然选择来了，那就好好努力吧", "JAVA杨聪聪", "知乎");
            user.setCreateAt(System.currentTimeMillis());
            user.setUpdateAt(System.currentTimeMillis());
//            userMapperService.insert(user);
            lst.add(user);
            if (i % 10000 == 0) {
//                userMapperService.insertBatch(lst);
//
//            }

            }
            userMapperService.insertBatch(lst);
            long t2 = System.currentTimeMillis();
            System.out.print("方法总耗时时间：" + (t2 - t1));


        }

    }
}
