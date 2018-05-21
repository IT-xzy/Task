package service;

import pojo.Student;
import java.util.List;

public interface StudentService {

    List<Student> list() ;

    void add(Student student);

    void delete(Integer id);

    Student get(Integer id) ;

    void update(Student student) ;

    void pinsert(List<String> list);

    Integer gettotal();

    int getjavatotal();

    List<Student> random();

}
