package com.baidu.task8.service;

import com.baidu.task8.dao.StudentMapper;
import com.baidu.task8.pojo.Student;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class StudentServiceImpl implements StudentService1 {
    private static final Log log = LogFactory.getLog(StudentServiceImpl.class);
	@Autowired
	private StudentMapper studentMapper;

	public void saveStudent(Student student) {
		studentMapper.saveStudent(student);
		log.info("调用了service1中的添加学生方法...");
	}
	public void deleteStudentById(int id) {
        studentMapper.deleteStudentById(id);
		log.info("调用了service1中的删除学生方法...");
	}

	public void updateStudent(Student student) {
        studentMapper.updateStudent(student);
		log.info("调用了service1中的更新学生方法...");
	}

	public Student findStudentById(int id) {
		log.info("调用了service1中的查找学生方法...");
		return studentMapper.findStudentById(id);
	}
	public List<Student> findAllStudent() {
		log.info("调用了service1中查找所有学生方法...");
		return studentMapper.findAllStudent();
	}
}
