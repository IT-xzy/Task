package com.service;

import com.model.Login;
import com.model.Memcached;
import com.model.Student;
import com.model.zhiwei;

import java.util.List;

public interface StudentService {

    List<Student> findAll();
    List<zhiwei> findAlls();

    int findName();
   zhiwei addlist(zhiwei zhi);
   Login login();

   void findTime(Login login);

   //任务六
    Memcached findUserById(int id);
}
