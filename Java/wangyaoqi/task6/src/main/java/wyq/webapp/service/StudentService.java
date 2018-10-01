package wyq.webapp.service;

import wyq.webapp.pojo.Student;
import wyq.webapp.util.Page;

import java.util.List;

public interface StudentService {
    void addStudent(Student student);
    void deleteStudent(int id);
    Student getById(int id);
//    void updateStudent(Student student);
    List<Student> list();
    List<Student> list(Page page);
    int total();
}
