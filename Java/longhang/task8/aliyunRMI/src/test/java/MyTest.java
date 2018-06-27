import com.longhang.stuService.StuService;
import com.longhang.stuService.UserService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value="classpath:applicationContext.xml")

public class MyTest {
    private Logger logger = Logger.getLogger("MyTest.class");
    @Autowired
    private UserService user;
    @Autowired
    private StuService stu;
//    @Test
//    public void ser(){
//        new ClassPathXmlApplicationContext("applicationContext.xml");
//    }
    @Test
    public void serImpl(){

    }
    @Test
    public void s(){
        for(int x=1;x<11;x++)
        System.out.println(Math.random());
    }


    @Test
    public void sss(){
       if( (Math.random()-0.5)>0) {
           try {
               int i = 1 / 0;

           } catch (Exception e) {
               System.out.println("1231243124");
           }
       }
       else {
           try {
               int i = 1;
               System.out.println("你好");
           } catch (Exception e) {
               System.out.println("牛B");
           }
       }

    }
    @Test
    public void sssss() {
        try {
            int i=1/0;
        }catch (Exception e){
            int i=1/0;
            System.out.println("1231243124");
        }
    }
    @Test
    public void sssssss() {
        try {
            this.sssss();
        }catch (Exception e){
            //this.sssss();
            System.out.println("1231243124");
        }
    }

}