import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.wszhan.pojo.Student;
import com.wszhan.service.StudentService;
import com.wszhan.utils.RandomData;

import java.util.List;
import java.util.Random;

/**
 * @author Weisi Zhan
 * @create 2018-10-31 14:55
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class TestMyBatisXMLWithSpring {
    // Data Generator
    private RandomData randomData = new RandomData();
    private Random randomObj = new Random();

    // log4j
    private Logger logger = Logger.getLogger(TestMyBatisXMLWithSpring.class);

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
