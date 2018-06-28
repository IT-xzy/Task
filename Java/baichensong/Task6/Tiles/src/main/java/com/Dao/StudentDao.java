package com.Dao;

import com.model.Login;
import com.Xmemcached.Cached;
import com.model.Student;
import com.model.zhiwei;

import java.util.List;

public interface StudentDao {
    //任务四
    List<Student> findAll();

    List<zhiwei> findAlls();

    int findName();

    zhiwei addlist(zhiwei zhi);

    //任务五
    Login login();

    void findTime(Login login);

    //任务六
    Cached findUserById(int id);

    List<Cached> findAllId();

    void updateById(Cached cached);

}
