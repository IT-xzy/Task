package task7.service;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import task7.dao.UserDao;
import task7.pojo.User;
import task7.util.ApplicationException;
import task7.util.MD5Utils;

import javax.annotation.Resource;

@Service
public class UserServiceImpl extends UserServiceImplImpl   implements UserService {
    private static Logger logger =Logger.getLogger(UserServiceImpl.class);
    @Resource(name = "userDao")
    private UserDao userDao;

    //实现接口，重写register方法
    @Override
    public String register(User user) {

        logger.info("进入regiser()");
        user.setPassword(MD5Utils.getSaltMD5(user.getPassword()));
        logger.info("传入的参数："+user);
        //在业务层的方法是经过controller验证的，所以直接用
        //调用的dao层保存数据的方法
        Integer i =userDao.saveUser(user);
        //对返回值进行验证
        if(i>0){
            logger.info("注册成功");
            return "注册成功";
        }else {
            logger.info("注册失败，请重新注册！");
            return "注册失败";
        }
    }

    //登录验证
    @Override
    public User loginCheck(String adminCode, String password) {
        logger.info("进入loginCheck()");
        logger.info("账号："+adminCode+"密码："+password);
        //调用dao层的方法，查询是否有这条账号的信息
        User user=null;
        user =userDao.queryUser(adminCode);
        //对查询出来的结果进行判断
        if(user==null){
            logger.info("账号输入错误，请重新输入！");
            throw new ApplicationException("账号输入错误，请重新输入！");
        }
        logger.info(user);
        //先对传入的字符串进行md5加盐,然后判断两个字符串是不是同一个值。
        logger.info(user.getPassword());
        logger.info("--------------------------------------------");
        if (!MD5Utils.getSaltverifyMD5(password,user.getPassword())){
            logger.info("密码错误请重新输入！");
            throw  new ApplicationException("密码错误请重新输入！");
        }
        logger.info("密码正确！");
        return user;
    }
}
