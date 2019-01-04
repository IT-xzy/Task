import com.suger.pojo.Student;
import com.suger.pojo.User;
import com.suger.service.StudentService;
import com.suger.util.DataUtils;
import com.suger.util.MD5Utils;
import com.suger.util.UUIDUtils;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * @author suger
 * @date 2018/11/18 19:19
 */
public class StudentServiceTest {
    ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/spring-mybatis.xml");
    StudentService studentService = ctx.getBean(StudentService.class);
    static Logger log = Logger.getLogger(StudentServiceTest.class);
    @Test
    public void listStudent() throws Exception {
        log.info(studentService.findAll());
    }
    @Test
    public void insertStudent() throws Exception {
        for(int i= 0;i<10;i++) {
            Student student = new Student();
            student.setName(DataUtils.getName());
            student.setPosition("运营");
            student.setImg("10-task8.png");
            student.setProfession(DataUtils.getProfession());
            student.setType(true);
            student.setIntro("不用写代码啦");
            student.setSalary("12K");
            student.setCreateAt(DataUtils.getTime()-1000*60L);
            student.setUpdateAt(DataUtils.getTime());
            long tag = studentService.insertStudent(student);
            log.info("插入受影响的行数"+tag);
        }
    }
    @Test
    public void updateStudent() throws Exception {

    }

    @Test
    public void getStudentType() throws Exception {

        List<Student> studentList = studentService.getStudentByType(true);

        // 记录工作以及在学学员数目
        int workNum = studentList.size();
        System.out.println("workNum = " + workNum);

        int studyNum = studentService.getStudentByType(false).size();
        int total = workNum+studyNum;
        System.out.println("total = " + total);

        // 打乱 studentList中的顺序
        Collections.shuffle(studentList);

        System.out.println(studentList);

        List<Student> students = new ArrayList<Student>(workNum);
        // 目前是从找到工作的学员来展示，如果大于4个，则 随机抽取4个来展示
        int n = workNum;
        boolean temp = 4 < workNum;
        if(temp){
            n = 4;
        }

        for(int i=0;i<n;i++) {
            //  数组打乱后，已经是随机值，可以直接取前几个
            students.add(studentList.get(i));
            log.info("/n"+students.get(i));
        }

    }
    @Test
    public void getStudentByName() throws Exception {

        String name = "李";
        log.info(studentService.getStudentByName(name));

    }

}