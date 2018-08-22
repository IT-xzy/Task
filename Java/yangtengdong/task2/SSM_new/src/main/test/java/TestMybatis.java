
import com.ssmTest.entity.User;
import com.ssmTest.service.UserService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-context.xml")
public class TestMybatis {
    //TestMyBatis类定义的日志信息就能够显示出来了
    private static Logger logger = Logger.getLogger(TestMybatis.class);
    @Autowired
    private UserService userService;

    @Test
    public void insert(){
//        User user = new User("李白","1234","libai@163.com","10086","销售主管");
//        User user = new User("李清照","1234","liqingzhao@163.com","10087","高管");
//        User user = new User("杜甫","1234","dufu@163.com","10088","客户经理");
//        User user = new User("岑参","1234","censhen@163.com","10089","系统管理员");
        User user = new User("温庭筠","1234","wentingyu@163.com","10090","销售主管");
        userService.insertSelective(user);
//        logger.info(JSON.toJSONString(user));//JSon格式的内容
    }
    @Test
    public void selectUserById(){
        User user = userService.selectById(3);
        //logger.info("值：" + user.toString());
        logger.info(JSON.toJSONString(user));//JSon格式的内容
//        System.out.println(user);
    }

}
