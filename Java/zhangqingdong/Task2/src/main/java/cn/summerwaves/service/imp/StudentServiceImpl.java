package cn.summerwaves.service.imp;

import cn.summerwaves.dao.StudentDao;
import cn.summerwaves.model.Student;
import cn.summerwaves.service.IStudentService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by summerwaves on 2017/9/11.
 */
@Service("userService")
public class StudentServiceImpl implements IStudentService {
    private static Logger logger = Logger.getLogger("StudentServiceImpl.class");

    @Resource
    private StudentDao studentDao;

    @Override
    public void insertStudent(Student student) {
        studentDao.insertStudent(student);
        logger.info("插入操作");
    }

    @Override
    public List<Student> getAllStudent() {
        logger.info("获取全部学员");
        return  studentDao.getAllStudent();
    }

    @Override
    public Student getStudentById(int id) {
        logger.info("使用ID查询学员");
        return studentDao.getStudentById(id);
    }

    @Override
    public void updateStudent(Student student) {
        logger.info("更新操作");
        studentDao.updateStudent(student);
    }
    @Override
    public void deleteStudent(int id) {
        logger.info("删除操作");
//        studentDao.deleteStudent(id);
    }
//    @Override
//    public void insertUser(Student student) throws IOException {
//        studentDao.insertUserByAnnotation(student);
//    }
//
//    @Override
//    public List<Student> getAllUsers() throws IOException {
//        return studentDao.getAllUsers();
//    }
//
//    @Override
//    public Student getUserByUserName(String username) throws IOException {
//        return studentDao.getUserByUserName(username);
//    }
//
//    @Override
//    public void deleteUser(String username) {
//        studentDao.deleteUser(username);
//    }
//
//    @Override
//    public void modifyPassword(Student student)throws IOException {
//        studentDao.modifyPassword(student);
//    }

}
