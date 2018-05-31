package jdbc.dao;

import java.util.List;
import java.util.Map;

import model.Student;

public interface StudentDao {
	public void addStudent(Student student) throws Exception;

	public void updateStudent(Student student) throws Exception;

	public void delStudent(Long id) throws Exception;

	public List<Student> query() throws Exception;

	public List<Student> query(String name) throws Exception;

	public List<Student> query(List<Map<String, Object>> params)
			throws Exception;

	public abstract Student getStudent(Long id) throws Exception;

}
