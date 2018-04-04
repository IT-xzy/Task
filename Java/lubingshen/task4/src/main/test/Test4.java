import com.ptteng.bean.User;
import com.ptteng.bean.Graduate;
import com.ptteng.dao.GraduateDao;
import com.ptteng.service.UserService;
import com.ptteng.service.GraduateService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.lang.reflect.Field;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class Test4 {
    @Autowired
    private GraduateService graduateService;
    @Autowired
    private GraduateDao graduateDao;
    @Autowired
    private UserService userService;

    @Test
    public void test1() throws Exception {
        User user = new User();
        user.setUserName("123");
        user.setUserKey("123");
        System.out.println(userService.register(user));
    }

    @Test
    public void test2() throws Exception {
        User user = userService.query("123");
        System.out.println(user.getUserKey());
    }

    @Test
    public void currenTime(){
        System.out.println(System.currentTimeMillis());
    }

    @Test
    public void testLazyLoading() throws Exception {
        Graduate graduate = graduateDao.findById(4L);
        System.out.println(graduate);
        System.out.println(graduate.getStudent());
        System.out.println(graduate.getClass().getSimpleName());
        Field[] fields = graduate.getClass().getDeclaredFields();
        for(Field field : fields)
            System.out.println(field);
    }

}
