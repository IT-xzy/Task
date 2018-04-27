package mapper;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import pojo.Student;

import java.util.List;


public interface StudentMapper {

    void add(Student student);

    void delete(Integer id);

    Student get(Integer id);

    void update(Student student);

    List<Student> list();

    void pinsert(List<String> list);

    @Cacheable(value = "studentcache",key = "#root.methodName")
    int gettotal();

    int getjavatotal();

}
