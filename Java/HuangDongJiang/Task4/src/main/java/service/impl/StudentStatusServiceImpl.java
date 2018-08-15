package service.impl;

import dao.StudentStatusMapper;
import org.springframework.stereotype.Service;
import pojo.StudentStatus;
import service.StudentStatusService;

import javax.annotation.Resource;
import java.util.List;


@Service("studentStatusServiceImpl")
public class StudentStatusServiceImpl implements StudentStatusService {
	@Resource
	private StudentStatusMapper studentStatusMapper;
	@Override
	public int queryLearningStudentCount() {
		int learningStudentCount = studentStatusMapper.queryLearningStudentCount();
		return learningStudentCount;
	}

	@Override
	public int queryWorkingStudentCount(String work) {
		int workingStudentCount = studentStatusMapper.queryWorkingStudentCount(work);
		return workingStudentCount;

	}

	@Override
	public List<StudentStatus> queryExcellentStudent() {
		List<StudentStatus> listStudentStatus = studentStatusMapper.queryExcellentStudent();
		return listStudentStatus;
	}
}
