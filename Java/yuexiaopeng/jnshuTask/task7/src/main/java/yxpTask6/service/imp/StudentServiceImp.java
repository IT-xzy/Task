package yxpTask6.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yxpTask6.dao.StudentDao;
import yxpTask6.pojo.Student;
import yxpTask6.service.StudentService;

import java.util.List;
import java.util.Map;
import java.util.Vector;

@Service
public class StudentServiceImp implements StudentService
{
    @Autowired
    private StudentDao studentDao;

    public int insertStudent(Student student)
    {
        return studentDao.insertStudent(student);
    }

    public void deleteStudent(Student student)
    {
        studentDao.deleteStudent(student);
    }

    public int updateStudent(Student student)
    {
        return studentDao.updateStudent(student);
    }

    public Student selectStudent(Student student)
    {
        return studentDao.selectStudent(student);
    }

    public List<Student> selectAllStudent()
    {
        return studentDao.selectAllStudent();
    }

    public Map<String,Object> selectAllStudentMap()
    {
        return studentDao.selectAllStudentMap();
    }

    public List selectAllStudyId(){return studentDao.selectAllStudyId();}

    public Student selectByStudyId(String studyId){return studentDao.selectByStudyId(studyId);}

}
