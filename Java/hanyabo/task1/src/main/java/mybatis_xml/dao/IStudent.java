package mybatis_xml.dao;

import java.util.List;

import model.Student;

public interface IStudent {

	public List<Student> getStudentList();

	public void insertStudent(Student Student);

	public void updateStudent(Student Student);

	public void deleteStudent(Long StudentId);

	public Student getStudent(Long id);
}
