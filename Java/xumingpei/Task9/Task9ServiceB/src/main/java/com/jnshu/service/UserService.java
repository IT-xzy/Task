package com.jnshu.service;

import com.jnshu.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.oasisopen.sca.annotation.Remotable;

import java.util.List;

/**
 * @author pipiretrak
 * @date 2019/4/3 - 2:12
 */

@Remotable
public interface UserService {
    int insert(User record);
    User selectById(Long id);
    List<User> selectByName(String name);
    List<User>  selectByNameAndPassword(@Param("name") String name, @Param("password") String password);
}
