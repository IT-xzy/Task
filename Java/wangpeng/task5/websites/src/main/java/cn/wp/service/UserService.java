package cn.wp.service;

import cn.wp.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName: UserService
 * @Description:
 * @Author: 老王
 * @Date: 2019/5/23 12:38
 * @Version: 1.0
 */
public interface UserService {

    int insert(User record);

    List<User> selectByName(String name);

    User selectByCondition(@Param("name") String name, @Param("password") String password);

    User selectById(Long id);
}
