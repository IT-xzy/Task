package com.ptteng.service.Impl;

import com.ptteng.dao.SignUserDao;
import com.ptteng.model.SignedUser;
import com.ptteng.service.SignUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//用来获取已经报名的用户的用户名，姓名和所报的课程。
@Service
public class SignUserServiceImpl implements SignUserService{

    @Autowired
    SignUserDao signUserDao;

    @Override
    public List<SignedUser> get() throws Exception {
        return signUserDao.get();
    }

    //通过用户的id获得signUserDao，将信息填入到个人页面中。
    @Override
    public SignedUser getById(long id) throws Exception {
        return signUserDao.getById(id);
    }
}
