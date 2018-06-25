package dao.mapper;

import model.Student;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface StudentMapper {

    Student selectById(int id);

    List<Student> findByStudent(Student student);

    int insertOne(Student student);

    int insertForList(List<Student> list);

    int deleteOne(int id);

    int deleteForList(List list);

    int updateOne(Student student);

    int updateForList(List<Student> list);

}
