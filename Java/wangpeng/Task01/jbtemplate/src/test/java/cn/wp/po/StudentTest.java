package cn.wp.po;

import cn.wp.dao.StudentDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.sql.SQLException;

//让测试运行于Spring测试环境
@RunWith(SpringJUnit4ClassRunner.class)
//将spring配置文件导入本测试类
@ContextConfiguration("classpath:ApplicationContext.xml")

public class StudentTest {
    @Resource(name = "StudentDao")

    //声明一个StudentDao的私有变量sd
    private StudentDao sd;

    @Test //添加测试
    public void addTest() throws SQLException {
        Student stu = new Student();
        stu.setID(4);
        stu.setName("大龙虾");
        stu.setQQ(16837123);
        stu.setType("线上");
        stu.setEstimatedtime(20190308);
        stu.setSchool("湖南师范大学");
        stu.setManner("线上");
        stu.setNumber(159333);
        stu.setDaily("https://www.zhongzisoba.com/");
        stu.setWish("好好学习，day day up!!!");
        stu.setCounselor("辅导师兄");
        stu.setSource("齐天大圣");
        stu.setCreate_at(20190326);
        stu.setUpdate_at(20190326);
        sd.add(stu);
    }

    @Test //更改测试
    public void updateTest() throws SQLException {
        Student stu = new Student();
        stu.setName("白龙马吃小龙虾");
        stu.setQQ(123456);
        stu.setType("线上");
//        stu.setEstimatedtime(20190308);
        stu.setSchool("西安交通大学");
        stu.setManner("线下");
//        stu.setNumber(159333);
//        stu.setDaily("https://www.zhongzisoba.com/");
        stu.setWish("好好学习，day day up!!!");
        stu.setCounselor("唐僧");
        stu.setSource("花果山");
//        stu.setCreate_at(20190327);
//        stu.setUpdate_at(20190327);
        stu.setID(4);
        sd.update(stu);
    }

    @Test //删除测试
    public void deleteTest() throws SQLException {
        sd.delete(3);
    }

    @Test //单个值查询测试
    public void findByOne() throws SQLException {
        System.out.println(sd.findById(2));
    }

    @Test //单个对象查询测试
    public void findByObject() {
        System.out.println(sd.findtotalCount());
    }

    @Test //查询所有测试
    public void findAll() throws SQLException {
        System.out.println(sd.findAll());
    }
}