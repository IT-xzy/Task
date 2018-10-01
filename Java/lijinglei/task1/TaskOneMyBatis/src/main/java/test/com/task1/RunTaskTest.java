//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package test.com.task1;

import com.task1.mybatis.dao.Dao;
import com.task1.mybatis.model.User;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RunTaskTest {
    ApplicationContext ctx = new ClassPathXmlApplicationContext("ApplicationContext.xml");
    Dao userDao;
    User user;
    Logger logger = Logger.getLogger("RunTaskTest.class");

    public RunTaskTest() {
        userDao = (Dao)ctx.getBean("userMapper");
        user = new User();
    }

    @Test
    public void insert() {
        try {
            System.out.print("插入结果：");
            user.setName("135");
            user.setQq("");
            user.setStudy_type("");
            user.setEnrollment("");
            user.setGraduate_school("");
            user.setStudent_num("");
            user.setDaily_link("");
            user.setWish("");
            user.setCheck_bro("");
            userDao.insert(user);
            System.out.println("最新插入" + user.getId());
        } catch (Exception var2) {
            System.out.println("插入失败" + var2.getMessage());
        }
    }

    @Test
    public void lookupId() {
        try {
            System.out.println("id查询结果：");
            User rsid = userDao.lookupId(2);
            sk(rsid);
        } catch (Exception var2) {
            System.out.println("查询失败");
        }
    }

    @Test
    public void delete() {
        try {
            System.out.print("删除结果：");
            System.out.println(userDao.delete(8));
        } catch (Exception var2) {
            System.out.println("删除失败");
        }
    }

    @Test
    public void update() {
        try {
            System.out.print("更新结果：");
            System.out.println(userDao.update(9, "1653"));
        } catch (Exception var2) {
            System.out.println("更新失败" + var2.getMessage());
        }
    }

    @Test
    public void lookupName() {
        try {
            System.out.println("姓名查询结果：");
            User rsName = userDao.lookupName("4");
            sk(rsName);
        } catch (Exception var2) {
            System.out.println("查询失败");
        }
    }

    @Test
    public void lookupNum() {
        try {
            System.out.println("学号查询结果：");
            User rsNum = userDao.lookupNum("3762");
            sk(rsNum);
        } catch (Exception var2) {
            System.out.println("查询失败");
        }
    }

    @Test
    public void selectAll() {
        System.out.println("所有数据：");
        List<User> users = userDao.selectAll();
        Iterator iter = users.iterator();

        while(iter.hasNext()) {
            User u = (User)iter.next();
            sk(u);
        }

        System.out.println("记录条数：" + userDao.countAll());
    }

    static void sk(User u) {
        System.out.print("ID:" + u.getId());
        System.out.print("姓名:" + u.getName());
        System.out.print("QQ:" + u.getQq());
        System.out.print("修真类型：" + u.getStudy_type());
        System.out.print("入学时间：" + u.getEnrollment());
        System.out.print("毕业学校：" + u.getGraduate_school());
        System.out.print("线上学号：" + u.getStudent_num());
        System.out.print("日报链接：" + u.getDaily_link());
        System.out.print("立愿：" + u.getWish());
        System.out.println("审核师兄：" + u.getCheck_bro());
    }
}
