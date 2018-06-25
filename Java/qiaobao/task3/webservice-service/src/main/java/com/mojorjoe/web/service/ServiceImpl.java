package com.mojorjoe.web.service;

import com.mojorjoe.web.dao.StudentDAO;
import com.mojorjoe.web.exception.StudentException;
import com.mojorjoe.web.pojo.PageBean;
import com.mojorjoe.web.pojo.Student;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ServiceImpl implements StudentService {

    @Autowired
    StudentDAO studentDAO;

    private Logger logger= Logger.getLogger(ServiceImpl.class);

    public long saveStudent(Student student) throws Exception {

        student.setCreateTime(System.currentTimeMillis());
        try{
            studentDAO.saveStudent(student);
        }catch (DuplicateKeyException e){
            logger.info("姓名重复："+student.getName());
            throw new StudentException("姓名重复");
        }
        return student.getId();

    }

    public boolean deleteStudent(long id) throws Exception {
        return studentDAO.deleteStudent(id);
    }

    public Student selectStudent(long id) throws Exception {
        return studentDAO.selectStudent(id);
    }

    public List<Student> selectByName(String name) throws Exception {
        return studentDAO.selectByName(name);
    }

    public boolean updateStudent(Student student) throws Exception {

        student.setUpdateTime(System.currentTimeMillis());
        try{
            studentDAO.updateStudent(student);
        }catch (DuplicateKeyException e){
            logger.info("更新姓名重复"+student.getName());
            throw new StudentException("更新姓名重复");
        }
        return studentDAO.updateStudent(student);
    }

    public PageBean pageListStudent(long pageNum,int pageSize) throws Exception {

        long totalRecord =studentDAO.totalStudent();
        PageBean pageBean =new PageBean(pageSize,totalRecord,pageNum);
        pageBean.setList(studentDAO.pageListStudent(pageBean));
        return pageBean;
    }
}
