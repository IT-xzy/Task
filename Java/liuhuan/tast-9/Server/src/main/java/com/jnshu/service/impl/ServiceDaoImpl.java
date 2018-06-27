package com.jnshu.service.impl;

import com.jnshu.mapper.ProfessionDao;
import com.jnshu.mapper.StudentDao;
import com.jnshu.mapper.UserAuthDao;
import com.jnshu.model.*;
import com.jnshu.service.ServiceDao;
import com.whalin.MemCached.MemCachedClient;
import org.oasisopen.sca.annotation.Remotable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: smsdemo
 * @description: Service实现
 * @author: Mr.xweiba
 * @create: 2018-05-29 23:32
 **/
@Service
@Remotable
public class ServiceDaoImpl implements ServiceDao {
    private static Logger logger = LoggerFactory.getLogger(ServiceDaoImpl.class);
    @Autowired
    StudentDao studentDao;

    @Autowired
    ProfessionDao professionDao;

    @Autowired
    UserAuthDao userAuthDao;

    @Autowired
    MemCachedClient memCachedClient;

    @Override
    public List<StudentCustom> findListStudent(StudentQV studentQV) throws Exception {
        // 复杂查询不使用缓存
        if (studentQV.getStudentCustom() != null) {
            return studentDao.findStudentCustomMore(studentQV);
        }
        // 输出所有
        StudentList studentList = new StudentList();
        Object object = memCachedClient.get("studentAll");
        if (object != null) {
            logger.debug("缓存输出");
            studentList = (StudentList) object;
            return studentList.getStudentList();
        }
        List<StudentCustom> studentCustomList = studentDao.findStudentCustomMore(studentQV);
        studentList.setStudentList(studentCustomList);
        memCachedClient.set("studentAll", studentList);
        return studentCustomList;
    }

    @Override
    public StudentCustom findStudentCustomById(Integer id) throws Exception {
        // 缓存
        StudentCustom studentCustom = (StudentCustom) memCachedClient.get("student" + id);
        if (studentCustom != null) {
            logger.debug("studentId缓存输出");
            return studentCustom;
        }
        studentCustom = studentDao.findStudentCustomById(id);
        memCachedClient.set("student" + id, studentCustom);
        return studentCustom;
    }

    @Override
    public Integer insertStudent(StudentCustom studentCustom) throws Exception {
        studentCustom.setCreate_time(System.currentTimeMillis());
        memCachedClient.delete("studentAll");
        logger.debug("studentId  studentAll 缓存已清空");
        return studentDao.insertStudentCustom(studentCustom);
    }

    @Override
    public boolean deleteStudent(Integer id) throws Exception {
        if (studentDao.deleteStudentCustom(id)) {
            memCachedClient.delete("student" + id);
            memCachedClient.delete("studentAll");
            logger.debug("studentId  studentAll 缓存已清空");
            return true;
        }
        return false;
    }

    @Override
    public boolean updateStudent(StudentCustom studentCustom) throws Exception {
        studentCustom.setUpdate_time(System.currentTimeMillis());
        if (studentDao.updateStudentCustom(studentCustom)) {
            memCachedClient.delete("student" + studentCustom.getId());
            memCachedClient.delete("studentAll");
            logger.debug("studentId  studentAll 缓存已清空");
            return true;
        }
        return false;
    }

    @Override
    public boolean updateEmail(StudentCustom studentCustom) throws Exception {
        if (studentDao.updateEmail(studentCustom)) {
            memCachedClient.delete("student" + studentCustom.getId());
            memCachedClient.delete("studentAll");
            logger.debug("studentId  studentAll 缓存已清空");
            return true;
        }
        return false;
    }

    @Override
    public boolean updateTelephone(Integer id, String telePhone) throws Exception {
        if (studentDao.updateTelephone(id, telePhone)) {
            memCachedClient.delete("student" + id);
            memCachedClient.delete("studentAll");
            logger.debug("studentId  studentAll 缓存已清空");
            return true;
        }
        return false;
    }

    @Override
    public Integer countStudent() throws Exception {
        return studentDao.countStudent();
    }

    @Override
    public Integer countWorkStundet() throws Exception {
        return studentDao.countWork();
    }

    @Override
    public List<Profession> findByListProfession() throws Exception {
        return professionDao.findByListProfession();
    }

    @Override
    public Integer userAuth(UserAuth userAuth) throws Exception {
        return userAuthDao.userAuth(userAuth);
    }

    @Override
    public Boolean findUserAuthByid(Integer id) throws Exception {
        return userAuthDao.findUserAuthByid(id);
    }
}
