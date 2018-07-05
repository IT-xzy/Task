import com.tools.MD5;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring/springTools.xml")
public class TestMd5 {
    @Autowired
    private MD5 md5;
    @Test
    public void testDes() {
        System.out.println(md5.encryption("23764")[0]);
        System.out.println(md5.md5encryption("234235"));
    }
}
