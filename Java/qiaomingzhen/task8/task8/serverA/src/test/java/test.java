import com.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/*
 * @ClassName:test
 * @Description:TODO
 * @Author qiao
 * @Date 2018/9/18 13:22
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class test {
    @Autowired
   UserService userService;

    @Test
    public void name() {
        long start = System.currentTimeMillis();

        for (int i = 0; i < 1000; i++) {
            System.out.println(userService.selectById(1L));
        }
            System.out.println(System.currentTimeMillis() - start);

    }
}
