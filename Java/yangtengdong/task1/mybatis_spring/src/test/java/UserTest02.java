/*
import mapper.User;
import mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)                          //用spring的测试框架
@ContextConfiguration("classpath:applicationContext.xml")        //加载配置文件
public class UserTest02 {
    @Autowired
    UserMapper userMapper;                                        //直接从容器中获取userMapper代理对象

    @Test
    public void findUserByName()throws Exception {
        User user = userMapper.findUserByName("杨腾");
        System.out.println(user);

    }

    @Test
    public void findUserByName1()throws Exception {
        List<User> users = userMapper.findUserByName1("杨");
        for (User user : users) {
            System.out.println(user);
        }
    }


    @Test
    public void insert()throws Exception {
        User user = new User("杨腾东","12",System.currentTimeMillis(),System.currentTimeMillis());
        userMapper.Insert(user);                  //插入数据id一直不变,都为0 ;但是数据库里面id是自增的
        System.out.println(user);
    }

    @Test
    public void update()throws Exception{
        User user = new User("刘军鹏","15",
                System.currentTimeMillis(),System.currentTimeMillis());
//        user.setId(1);
//        user.setId(2);
        user.setId(3);
        userMapper.update(user);
        System.out.println(user);
    }

    @Test
    public void delete()throws Exception {
        userMapper.delete("杨腾东");   //怎么判断删除成功了
        System.out.println("s");      //上一步是否成功都运行
    }

}
*/
