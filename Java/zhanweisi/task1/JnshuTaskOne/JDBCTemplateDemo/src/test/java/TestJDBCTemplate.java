import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.wszhan.pojo.Student;
import com.wszhan.service.StudentJDBCTemplate;
import com.wszhan.utils.RandomData;

import java.util.Random;

/**
 * @author Weisi Zhan
 * @create 2018-10-31 15:34
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestJDBCTemplate {
    // Data Generator
    RandomData randomData = new RandomData();
    Random randomObj = new Random();

    // log4j
    Logger logger = Logger.getLogger(TestJDBCTemplate.class);

    @Autowired
    StudentJDBCTemplate studentJDBCTemplate;

    // Data for testing
    private int randomId = randomObj.nextInt(500);
    private Student studentInserted = new Student();;
    private int numReturnedByInsertion;

    @Test
    public void testSelect() throws Exception {
        Student studentSelected = studentJDBCTemplate.getStudent(randomId);
        Assert.assertEquals((int) studentSelected.getId(), randomId);
    }

    @Test
    public void testInsert() throws Exception {
        studentInserted.setName(randomData.randomName());
        studentInserted.setAge(randomData.randomAge());
        int numReturnedByInsertion = studentJDBCTemplate.create(
                studentInserted.getName(),
                studentInserted.getAge()
        );
//        System.out.println("Returned value: " + numReturnedByInsertion);
//        System.out.println("Object id: " + studentInserted.getId());
        Assert.assertNotNull(numReturnedByInsertion);
    }

    @Test
    public void testUpdate() throws Exception {
        Student studentUpdated = new Student();
        studentUpdated.setName(randomData.randomName());
        studentUpdated.setAge(randomData.randomAge());
        studentUpdated.setId(randomId);
        studentJDBCTemplate.update(studentUpdated);
    }

    @Test
    public void testDelete() throws Exception {
        studentJDBCTemplate.delete(numReturnedByInsertion);
    }

}

/*public class TestJDBCTemplate {

    public static void main(String[] args) {
        // Data Generator
        RandomData randomData = new RandomData();
        Random randomObj = new Random();

        // log4j
        Logger logger = Logger.getLogger(TestJDBCTemplate.class);

        ApplicationContext context =
                new ClassPathXmlApplicationContext(
                        "applicationContext.xml");

        StudentJDBCTemplate studentJDBCTemplate =
                (StudentJDBCTemplate)context.getBean(
                        "studentJDBCTemplate");

        // Test Select
        int randomId = randomObj.nextInt(500);
        System.out.println("Random id: " + randomId);
        Student studentSelected = studentJDBCTemplate.getStudent(randomId);
        System.out.println(
                "Student Selected: " + studentSelected.getName() +
                        "\nId: " + studentSelected.getId());

        // Insertion
        Student studentInserted = new Student();
        studentInserted.setName(randomData.randomName());
        studentInserted.setAge(randomData.randomAge());
        int insertRetrunedId = studentJDBCTemplate.create(
                studentInserted.getName(),
                studentInserted.getAge()
        );
        System.out.println(
                "Student Inserted: " + studentInserted.getName() +
                        "\nId: " + insertRetrunedId);

        // Update
        Student studentUpdated = new Student();
        studentUpdated.setName(randomData.randomName());
        studentUpdated.setAge(randomData.randomAge());
        studentUpdated.setId(randomId);
        studentJDBCTemplate.update(studentUpdated);
        System.out.println(
                "Student Updated: " + studentUpdated.getName() +
                        "\nId: " + studentUpdated.getId()
        );

        // Delete
        System.out.println("Student Deleted: " + studentInserted.getName() +
                "\nId: " + studentInserted.getId());
        studentJDBCTemplate.delete(insertRetrunedId);
    }
}*/
