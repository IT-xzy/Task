package wyq.springmvc.mapper;


import wyq.springmvc.pojo.Student;
import wyq.springmvc.util.Page;

import java.util.List;

public interface StudentMapper {
    int add(Student student);
    void delete(int id);
    Student getOne(int id);
    int update(Student student);
    List<Student> list();
    List<Student> list(Page page);
    int total();
}
