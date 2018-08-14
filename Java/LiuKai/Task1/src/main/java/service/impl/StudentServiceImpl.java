package service.impl;

import mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pojo.Student;
import service.StudentService;


import java.util.List;

@Service
//@Transactional
public class StudentServiceImpl implements StudentService {

    private static ApplicationContext context =new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
    private static StudentMapper studentMapper=context.getBean(StudentMapper.class);

//    main函数中使用自动装配报错
//    @Autowired
//    private StudentMapper studentMapper;

    public long insertStudent(Student student) {
        studentMapper.insertStudent(student);
        return student.getId();
    }

    public boolean deleteStudent(long id) {
        return studentMapper.deleteStudent(id);
    }

    public boolean updateStudent(Student student) {

        return studentMapper.updateStudent(student);
    }

    public Student findById(long id) {
        return this.studentMapper.findById(id);
    }

    public List<Student> findLikeName(String name) {
        return studentMapper.findLikeName(name);
    }

    public void deleteAll() {
         studentMapper.deleteAll();
    }
}
