package service;

import dao.mapper.StudentAnnotationMapper;
import model.Student;

import java.util.List;

/*
* mybatis注解操作数据库
*
* Service实现类
*
* 返回Mapper的映射方法
*
* */

public class StudentAnnotationServiceImpl implements StudentAnnotationService {


    private StudentAnnotationMapper studentAnnotationMapper;

    public StudentAnnotationMapper getStudentAnnotationMapper() {
        return studentAnnotationMapper;
    }

    public void setStudentAnnotationMapper(StudentAnnotationMapper studentAnnotationMapper) {
        this.studentAnnotationMapper = studentAnnotationMapper;
    }

    @Override
    public Student selectById(int id) {
        return studentAnnotationMapper.selectById(id);
    }

    @Override
    public int insertOne(Student student) {
        return studentAnnotationMapper.insertOne(student);
    }

    @Override
    public List<Student> findByStudent(Student student) {
        return  studentAnnotationMapper.findByStudent(student);
    }

    @Override
    public int insertList(List<Student> students) {
        return  studentAnnotationMapper.insertList(students);
    }


}
