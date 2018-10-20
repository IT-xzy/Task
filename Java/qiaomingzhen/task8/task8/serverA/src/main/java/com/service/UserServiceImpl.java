package com.service;
/*
 * @ClassName:UserServiceImpl
 * @Description:TODO
 * @Author qiao
 * @Date 2018/8/17 17:35
 **/

import com.mapper.TelCodeMapper;
import com.mapper.UserMapper;
import com.model.Code;
import com.model.People;
import com.util.task7.DayUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userServiceImpl")
public class UserServiceImpl implements UserService {
    private static Logger logger = Logger.getLogger("UserServiceImpl.class");

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private TelCodeMapper telCodeMapper;

    @Override
    public long addUser(People people) {
        return userMapper.addUser(people);
    }

    @Override
    public int selectAll() {
        return userMapper.selectAll();
    }

    @Override
    public void job(People people) {
        userMapper.job(people);
    }

    @Override
    public int findJob() {
        return userMapper.findJob();
    }

    @Override
    public People selectPeople(People people) {
        return userMapper.selectPeople(people);
    }

    @Override
    public List<People> listJob() {
        return userMapper.listJob();
    }

    @Override
    public People login(String user, String password) {

        String ph = "^[1][34578]\\d{9}$";
        String em = "^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*\\.[a-zA-Z0-9]{2,6}$";
        People people = null;

        try {
            if (user.matches(ph)) {
                people = userMapper.selectByTel(Long.valueOf(user));
            } else if (user.matches(em)) {
                people = userMapper.selectByEmail(user);
            } else {
                people = userMapper.selectByName(user);
            }
            System.out.println(people.toString());
            // 数据存在
            if (people.getStatus() == 1) {
                // 数据比对
                logger.info("两次密码对比" + people.getPassword().equals(password));
                if (people.getPassword().equals(password)) {
                    logger.info("数据库" + people.getPassword());
                    logger.info("密码" + password);
                    return people;
                } else {
                    logger.info("登陆失败");
                }
            }
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
        return null;
    }

    @Override
    public People selectByName(String name) {
        return userMapper.selectByName(name);
    }

    @Override
    public People selectById(long id) {
        return userMapper.selectById(id);
    }

    @Override
    public People selectByTel(long tel, String password) {
//        System.out.println("参数" + tel + password);
//        try {
//            People people = userMapper.selectByTel(tel);
//
//            System.out.println(people.toString());
//            // 数据存在
//            if (people.getTel() != null) {
//                // 数据比对
//                if (people.getPassword().equals(password)) {
//                    logger.info("数据库" + people.getPassword());
//                    logger.info("密码" + password);
//                    return people;
//                } else {
//                    logger.info("登陆失败");
//                }
//            }
//        } catch (Exception e) {
//            return null;
//        }
        return null;
    }

    @Override
    public People selectByEmail(String email, String password) {
//        System.out.println("参数" + email + password);
//        try {
//            People people = userMapper.selectByEmail(email);
//
//            System.out.println(people.toString());
//            // 数据存在
//            if (people.getEmail() != null) {
//                // 数据比对
//                logger.info("两次密码对比" + people.getPassword().equals(password));
//                if (people.getPassword().equals(password)) {
//                    logger.info("数据库" + people.getPassword());
//                    logger.info("密码" + password);
//                    return people;
//                } else {
//                    logger.info("登陆失败");
//                }
//            }
//        } catch (Exception e) {
//            return null;
//        }
        return null;
    }

    @Override
    public int updatePeople(People people) {
        return userMapper.updatePeople(people);
    }

    @Override
    public boolean checkTelSum(long tel) {
        logger.info(tel);
        Code code = new Code();
        logger.info(code.toString());
        boolean b = true;

        //数据库根据tel查询
        if (telCodeMapper.findTel(tel) == null) {
            //手机号不存在，新增tel记录，次数为1
            code.setTelSum(1);
            logger.info(code.toString());
            telCodeMapper.addTel(code);
        } else {
            code = telCodeMapper.findTel(tel);
            code.setTel(tel);
            long day = code.getUpdateTime();
            code.setUpdateTime(System.currentTimeMillis());
            int sum = code.getTelSum();
            if (DayUtils.IsToday(day)) {
                //更新时间为当天，次数+1
                if (sum < 3) {
                    //手机号存在，次数小于5
                    code.setTelSum(sum + 1);
                    System.out.println(code.toString());
                    logger.info(code.toString());
                    telCodeMapper.updateSum(code);
                } else {
                    //次数大于5，返回false
                    b = false;
                }
            } else {
                //更新时间不为当天，次数设为1
                code.setTelSum(1);
                System.out.println(code.toString());
                logger.info(code.toString());
                telCodeMapper.updateSum(code);
            }
        }
        return b;
    }

    @Override
    public void checkService() {

    }
}
