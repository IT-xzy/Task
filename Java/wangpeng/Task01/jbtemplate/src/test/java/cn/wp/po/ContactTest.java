/**
 * Author：老王
 * Time：2019/3/28 13:50
 **/

package cn.wp.po;

import cn.wp.dao.ContactDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.sql.SQLException;

//让测试运行于Spring测试环境
@RunWith(SpringJUnit4ClassRunner.class)
//将spring配置文件导入本测试类
@ContextConfiguration("classpath:ApplicationContext1.xml")

public class ContactTest {

    @Resource(name = "ContactDao")

    //声明一个StudentDao的私有变量dd
    private ContactDao dd;

    //增
    @Test
    public void addTest() throws SQLException {
        Contact d = new Contact();
        d.setID(8);
        d.setName("额贼");
        d.setEmail("12345@qq.com");
        d.setQQ(56789);
        d.setGender("女");
        dd.add(d);
    }

    //删
    @Test
    public void removeTest() throws SQLException {
        dd.remove(4);
    }

    //改
    @Test
    public void updateTest() throws SQLException {
        Contact d = new Contact();
        d.setName("我勒个去");
        d.setEmail("007@126.com");
        d.setQQ(001);
        d.setGender("女");
        d.setID(3);
        dd.update(d);
    }

    //查
    @Test
    public void findAll() throws SQLException {
        System.out.println(dd.findAll());
    }
}
