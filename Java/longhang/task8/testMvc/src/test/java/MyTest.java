import com.longhang.controller.StuController;
import com.longhang.stuService.StuService;
import com.longhang.util.GetBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value="classpath:applicationContext.xml")
public class MyTest {

     GetBean getBean=new GetBean();
    StuService stu= getBean.getStu();
    org.slf4j.Logger logger = LoggerFactory.getLogger(StuController.class);

    @Test
    public void ss(){
       logger.info(String.valueOf(stu.getStuById(8L)));

    }

@Test
    public void s(){
    System.out.println(Math.random()*10);
}
}
