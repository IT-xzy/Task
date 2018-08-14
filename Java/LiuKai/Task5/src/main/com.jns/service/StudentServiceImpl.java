package service;

import dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pojo.Student;

import java.util.List;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {
//    Logger logger=Logger.getLogger("StudentServiceImpl.class");

    @Autowired
    StudentDao studentDao;

    @Override
    public long countAll() {
        return studentDao.countAll();
    }

    @Override
    public long insertStudent(Student student) {
        long time = System.currentTimeMillis();
        student.setCreateTime(time);
        student.setUpdateTime(time);
        studentDao.insertStudent(student);
        return student.getId();
    }

    @Override
    public long regStudent(Student student) {
        long time = System.currentTimeMillis();
        student.setCreateTime(time);
        student.setUpdateTime(time);
        studentDao.regStudent(student);
        return student.getId();
    }

    @Override
    public void deleteAll() {
        studentDao.deleteAll();
    }

    @Override
    public long countJob() {
        return studentDao.countJob();
    }

    @Override
    public List<Student> findGood() {
        List<Student> goodlist=studentDao.findGood();
        return goodlist;
    }

    @Override
    public int countCourse(String cour) {
        int courseNum=studentDao.countCourse(cour);
        return courseNum;
    }
    @Override
    public boolean deleteById(long id) {
        return studentDao.deleteById(id);
    }

    @Override
    public boolean updateStudent(Student student) {
        long time=System.currentTimeMillis();
        student.setUpdateTime(time);
        return studentDao.updateStudent(student);
    }

    @Override
    public Student findById(long id) {
        return studentDao.findById(id);
    }

    @Override
    public List<Student> findLikeName(String name) {
        return studentDao.findLikeName(name);
    }

    @Override
    public List<Student> findAll() {
        return   studentDao.findAll();
    }

    @Override
    public Student signIn(Student student) {
        return studentDao.signIn(student);
    }

//    @Override
//    public boolean findByName(String stuName) {
//        return studentDao.findByName(stuName);
//    }

    @Override
    public Student findByName(String stuName){
        return studentDao.findByName(stuName);
    }
}

