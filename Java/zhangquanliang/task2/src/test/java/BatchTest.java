import com.suger.dao.StudentDao;
import com.suger.pojo.Student;
import com.suger.util.DataUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author suger
 * @date 2018-10-02
 */
public class BatchTest {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/spring-mybatis.xml");
        StudentDao studentDao = ctx.getBean(StudentDao.class);
        for (int i = 0; i < 2; i++) {
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
            studentDao.addStudent(student);
            System.out.println(student.getId());
        }
    }
}
