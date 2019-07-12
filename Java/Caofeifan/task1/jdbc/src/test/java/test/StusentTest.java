package test;
/**
 * 单元测试
 */

import com.dao.StudentDao;
import com.daoImpl.StudentDaoImpl;
import com.pojo.Student;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.sql.Timestamp;
import java.util.Iterator;
import java.util.List;

public class StusentTest {

    static Logger logger = Logger.getLogger(StusentTest.class);
    static StudentDao sd = new StudentDaoImpl();

    /**
     * 添加学生
     */
    @Test
    public void addStudent()throws Exception {
        Student stu = new Student();
        stu.setCreateAt(new Timestamp(System.currentTimeMillis()));
        stu.setUpdateAt(new Timestamp(System.currentTimeMillis()));
        stu.setName("FF");
        stu.setQq(66);
        stu.setJob("爪哇");
        stu.setStartTime(55L);
        stu.setCollege("复旦");
        stu.setNumber(997);
        stu.setDailyUrl("com");
        stu.setWish("瘦一点");
        stu.setBrother("王汇通");
        stu.setReferee("加油");
        stu.setCity("郑州");
        stu.setReview("知乎");
        logger.info(stu);
        sd.addStudent(stu);

    }

    /**
     * 删除
     */
    @Test
    public void deleteStudent() throws Exception{
        sd.deleteStudent(2L);
    }

    /**
     * 修改
     */
    @Test
    public void updateStudent() throws Exception{
        Student stu = new Student();
        stu.setId(9L);
        stu.setCreateAt(new Timestamp(System.currentTimeMillis()));
        stu.setUpdateAt(new Timestamp(System.currentTimeMillis()));
        stu.setName("曹非凡");
        stu.setQq(66);
        stu.setJob("爪哇");
        stu.setStartTime(55L);
        stu.setCollege("复旦");
        stu.setNumber(997);
        stu.setDailyUrl("com");
        stu.setWish("瘦一点");
        stu.setBrother("11");
        stu.setReferee("11");
        stu.setCity("11");
        stu.setReview("知乎");
        sd.updateStudent(stu);
    }


    /**
     * 查询全表
     */
    @Test
    public void getAllStudent()throws Exception {
        List<Student> students = sd.getAllStudents();
        Iterator<Student> it = students.iterator();
        while (it.hasNext()) {
            Student stu = it.next();
            logger.info(stu);
        }
    }

    /**
     * 根据ID查询
     */
    @Test

    public void findById()throws Exception {
        Student stu = sd.getStudentById(900112L);
        logger.info(stu);
    }

    @Test
    /**
     * 条件查询
     */
    public void findByNameAndNumber() throws Exception{
        Student stu = sd.getStudentByNameAndNumber("王八蛋", 998);
        logger.info(stu);
    }

    @Test
    /**
     * 通过ID查询名字
     */
    public void findByNumber() throws Exception{
        Student stu = sd.getStudentByNumber(10086);
        logger.info(stu);
    }

    /**
     * 模糊查找
     */
    @Test
    public void findByCondition() throws Exception{
        List<Student> stu = sd.getStudentsByCondition("不");
        logger.info(stu);
    }


    /**
     * 百万插入
     */
    @Test
    public void millionInsert() throws Exception{
        Student stu = new Student();
        stu.setId(null);
        stu.setCreateAt(new Timestamp(System.currentTimeMillis()));
        stu.setUpdateAt(new Timestamp(System.currentTimeMillis()));
        stu.setName("FF");
        stu.setQq(66);
        stu.setJob("爪哇");
        stu.setStartTime(55L);
        stu.setCollege("复旦");
        stu.setNumber(997);
        stu.setDailyUrl("com");
        stu.setWish("瘦一点");
        stu.setBrother("王汇通");
        stu.setReferee("加油");
        stu.setCity("郑州");
        stu.setReview("知乎");
        sd.million(stu);
        logger.info("插入成功");
    }
}


