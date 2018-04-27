/**   
 * @Title: StudentService.java 
 * @Package com.detective.service 
 * @Description: TODO
 * @author detective
 * @date 2018年3月20日 下午10:58:11 
 * @version V1.0   
 */
package spring_mybatis.service;

import java.util.List;

import model.Student;

/**
 * @ClassName: StudentService
 * @Description: TODO
 * @author detective
 * @date 2018年3月20日 下午10:58:11
 * 
 */
public interface StudentService {
	public Long addStudent(Student student);

	public List<Student> getStudentList();

	public Boolean updateStudent(Student student);

	public Boolean deleteStudentById(Long studentId);

	public Student findStudentById(Long id);

	public List<Student> findStudentByName(String name);

	public List<Student> findStudentByOnlineId(String name);
}
