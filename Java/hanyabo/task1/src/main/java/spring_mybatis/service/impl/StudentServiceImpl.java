package spring_mybatis.service.impl;

import model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring_mybatis.mapper.StudentMapper;
import spring_mybatis.service.StudentService;

import java.util.List;


@Service
@Transactional
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentMapper studentMapper;

	public Long addStudent(Student student) {
		studentMapper.insertStudent(student);
		return student.getId();

	}

	public List<Student> getStudentList() {
		List<Student> students = studentMapper.getStudentList();
		return students;
	}

	public Boolean updateStudent(Student student) {
		return studentMapper.updateStudent(student);
	}

	public Boolean deleteStudentById(Long studentId) {
		return studentMapper.deleteStudent(studentId);
	}

	public Student findStudentById(Long id) {
		Student student = studentMapper.findStudentById(id);
		return student;
	}

	public List<Student> findStudentByName(String name) {
		List<Student> students = studentMapper.findStudentByName(name);
		return students;
	}

	public List<Student> findStudentByOnlineId(String OnlineId) {
		List<Student> students = studentMapper.findStudentByOnlineId(OnlineId);
		return students;
	}
}
