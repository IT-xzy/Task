import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.wszhan.pojo.Student;
import com.wszhan.service.StudentService;
import com.wszhan.utils.RandomData;

import org.apache.log4j.Logger;

import java.util.List;
import java.util.Random;

/**
 * @author Weisi Zhan
 * @create 2018-10-30 11:44
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class TestMyBatisAnnotation {
    // Data Generator
    private RandomData randomData = new RandomData();
    private Random randomObj = new Random();

    // log4j
    private Logger logger = Logger.getLogger(TestMyBatisAnnotation.class);

    //    StudentService studentService = (StudentService) context.getBean("studentService");
    @Autowired
    StudentService studentService;

    // Data for testing
    private int randomId = randomObj.nextInt(500);
    private Student studentInserted = new Student();;
    private int numReturnedByInsertion;

    @Test
    public void testSelect() throws Exception {
//        System.out.println("Random id: " + randomId);

        Student studentSelected = studentService.select(randomId);

        Assert.assertEquals((int)studentSelected.getId(), randomId);

//        System.out.println(
//                "Student Selected: " + studentSelected.getName() +
//                        "\nId: " + studentSelected.getId());
    }

    @Test
    public void testInsert() throws Exception {
        studentInserted.setName(randomData.randomName());
        studentInserted.setAge(randomData.randomAge());
        numReturnedByInsertion = studentService.insert(studentInserted);

        Assert.assertNotNull(studentInserted.getId());
        Assert.assertEquals(numReturnedByInsertion, (int) studentInserted.getId());

       /* System.out.println(
                "Student Inserted: " + studentInserted.getName() +
                        "\nId: " + studentInserted.getId() +
                        "\nReturned value: " + numReturnedByInsertion);*/
    }

    @Test
    public void testUpdate() throws Exception {
        Student studentUpdated = new Student();
        studentUpdated.setName(randomData.randomName());
        studentUpdated.setAge(randomData.randomAge());
        studentUpdated.setId(randomId);
        boolean boolReturnedByUpdate = studentService.update(studentUpdated);

        Assert.assertTrue(boolReturnedByUpdate);
        /*System.out.println(
                "Student Updated: " + studentUpdated.getName() +
                        "\nId: " + studentUpdated.getId() +
                        "\nReturned value: " + boolReturnedByUpdate
        );*/
    }

    @Test
    public void testDelete() throws Exception {
        System.out.println("Student Deleted: " + studentInserted.getName() +
                "\nId: " + studentInserted.getId());
        boolean boolReturnedByDelete = studentService.delete(randomId);
//        System.out.println("Returned value by deleting: " + boolReturnedByDelete);
        Assert.assertTrue(boolReturnedByDelete);
    }

    @Test
    public void testSelectAll() throws Exception {
        List<Student> allStudents = studentService.selectAll();
        for (Student s : allStudents) Assert.assertNotNull(s);
    }
}
    /*public class TestMyBatisAnnotation {
*//*    // Define SqlSession
    SqlSession session = null;*//*
    // Data Generator
    RandomData randomData = new RandomData();
    Random randomObj = new Random();

    // log4j
    Logger logger = Logger.getLogger(TestMyBatisAnnotation.class);

*//*    @Before
    public void init(){
        // 定义mybatis全局配置文件
        String resource = "mybatis-configuration.xml";

        // 加载mybatis全局配置文件
        InputStream inputStream = TestMyBatisAnnotation.class.getClassLoader()
                .getResourceAsStream(resource);

        // 构建SqlSessionFactory
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 根据SqlSessionFactory产生Session
        session = sessionFactory.openSession();
    }*//*

    @Autowired
    StudentMapper studentMapper;

    @Test
    public void testAnnotationCRUD() throws Exception {
*//*        // 根据Session获取StudentMapper接口
        StudentMapper studentMapper = session.getMapper(StudentMapper.class);*//*

        // Logger
//        PropertyConfigurator.configure();

        // Random User
        int randomId = randomObj.nextInt(5000);

        // 调用selectStudentById() 方法
//        System.out.println("Select Student By Id " + randomId);
        Student studentSelect = studentMapper.selectStudentById(randomId);
        System.out.println(studentSelect);

        // 调用insertStudent()方法
        Student studentInsert = new Student();
        studentInsert.setName(randomData.randomName());
        studentInsert.setAge(randomData.randomAge());
        System.out.println(studentInsert.getName());
        studentMapper.insertStudent(studentInsert);
//        System.out.println("Insert Student");
//        System.out.println(studentInsert);
        System.out.println("+++++++++++++++++++++++++++++++++++" + studentInsert.getId());
        int returnedId = studentInsert.getId();
        System.out.println("+++++++++++++++++++++++++++++++++++" + returnedId);
        logger.debug("Insertion returned value: " + returnedId);

        // 调用updateStudentById()方法
        Student studentUpdate = new Student();
        studentUpdate.setName(randomData.randomName());
        studentUpdate.setAge(randomData.randomAge());
        studentUpdate.setId(returnedId);
        int updateBool = studentMapper.updateStudentById(studentUpdate);
        System.out.println("UPDATE Student");
        System.out.println(studentUpdate);
        logger.debug("Update returned value: " + updateBool);
        System.out.println("Update returned value: " + updateBool);

        // 调用delete()方法
        System.out.println("Starting deleting...");
        int deleteBool = studentMapper.deleteStudentById(returnedId);
//        System.out.println("DELETE Student with Id = " + randomId);
        System.out.println("Record deleted: " + returnedId);
        System.out.println("Delete returned value: " + deleteBool);

        // 调用selectStudentAll方法
        System.out.println("SELECT students with LIMIT 10");
        List<Student> usersAll = studentMapper.selectStudentAll();
        logger.debug("List all records returned:");
        for (Student user : usersAll) {
            System.out.println(user);
            logger.debug("user");
        }

        // 调用selectLikeStudentName method
        System.out.println("SELECT students with a pattern in names");
        String pattern = "John";
        System.out.println("Pattern: " + pattern);
        List<Student> users = studentMapper.selectLikeStudentName(pattern);
        for (Student user : users) System.out.println(user);

*//*        session.commit();
        session.close();*//*
    }
}*/


