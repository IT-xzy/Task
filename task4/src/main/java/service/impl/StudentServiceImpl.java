package service.impl;

import dao.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import pojo.Student;
import service.StudentService;

public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentMapper studentMapper;
    @Override
    public void insertStudent(Student student) throws Exception {
        studentMapper.insertStudent(student);
    }

    @Override
    public void deleteById(Integer id) throws Exception {
        studentMapper.deleteById(id);
    }

    @Override
    public Integer getLearningStudentCount() throws Exception {//累计在线学习学生数
        Integer count =studentMapper.getLearningStudentCount();
        return count;
    }

    @Override
    public Integer getGraduatedStudentCount() throws Exception {
        Integer count= studentMapper.getGraduatedStudentCount();
        return count;
    }

    @Override
    public Student getExcellentStudent(Integer studentNum) throws Exception {
        Student student =studentMapper.getExcellentStudent(studentNum);
        return student;
    }

    @Override
    public Integer getCareerTypeCount(String career) throws Exception {
        Integer count =studentMapper.getCareerTypeCount(career);
        return count;
    }

    @Override
    public void updateStudent(Student student) throws Exception {
        studentMapper.updateStudent(student);
    }

}
