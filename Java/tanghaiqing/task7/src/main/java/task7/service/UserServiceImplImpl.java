package task7.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import task7.dao.UserDao;
import task7.pojo.User;
import task7.pojo.UserImpl;
import task7.util.OSSClientUtil;
import task7.util.RedisUtil;


import javax.annotation.Resource;

@Service
public class UserServiceImplImpl implements UserService1 {
    private static Logger logger = Logger.getLogger(UserServiceImplImpl.class);
    @Resource(name ="redisUtil")
    private RedisUtil redisUtil;
    @Resource(name = "userDao")
    private UserDao userDao;
    @Value("${address}")
    private String value;

    public UserImpl queryUserService(Integer id) {
        logger.info("进入queryUserService()");
        UserImpl user = userDao.queryUser1(id);
        if (user.getImage() != null) {
            logger.info("有头像。显示图片");
            String url = (String)redisUtil.get("address")+user.getImage();
            user.setImage(url);
        }
        logger.info("User数据：" + user);
        return user;
    }

    @Override
    public void updateUserService(User user) {
        logger.info("进入业务层方法：updateUserService()");
         userDao.updateUser(user);
    }
}
