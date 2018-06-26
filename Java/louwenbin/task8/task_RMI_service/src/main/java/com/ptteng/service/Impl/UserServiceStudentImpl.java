
package com.ptteng.service.Impl;

import com.ptteng.dao.UserMapperStudent;
import com.ptteng.entity.UserStudent;
import com.ptteng.service.UserServiceStudent;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceStudentImpl implements UserServiceStudent {
    private static Logger logger= Logger.getLogger(UserServiceStudentImpl.class);

    @Autowired
    private UserMapperStudent userMapperStudent;

    public UserStudent selectUser(int id){
        logger.info("根据ID查询");
        return userMapperStudent.selectUser(id);
    }

    public void insertUser(UserStudent user) {
        logger.info("插入全表");
        userMapperStudent.insertUser(user);
    }

    public boolean updateUser(UserStudent user) {
        logger.info("更新全表");
        return userMapperStudent.updateUser(user);
    }

    public boolean deleteUser(int id) {
        logger.info("根据id删除");
        return userMapperStudent.deleteUser(id);
    }

    public List<UserStudent> getAll() {
        logger.info("查询全表");
        return userMapperStudent.getAll();
    }
}

