package com.serviceImpl;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import com.service.UserService;
import com.pojo.User;
import com.dao.UserDao;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * 实现类
 *
 * @author Administrator
 */
public class UserServiceImpl implements UserService {

    private Logger logger = Logger.getLogger(UserServiceImpl.class);

    /**
     * 读取mybatis配置文件，并读取成文字流形式（InputStream）
     */
    String resource = "mybaits-config.xml";
    InputStream inputStream;

    {
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 将读取后的参数交给SqlSessionFactory进行节点读取
     */
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    SqlSession session = sqlSessionFactory.openSession();
    UserDao mapper = session.getMapper(UserDao.class);

    /**
     * 插入
     */

    @Override

    public Long insert(User user) throws Exception {
        mapper.insert(user);
        session.commit();
        session.close();
        logger.info("插入数据" + user.getId() + "成功");
        return user.getId();
    }

    /**
     * 删除
     */
    @Override

    public boolean deleteById(Long id)throws Exception {
        boolean flag = false;
        int a = mapper.deleteById(id);
        session.commit();
        session.close();
        try {
            if (a != 0) {
                flag = true;
                logger.info("删除" + flag);
            } else {
                logger.info("删除" + flag);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 更新
     */
    @Override

    public boolean update(User user)throws Exception {
        boolean flag = false;
        int a = mapper.update(user);
        session.commit();
        session.close();
        try {

            if (a != 0) {
                flag = true;
                logger.info("修改" + flag);
            } else {
                logger.info("修改" + flag);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 通过ID查询
     */
    @Override

    public User getUser(Long id) throws Exception {
        User u = new User();
        u = mapper.getUser(id);
        session.commit();
        session.close();
        logger.info("id=" + u.getId() + ",CreateAt=" + u.getCreateAt() + ",UpdateAt=" + u.getUpdateAt() + ",Name=" + u.getName() + ",Qq=" + u.getQq()
                + ",Job=" + u.getJob() + ",StartTime=" + u.getStartTime() + ",College=" + u.getCollege() + ",Number=" + u.getNumber() + ",DailyUrl=" + u.getDailyUrl() + ",Wish=" +
                u.getWish() + ",Brother=" + u.getBrother() + ",Referee=" + u.getReferee() + ",City=" + u.getCity() + ",Review" + u.getReview());
        return u;
    }

    /**
     * 条件查找
     *
     * @param name
     * @param number
     * @return
     */
    @Override
    public User getUserByCondition(String name, int number) throws Exception {
        User u = new User();
        u = mapper.getUserByCondition(name, number);
        session.commit();
        session.close();
        logger.info(u);
        return u;
    }

    /**
     * 查询全表
     */
    @Override

    public List<User> getAllUsers() throws Exception {
        User u = new User();
        List<User> users = mapper.getAllUsers();
        session.commit();
        session.close();
        for (User user : users) {
            logger.info(user);
        }
        return users;
    }

    /**
     * 模糊查询
     */
    @Override

    public List<User> selectByName(String name) throws Exception {
        User u = new User();
        List<User> users = mapper.selectByName(name);
        session.commit();
        session.close();
        for (User user : users) {
            logger.info(user);
        }
        return users;
    }
}
