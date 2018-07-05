package service;
import pojo.Student;
import java.util.List;

public interface StudentService {
    List<Student> list();

    void add(Student student);

    void delete(int id);

    Student get(int id) ;

    void update(Student student) ;

    void pinsert(List<String> list);
}
