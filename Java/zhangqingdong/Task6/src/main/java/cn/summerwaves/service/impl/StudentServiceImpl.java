package cn.summerwaves.service.impl;

import cn.summerwaves.dao.StudentDao;
import cn.summerwaves.model.Student;
import cn.summerwaves.service.IStudentService;
import cn.summerwaves.util.XMemcachedUtil;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService {

    @Resource
    private StudentDao studentDao;
    @Resource
    private XMemcachedUtil xMemcachedUtil;

    private static Logger logger = Logger.getLogger("StudentServiceImpl.class");

    @Override
    public List<Student> selectThreeStudent() {
        long start1 = System.currentTimeMillis();
        Student student1 = (Student) xMemcachedUtil.getCache("student1");
        Student student2 = (Student) xMemcachedUtil.getCache("student2");
        Student student3 = (Student) xMemcachedUtil.getCache("student3");
        if (student1 != null && student2 != null && student3 != null) {
            List<Student> students = new ArrayList<Student>();
            students.add(student1);
            students.add(student2);
            students.add(student3);
            long end1 = System.currentTimeMillis();
            logger.error("缓存响应时间为：" + (end1 - start1));
            return students;
        }
        long start2 = System.currentTimeMillis();
        Student studentFromDB1 = studentDao.selectOneStudent("1");
        Student studentFromDB2 = studentDao.selectOneStudent("2");
        Student studentFromDB3 = studentDao.selectOneStudent("3");
        if (studentFromDB1 == null && studentFromDB2 == null && studentFromDB3 == null) {
            Student student = new Student();
            student.setName("test");
            xMemcachedUtil.addCache("student1", 60 * 5, student);
            xMemcachedUtil.addCache("student2", 60 * 5, student);
            xMemcachedUtil.addCache("student3", 60 * 5, student);
            return null;
        }
        long end2 = System.currentTimeMillis();
        logger.error("数据库响应时间为：" + (end2 - start2));
        xMemcachedUtil.addCache("student1",3600,studentFromDB1);
        xMemcachedUtil.addCache("student2",3600,studentFromDB2);
        xMemcachedUtil.addCache("student3",3600,studentFromDB3);
        List<Student> studentsFromDB = new ArrayList<Student>();
        studentsFromDB.add(studentFromDB1);
        studentsFromDB.add(studentFromDB2);
        studentsFromDB.add(studentFromDB3);
        return  studentsFromDB;
    }

    @Override
    public List<Student> selectThreeStudentFromDB() {
        logger.error("");
        Student studentsFromDB1 = studentDao.selectOneStudent("10");
        Student studentsFromDB2 = studentDao.selectOneStudent("12");
        Student studentsFromDB3 = studentDao.selectOneStudent("13");

        List<Student> studentsFromDB =new ArrayList<Student>();
        studentsFromDB.add(studentsFromDB1);
        studentsFromDB.add(studentsFromDB2);
        studentsFromDB.add(studentsFromDB3);
        return studentsFromDB;
    }

    @Override
    public void insertStudent(Student student) {
        xMemcachedUtil.deleteCache("student1");
        xMemcachedUtil.deleteCache("student2");
        xMemcachedUtil.deleteCache("student3");
        studentDao.insertStudent(student);
    }
}
