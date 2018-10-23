import com.suger.dao.StudentDao;
import com.suger.pojo.Page;
import com.suger.pojo.Student;
import com.suger.service.StudentService;
import com.suger.util.DataUtils;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * created by suger on 2018/10/2
 */
public class StudentServiceImplTest {

    ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/spring-mybatis.xml");
    StudentService studentService = ctx.getBean(StudentService.class);
    StudentDao studentDao = ctx.getBean(StudentDao.class);
    static Logger log = Logger.getLogger(StudentService.class);

    @Test
    public void addStudent() throws Exception {
        Student student = new Student();
        student.setName(DataUtils.getName());
        student.setQq(DataUtils.getNumber(10));
        student.setProfession(DataUtils.getProfession());
        student.setStartTime(DataUtils.getDateTime());
        student.setGraduatedFrom(DataUtils.getCollege());
        student.setOnlineId(DataUtils.getIntNumber());
        student.setDailyLink(DataUtils.getLink());
        student.setWish(DataUtils.getWish());
        student.setCounselor(DataUtils.getName());
        student.setWay(DataUtils.getWay());
        student.setCreateAt(DataUtils.getTime());
        student.setUpdateAt(DataUtils.getTime());
        log.info("插入前id:" + student.getId());
        studentService.addStudent(student);
        log.info("插入后id:" + student.getId());
    }

    @Test
    public void updateStudent() throws Exception {

        studentService.getStudentById(2L);

        Student student = new Student();
        student.setId(2L);
        student.setName(DataUtils.getName());
        student.setQq(DataUtils.getNumber(10));
        student.setProfession(DataUtils.getProfession());
        student.setStartTime(DataUtils.getDateTime());
        student.setGraduatedFrom(DataUtils.getCollege());
        student.setOnlineId(DataUtils.getIntNumber());
        student.setDailyLink(DataUtils.getLink());
        student.setWish(DataUtils.getWish());
        student.setCounselor(DataUtils.getName());
        student.setWay(DataUtils.getWay());
        student.setUpdateAt(DataUtils.getTime());
        log.info("----------更新：{}"+studentService.updateStudent(student));
    }

    @Test
    public void deleteStudent() throws Exception {
        Long id = 1L;
        log.info(studentService.deleteStudent(id));
    }

    @Test
    public void total() throws Exception {
        log.info(studentDao.total());
    }

    @Test
    public void findAll() throws Exception {
        Page page = new Page();
        log.info(studentService.findAll(page));
    }

    @Test
    public void getStudentByName() throws Exception {
        String name = "余";
        log.info(studentService.getStudentByName(name));
    }

    @Test
    public void getStudentByOnlineId() throws Exception {
        int onlineId = 16233;
        log.info(studentService.getStudentByonlineId(onlineId));
    }

}