package dao;

import model.Student;
import org.springframework.stereotype.Component;

import java.util.List;
/*
* jdbcTemplate 接口
* xml：
* jdbctemplate/applicationcontext.xml
*
* 实现类：
* impl/StudentDaoImpl
*
* */

@Component
public interface StudentDao {

    Student selectById(int id);

    List<Student> findByStudent(Student student);

    List<Student> findAll();

    int insert(Student student);

    int insertLiset(List<Student> list);

    int update(Student student);

    int[] updateList(List<Student> list);

    int delect(int id);

}
