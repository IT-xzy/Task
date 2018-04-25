package service;
import com.github.pagehelper.PageInfo;
import org.springframework.cache.annotation.Cacheable;
import pojo.Student;
import java.util.List;

public interface StudentService {

//    PageInfo page(Integer pn);

    List<Student> list();

    void add(Student student);

    void delete(Integer id);

    Student get(Integer id) ;

    void update(Student student) ;

    void pinsert(List<String> list);

    int gettotal();

    int getjavatotal();

    List<Student> random();

}
