package com.service.impl;

import com.Dao.StudentDao;
import com.Xmemcached.MemcacheUtils;
import com.model.Login;
import com.model.Memcached;
import com.model.Student;
import com.model.zhiwei;
import com.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentDao studentDao;

    //任务四
    @Override
    public List<Student> findAll() {
        return studentDao.findAll();
    }

    @Override
    public List<zhiwei> findAlls() {
        return studentDao.findAlls();
    }

    @Override
    public int findName() {
        return studentDao.findName();
    }

    @Override
    public zhiwei addlist(zhiwei zhi) {
        return studentDao.addlist(zhi);
    }

    //任务五
    @Override
    public Login login() {
        return studentDao.login();
    }

    @Override
    public void findTime(Login login) {
        studentDao.findTime(login);
    }

    // 任务六
    @Override
    public Memcached findUserById(int id) {
        Object object = MemcacheUtils.get("xiu" + id);
        if (object != null) {
            return (Memcached) object;
        }
        Memcached memcached = studentDao.findUserById(id);
        MemcacheUtils.set("user" + id, memcached);
        return memcached;

    }
}
