/**
 * Author: 老王
 * Date: 2019/4/13 22:24
 */
package cn.wp.po;

import cn.wp.dao.DemoDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.sql.SQLException;

//让测试运行于Spring测试环境
@RunWith(SpringJUnit4ClassRunner.class)
//将spring配置文件导入本测试类
@ContextConfiguration("classpath:ApplicationContext2.xml")

public class DemoTest {

    @Resource(name = "DemoDao")

    private DemoDao demo;

    @Test //添加测试
    public void addTest() throws SQLException {
        Demo de = new Demo();
        de.setId(2);
        de.setName("南山南");
        de.setQq(456);
        de.setSchool("四川大学");
        demo.add(de);
    }
}
