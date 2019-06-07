package cn.wp.dao;

import cn.wp.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/** @ClassName: @Description: @Author: 老王 @Date: 2019/6/3 13:25 @Version: 1.0 */
@Repository
public interface UserDao {
  boolean insert(User record);

  Long selectByName(String name);

  List<User> selectAll();

  Long selectByCondition(String name, String password);

  User selectById(Long id);
}
