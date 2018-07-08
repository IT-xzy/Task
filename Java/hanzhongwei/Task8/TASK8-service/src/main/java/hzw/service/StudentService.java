package hzw.service;

import hzw.model.Student;
import hzw.model.User;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface StudentService {

    Student findIdStudent(Long id);

    Student getID(Long id);

    Integer insertStudent(Student student);

    Integer deleteStudent(Long id);

    Integer updateStudent(Student student);

    List<Student> findListStudent();

    List<Student> findNameStudent(String name);

    User findIphone(String userIphone);

    // 根据用户名查询
    User findNameUser(String userName);
    // 查询全部用户
    List<User> findListUser();
    // 添加用户信息
    void insertUser(User user);

    User findIdUser(Long userId);

    void updateUser(User user);

    void updateUser1(User user);

    User findCodeUser(String userCode);

    User findMailUser(String userEmail);

    //测试
    public String updateHead(MultipartFile file, long userId) throws Exception;
}
