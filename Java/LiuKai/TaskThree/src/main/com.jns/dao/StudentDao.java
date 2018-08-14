package dao;

import org.apache.ibatis.annotations.Param;
import pojo.Student;
import pojo.PageBean;

import java.util.HashMap;
import java.util.List;

public interface StudentDao {

    long insertStudent(Student student);

    boolean deleteById(long id);

    void deleteAll();

    boolean updateStudent(Student student);

    Student findById(long id);

    List<Student> findLikeName(String name);

    List<Student> findAll();

    List<Student> findByPage(HashMap<String, Object> map);


    List<Student> queryAll(@Param("offset") int offset, @Param("limit") int limit);
}
