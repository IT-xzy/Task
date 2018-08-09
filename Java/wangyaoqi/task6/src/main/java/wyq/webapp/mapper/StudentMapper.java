package wyq.webapp.mapper;

import wyq.webapp.pojo.Student;
import wyq.webapp.util.Page;

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
