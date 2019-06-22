package cn.wp.service.impl;

import cn.wp.dao.UserDao;
import cn.wp.model.User;
import cn.wp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/** @ClassName: @Description: @Author: 老王 @Date: 2019/5/23 12:38 @Version: 1.0 */
@Service
public class UserServiceImpl implements UserService {

  @Autowired UserDao userDao;

  @Override
  public boolean insert(User record) {
    return userDao.insert(record);
  }

  @Override
  public User selectByName(String name) {
    return userDao.selectByName(name);
  }

  @Override
  public User selectByCondition(String name, String password) {
    return userDao.selectByCondition(name, password);
  }

  @Override
  public User selectById(Long id) {
    return userDao.selectById(id);
  }

  @Override
  public User selectCodePhone(String phone, String code) {
    return userDao.selectCodePhone(phone, code);
  }

  @Override
  public User selectCodeMail(String mail, String code) {
    return userDao.selectCodeMail(mail, code);
  }

  @Override
  public int insertMail(String name, String password, String phone, String mail) {
    return userDao.insertMail(name, password, phone, mail);
  }
}
