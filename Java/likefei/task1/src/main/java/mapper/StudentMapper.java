package mapper;

import java.util.List;
import pojo.Student;

public interface StudentMapper {
    void add(Student student);

    void delete(int id) throws Exception;

    Student get(int id) throws Exception;

    void update(Student student) throws Exception;

    List<Student> list();

    void pinsert(List<String> list);
}
