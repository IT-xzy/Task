package mapper;
import pojo.Student;

import java.util.List;

public interface StudentMapper {
    void add(Student student);

    void delete(int id) ;

     Student get(int id);

    void update(Student student) ;

    List<Student> list();

    void pinsert(List<String> list);
}

