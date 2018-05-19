/*
定义了mapper查询接口
 */
package spring_mybatis.mapper;

import model.Student;

import java.util.List;


public interface StudentMapper {
	List<Student> getStudentList();

	Long insertStudent(Student student);

	Boolean updateStudent(Student student);

	Boolean deleteStudent(Long id);

	Student findStudentById(Long id);

	List<Student> findStudentByName(String name);

	List<Student> findStudentByOnlineId(String name);
}
