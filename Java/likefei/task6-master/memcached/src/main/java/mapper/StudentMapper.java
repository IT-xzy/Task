package mapper;

import pojo.Student;

import java.util.List;


public interface StudentMapper {

    void add(Student student);

    void delete(Integer id);

    Student get(Integer id);

    void update(Student student);

    List<Student> list();

    void pinsert(List<String> list);

    int gettotal();

    int getjavatotal();

}
