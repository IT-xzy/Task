
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
    @Autowired
    private UserMapperStudent userMapperStudent;
    private Logger logger = Logger.getLogger("UserServiceStudentImpl");

    public UserStudent selectUser(int id)  {
        return userMapperStudent.selectUser(id);
    }

    public void insertUser(UserStudent user) {
        userMapperStudent.insertUser(user);
    }

    public boolean updateUser(UserStudent user) {
        return userMapperStudent.updateUser(user);
    }

    public boolean deleteUser(int id) {
        return userMapperStudent.deleteUser(id);
    }

    public List<UserStudent> getAll() {
        List userList = this.userMapperStudent.getAll();
        return userList;
    }
}

