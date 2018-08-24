package com.Dao;

import com.model.Login;
import com.memcached.Cached;
import com.model.Student;
import com.model.StudentCustom;
import com.model.zhiwei;

import java.util.List;

/**
 * @author baich
 */
public interface StudentDao  {
    //任务四
    List<Student> findAll(int id);

    List<zhiwei> findAlls();

    int findName();

    zhiwei addlist(zhiwei zhi);

    //任务五
    Login login(String username);

    void findTime(Login login);

    //任务六
    Cached findUserById(int id);

    List<Cached> findAllId();

    void updateById(Cached cached);

    //任务七
    void addStudent(Student student);
    Login findstudentID(int studentID);
    //邮件的发送

    void insertData(Login login);
    Login findemail(String email);
    void updateState(Login login);
    void deleteEmail(String email);


// 存储的迁移
    boolean updateStudent(StudentCustom studentCustom);
}
