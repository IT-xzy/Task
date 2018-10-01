import com.jnshu.czm.model.User;
import com.jnshu.czm.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)		//表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})

public class TestMyBatis {
    private static Logger logger =  LoggerFactory.getLogger(TestMyBatis.class);
    //	private ApplicationContext ac = null;
    @Resource
    private UserService userService;

//	@Before
//	public void before() {
//		ac = new ClassPathXmlApplicationContext("applicationContext.xml");
//		userService = (IUserService) ac.getBean("userService");
//	}

    @Test
    public void test1() {
        User user = userService.findUserById(1);
        // System.out.println(user.getUserName());
        // logger.info("值："+user.getUserName());
//        logger.info(JSON.toJSONString(user));
    }

    @Test
    public void testselectUserList(){
        List<User> lists = new ArrayList<>();
        lists = userService.findAll();
        Iterator< User> it = lists.iterator();
        System.out.println("总记录数："+userService.selectCount());
        while(it.hasNext()){
            User user = it.next();
            System.out.println(user.toString());
        }
    }
}


