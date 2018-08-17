package com.baidu.service;

import com.baidu.dao.StudentMapper;
import com.baidu.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service("studentService")
public class StudentServiceImpl implements StudentService {

	@Resource(name = "studentMapper")
	private StudentMapper studentMapper;

	public void saveStudent(Student student) {
		studentMapper.saveStudent(student);
	}
	public void deleteStudentById(int id) {
        studentMapper.deleteStudentById(id);
	}

	public void updateStudent(Student student) {
        studentMapper.updateStudent(student);
	}

	public Student findStudentById(int id) {
		Student student = studentMapper.findStudentById(id);
		return student;
	}
	public List<Student> findAllStudent() {
		List<Student> studentList = studentMapper.findAllStudent();
		return studentList;
	}
}
