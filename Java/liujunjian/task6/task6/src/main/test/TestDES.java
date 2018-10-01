import com.tools.DES;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring/applicationContext.xml")
public class TestDES {
    @Autowired
    DES des;
    @Test
    public void testDes() {
        System.out.println(des.encrypt("23424"));
        System.out.println(des.decrypt(des.encrypt("23424")));
    }
}
