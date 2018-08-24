package task.service.serviceImp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import task.dao.StudentDao;
import task.pojo.Student;
import task.service.StudentService;

import java.util.List;

@Service
public class StudentServiceImp implements StudentService
{
    @Autowired
    private StudentDao studentDao;
    public int insertStudent(Student student)
    {
        return studentDao.insertStudent(student);
    }

    public int deleteStudent(String studyId)
    {
        return studentDao.deleteStudent(studyId);
    }

    public int updateStudent(Student student)
    {
        return studentDao.updateStudent(student);
    }

    public Student selectStudent(String studyId)
    {
        return studentDao.selectStudent(studyId);
    }

    public List<Student> selectAllStudent()
    {
        return studentDao.selectAllStudent();
    }
}
