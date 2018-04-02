package lujing.serviceimpl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lujing.mapper.StudentMapper;
import lujing.mapper.StudentMapperCustom;
import lujing.pojo.Student;
import lujing.pojo.StudentCustom;
import lujing.pojo.StudentQueryVo;
import lujing.service.StudentService;
@Service
public class StudentServiceImpl implements StudentService {
@Autowired
private StudentMapperCustom studentMapperCustom ;

	@Override
	public List<StudentCustom> findStudentList(StudentQueryVo studentQueryVo) {
		// TODO Auto-generated method stub
		return studentMapperCustom.findStudentList(studentQueryVo);
		
		
	}
    @Autowired
    private StudentMapper studentMapper;
	@Override
	public StudentCustom findStudentById(Long id) {
		
		Student student = studentMapper.selectByPrimaryKey(id);
		StudentCustom studentCustom = new StudentCustom();
		BeanUtils.copyProperties(student, studentCustom);
		return studentCustom;
	}

	@Override
	public void updateStudent(Long id,StudentCustom studentCustom) {
	    
		studentMapper.updateByPrimaryKeySelective(studentCustom);
		
	}

	@Override
	public void deleteStudent(Long id) {
		studentMapper.deleteByPrimaryKey(id);
		
	}

	@Override
	public void addStudent(StudentCustom studentCustom) {
		// TODO Auto-generated method stub
		studentMapper.insertSelective(studentCustom);
	}

}
