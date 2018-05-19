package dao;

import org.springframework.stereotype.Repository;
import pojo.Student;
@Repository
public interface StudentMapper {
    public int count();
    public Student select(int id);

}
