package lujing.service;

import java.util.List;

import lujing.pojo.StudentCustom;
import lujing.pojo.StudentQueryVo;

public interface StudentService {
	/**
	 * 自定义查询条件
	 */
	public List<StudentCustom> findStudentList(StudentQueryVo studentQueryVo);

	//查询学生信息
	public StudentCustom findStudentById(Long id );
	
	//更新学生信息
	
	public void updateStudent(Long id,StudentCustom studentCustom);
	
	//删除学生信息
	
	public void deleteStudent(Long id);
	
	//新增学生信息
	public void addStudent(StudentCustom studentCustom);
	
	
	
}
