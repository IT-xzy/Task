package service;

import pojo.StudentStatus;

import java.util.List;

public interface StudentStatusService {
	/**
	 * 查询在线学习人数
	 * @return
	 */
	int queryLearningStudentCount();

	/**
	 * 查询找到工作学生人数
	 * @return
	 */
	int queryWorkingStudentCount();

	/**
	 * 查询优秀学员
	 * @return
	 */
	List<StudentStatus> queryExcellentStudent();
}
