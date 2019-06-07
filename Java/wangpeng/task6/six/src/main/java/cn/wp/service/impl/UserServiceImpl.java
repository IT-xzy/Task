package cn.wp.service.impl;

import cn.wp.dao.UserDao;
import cn.wp.entity.User;
import cn.wp.service.UserService;
import com.danga.MemCached.MemCachedClient;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

/** @ClassName: @Description: @Author: 老王 @Date: 2019/6/3 13:18 @Version: 1.0 */
@Service("UserService")
public class UserServiceImpl implements UserService {
  Logger logger = Logger.getLogger(UserServiceImpl.class);

  @Autowired private UserDao userDao;
  @Autowired private MemCachedClient memCachedClient;
  /**
   * @Author: wp @Description: 插入数据,先插入数据库,然后拿到Id,用Id作为缓存的名字,放入缓存 @Param:
   *
   * @return: @Exception: @Date: 2019/6/5 0:23
   */
  @Override
  public boolean insert(User record) {
    boolean state = userDao.insert(record);
    logger.info("插入数据库成功还是失败==========" + state);
    boolean cachState = memCachedClient.set("user" + record.getId(), record);
    logger.info("放入缓存成功还是失败===========" + cachState);
    return state;
  }
  /**
   * @Author: wp @Description: 先去数据库里通过名字查id,通过名字查Id,通过id去缓存里取,如果缓存里没有,就插入这条数据, @Param:
   *
   * @return: @Exception: @Date: 2019/6/5 0:23
   */
  @Override
  public Long selectByName(String name) {
    // 取出数据库id
    Long dbId = userDao.selectByName(name);
    // 去缓存里通过id取数据
    List<User> users = (List<User>) memCachedClient.get("user" + dbId);
    if (ObjectUtils.isEmpty(users)) {
      boolean state = memCachedClient.set("user" + dbId, users);
      logger.info("放入缓存了没有==========" + state);
    }
    return dbId;
  }
  /**
   * @Author: wp @Description: 先去数据库里查id,再通过Id去缓存里找,没有的话,就插入缓存中 @Param:
   *
   * @return: @Exception: @Date: 2019/6/5 0:24
   */
  @Override
  public Long selectByCondition(String name, String password) {
    Long dbId = userDao.selectByCondition(name, password);

    User users = (User) memCachedClient.get("user" + dbId);
    if (ObjectUtils.isEmpty(users)) {
      boolean state = memCachedClient.set("user" + dbId, users);
      logger.info("放入缓存了没有a ==============" + state);
    }
    return dbId;
  }
  /**
   * @Author: wp @Description: (根据id去查找)去缓存里取数据,取不到,就去数据库里查,然后放入缓存 @Param:
   *
   * @return: @Exception: @Date: 2019/6/5 0:24
   */
  @Override
  public User selectById(Long id) {

    User user = (User) memCachedClient.get("user" + id);
    if (ObjectUtils.isEmpty(user)) {
      user = userDao.selectById(id);
      boolean state = memCachedClient.set("user" + id, user);
      logger.info("插入与否=========" + state);
    }
    return user;
  }

  @Override
  public List<User> selectAll() {
    Object object = memCachedClient.get("user");
    if (object != null) {
      logger.info("从缓存里取=============");
      return (List<User>) object;
    } else {
      logger.info("从数据库里取++++++++++++++++++");
      List<User> users = userDao.selectAll();
      boolean state = memCachedClient.set("user", users);
      logger.info("设置了没====================" + state);
      return users;
    }
  }
}
