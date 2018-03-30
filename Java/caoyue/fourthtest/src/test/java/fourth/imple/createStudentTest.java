package fourth.imple;

import fourth.com.student;
import fourth.Dao.studentDao;
import junit.framework.TestCase;

public class createStudentTest extends TestCase{
    private studentDao studentDao = new createStudent();
    public void testAddStudent() {
        student student = new student();
        student.setId(12);
        student.setCreate_at("20180302");
        student.setUpdate_at("20180302");
        student.setName("韩阳");
        student.setDailyLink("www.baidu.com");
        student.setQQ(1234);
        student.setOnlineNumber("好好");
        student.setMail("好好");
        student.setPhone(12345);
        student.setEnrollmentTime("20170301");
        student.setProfessionType("前端工程师");
        student.setBrotherName("梁家健");
        student.setPromise("一姐最胖");

        for (int i = 0; i<5; i++){
            studentDao.addStudent(student);
        }
    }

    public void testUpdateStudent() {
        String name = "秦栩章";
        studentDao.updateStudent(name);
    }

    public void testDeleteStudent() {
        String name = "韩阳";
        studentDao.deleteStudent(name);
    }

    public void testFindStudent() {
        student student = new student();
        student.setId(12);
        studentDao.findStudent(student);
    }
}
