

import com.alibaba.fastjson.JSONObject;
import com.mapper.UserMapper;
import com.model.User;
import com.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * @Author qmz
 * @Description TODO
 * @Data 2018/7/4$ 11:13$
 **/

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestOne {
    private static Logger logger=Logger.getLogger("TestOne.class");
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserService userService;
    User user = new User();

    @Test
    public void test() {
        user.setName("大佬");
        userMapper.addUser(user);
        logger.info(user.toString());
    }

    @Test
    public void test1() {
        user.setName("张欢1");
        user.setType("web");
        int b = userService.updateTypeByName(user);
        System.out.println(b);
    }

    @Test
    public void test2() {
        boolean b;
        user.setName("大佬");
        user.setType("java");
        userMapper.updateTypeByName(user);
        System.out.println(user.getId());
    }

    @Test
    public void test3() {
        user.setName("程荣强");
        user = userService.selectByName(user);
        System.out.println(user.toString());
    }

    @Test
    public void test4() {
        JSONObject jsonObject = new JSONObject();
        user.setName("程荣强");
        user = userService.selectByName(user);
        jsonObject.put("user", JSONObject.toJSON(user));
        System.out.println(jsonObject);
    }
//批量删除有问题
    @Test
    public void test6() {
        List<User> list = new ArrayList<>();
        for (long id = 20001L; id > 20000L; id++) {
            user.setId(id);
            list.add(user);
            if (list.size() % 5000 == 0) {
                userMapper.deleteById1(list);
                list.clear();
            }
            if (id == 104841L) {
                userMapper.deleteById1(list);
                break;
            }
        }
//        System.out.println(b);
    }

    @Test
    public void test7() {
        List<User> list = new ArrayList<>();
        user.setId(18000L);
        list.add(user);
        userMapper.deleteById1(list);
    }

    //        System.out.println(b);
    @Test
    public void test8() {
       user.setName("大杯子");
       userMapper.deleteByName(user);
    }
}

