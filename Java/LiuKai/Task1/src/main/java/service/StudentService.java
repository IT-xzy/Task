package service;

import pojo.Student;
import java.util.List;

public interface StudentService {

    //   增加学员
    long insertStudent(Student student);

    //    删除学员
    boolean deleteStudent(long id);

//修改学员

    boolean updateStudent(Student student);

    //  根据查找学员
    Student findById(long id);

    //  根据姓名模糊查询
    List<Student> findLikeName(String name);

// 删除所有数据

  void deleteAll();
}

