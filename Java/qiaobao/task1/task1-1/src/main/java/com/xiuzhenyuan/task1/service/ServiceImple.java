package com.xiuzhenyuan.task1.service;

import com.xiuzhenyuan.task1.dao.StudentDAO;
import com.xiuzhenyuan.task1.model.StudentDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service("serviceImple")
public class ServiceImple implements StudentService {

//注解自动装配studentDAO对象
    @Autowired
    StudentDAO studentDAO;

    @Override
//    存储student信息，录入系统时间到createTime，不开放端口
    public int saveStudent(String name,int qq,String dailyLink,int entorTime,String graduateSchool,
                           int netId,String senior,String type,String wish ) {
        StudentDO studentDO = new StudentDO(name,qq,dailyLink,entorTime,graduateSchool,netId,senior,type,wish,System.currentTimeMillis());
        studentDAO.saveStudent(studentDO);
        int primaryKey =studentDO.getAddId();
        return primaryKey;
    }

    @Override
//    根据主键id查询用户信息
    public StudentDO getStudent(int addId){
        return studentDAO.getStudent(addId);
    }

    @Override
//    根据主键id更新type字段，可以通过添加构造函数增加更新字段，录入系统时间到updateTime，不开放端口
    public boolean updateStudent(int addId, String type) {
        StudentDO studentDO=new StudentDO(addId,type,System.currentTimeMillis());
        return studentDAO.updateStudent(studentDO);
    }

    @Override
//    根据主键id删除student信息
    public boolean deleteStudentByAddId(int addId) {
        return studentDAO.deleteStudentByAddId(addId);
    }

    @Override
//    根据name和netId模糊查询
    public List<StudentDO> selectLikeNameNetId(String name,int netId){
        StudentDO studentDO=new StudentDO(name,netId);
        return studentDAO.selectLikeNameNetId(studentDO);
    }

//    批量插入数据
    @Override
    public int studentBatchInsert(List<StudentDO> studentDO) {
        return studentDAO.studentBatchInsert(studentDO);
    }

}
