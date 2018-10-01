
package com.service.Impl;

import com.dao.UserMapper;
import com.entity.User;
import com.entity.User2;
import com.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    //查询所有优秀学员信息
    public List<User> getAll() {
        List userList = this.userMapper.getAll();
        return userList;
    }

//    查询4个优秀学员信息展示
public List<User> limit() {
    List userList = this.userMapper.limit();
    return userList;
}

}

