package hzw.service.impl;

import hzw.mapper.StudentMapper;
import hzw.mapper.UserMapper;
import hzw.model.Student;
import hzw.model.User;
import hzw.service.StudentService;
import hzw.util.RedisUtil;
import org.oasisopen.sca.annotation.Remotable;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@Component
public class StudentServiceImpl implements StudentService {

    private static org.slf4j.Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);

    @Autowired
    StudentMapper studentMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    RedisUtil redisUtil;


    @Override
    public Student findIdStudent(Long id) {
        return studentMapper.findIdStudent(id);
    }

    @Override
    public Student getID(Long id) {
                return studentMapper.getID(id);
    }

    //插入数据时，不涉及缓存操作
    @Override
    public Integer insertStudent(Student student) {
        student.setCreate_at(System.currentTimeMillis());
        student.setUpdate_at(System.currentTimeMillis());
        return studentMapper.insertStudent(student);
    }

    //数据库删除后，删除缓存，等待下次请求时更新缓存
    @Override
    public Integer deleteStudent(Long id) {
        studentMapper.deleteStudent(id);
        return studentMapper.deleteStudent(id);
    }

    //先更新数据库，然后删除缓存，等待下次请求时更新缓存
    @Override
    public Integer updateStudent(Student student) {
        student.setUpdate_at(System.currentTimeMillis());
        Integer a = studentMapper.updateStudent(student);
        return a;
    }

    @Override
    public List<Student> findListStudent(){
        return studentMapper.findListStudent();
    }

    @Override
    public List<Student> findNameStudent(String name) {
        return studentMapper.findNameStudent(name);
    }

    @Override
    public User findIphone(String userIphone) {
        return userMapper.findIphone(userIphone);
    }

    @Override
    public User findNameUser(String userName) {
        return userMapper.findNameUser(userName);
    }

    @Override
    public List<User> findListUser() {
        return userMapper.findListUser();
    }

    @Override
    public void insertUser(User user) {
        user.setSalt("zhongwei");
        user.setCreate_at(System.currentTimeMillis());
        user.setUpdate_at(System.currentTimeMillis());
        user.setUserPhoto(null);
        user.setEmailState(0);
        userMapper.addUser(user);
    }

    @Override
    public User findIdUser(Long userId) {
        return userMapper.findIdUser(userId);
    }

    @Override
    public void updateUser(User user) {
        user.setUpdate_at(System.currentTimeMillis());
        userMapper.updateUser(user);
    }

    @Override
    public void updateUser1(User user) {
        userMapper.updateUser1(user);
    }

    @Override
    public User findCodeUser(String userCode){
        return userMapper.findCodeUser(userCode);
    }

    @Override
    public User findMailUser(String userEmail){
        return userMapper.findMailUser(userEmail);
    }


    //测试
    @Override
    public String updateHead(MultipartFile file, long userId) throws Exception {

        return null;
    }
}
