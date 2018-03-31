package com.ptteng.service.impl;

import com.ptteng.dao.StudentDAO;
import com.ptteng.dao.UserDAO;
import com.ptteng.manager.Redis;
import com.ptteng.pojo.exception.UnacceptableException;
import com.ptteng.pojo.model.Student;
import com.ptteng.pojo.model.User;
import com.ptteng.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

@Service("studentService")
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentDAO studentDAO;
    @Autowired
    UserDAO userDAO;
    @Autowired
    Redis cacheManager;

    @Override
    public boolean updateStudentAvatar(String userName, String url) throws Exception {
        User user = userDAO.findStudentByName(userName);
        Student student = user.getStudent();
        student.setAvatar(url);
        return studentDAO.updateAvatarById(student);
    }

    @Override
    public boolean hasStudentInfo(String userName) throws Exception {
        Long studentId = userDAO.findByName(userName).getStudentId();
        return studentId != null;
    }

    @Override
    public User getStudentInfo(String userName) throws Exception {
        User user = userDAO.findStudentByName(userName);
        if (user == null) {
            throw new UnacceptableException("过期的账号角色");
        }
        return user;
    }

    @Override
    public String addStudentByUser(String userName, String studentName) throws Exception {
        //再次确认用户角色有效
        User user = userDAO.findStudentByName(userName);
        if (user == null) {
            throw new UnacceptableException("过期的账号角色");
        }
        Student student = new Student();
        student.setCreateAt(System.currentTimeMillis());
        student.setStudentName(studentName);
        //这边必须用user的id，而不是name，因为name可以改
        String onlineNumber = "DepeatKK-" + user.getId();
        student.setOnlineNumber(onlineNumber);
        try {
            studentDAO.insertStudent(student);
        } catch (DuplicateKeyException e) {
            throw new UnacceptableException("你已经重新报名，请刷新页面");
        }
        Long studentId = student.getId();
        user.setStudentId(studentId);
        userDAO.addStudentId(user);
        return onlineNumber;
    }

}
