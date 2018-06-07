
package com.ptteng.service.Impl;

import com.ptteng.dao.UserMapper;
import com.ptteng.entity.User;
import com.ptteng.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.List;

@Service
public class UserServiceImpl implements UserService, Serializable {
    @Resource
    private UserMapper userMapper;
    private static Logger logger= Logger.getLogger("MyMain.class");

    public List<User> getAll() throws RemoteException {
        logger.info("查询全部");
        List userList = this.userMapper.getAll();
        return userList;
    }

}

