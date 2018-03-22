import com.mapper.StudentMapper;
import com.pojo.Page;
import com.pojo.Student;
import com.service.PageStudent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class pagetest {
    @Autowired
    private StudentMapper studentMapper;

    @Test
    public void gogogo() throws Exception {
        int total;
        PageStudent pageStudent = new PageStudent();
        pageStudent.setStudentMapper(studentMapper);
        total = pageStudent.getTotal();
        System.out.println(total);
        Page page = new Page();
        page.caculateLast(total);
        System.out.println(page.getLast());
        List<Student> studentList = pageStudent.doSomeBusinessStuff(page);
        for(Student s:studentList) {
            System.out.println(s.getName());
        }
    }
}
