package TestSpringMybaits;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import xiuzhenyuan.bean.Student;
import xiuzhenyuan.dao.StudentDAO;

import java.util.List;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class TestSpringMybaits
{
    //    调用日志文件
    static Logger logger = Logger.getLogger(TestSpringMybaits.class);

    //   自动注入类
    @Autowired
    private StudentDAO studentDAO;

//    //在进行操作前打印信息
    @Before
    public void Test_doBefore()
    {
        logger.info("开始操作--请不要着急");
    }
//
//    //在进行操作后打印信息
    @After
    public void Test_doAfter()
    {
        logger.info("结束操作--谢谢参与");
    }

    //进行记录的删除
    @Test
    public void Test_doDelete()
    {
        String study_id="java-669";
        studentDAO.doDelete("java-669");
        logger.info("删除数据记录成功");
        System.out.println("删除study_id= "+study_id+" 的数据记录成功");
    }

    //进行记录的插入
    @Test
    public void Test_doInsert()
    {
        Student student=new Student();
        student.setId(99);
        student.setCreate_at(20180608l);
        student.setUpdate_at(20180608l);
        student.setName("岳飞飞");
        student.setQq(820180608);
        student.setStudy_type("java工程师");
        student.setStudy_id("java-680");
        student.setJoin_time(20180608l);
        student.setUniversity("大连交通大学");
        student.setDaily_link("http://www.jnshu.com/school/22071/daily");
        student.setSlogen("我的征途是星辰大海啊");
        student.setMaster("大师兄");
        studentDAO.doInsert(student);
        logger.info("插入一条数据记录成功");
        System.out.println("插入一条数据记录成功,该数据为："+'\n'+student);
    }

    //更改数据
    @Test
    public void Test_doUpdateByStudy_id()
    {
        Student student=new Student();
        student.setStudy_id("java-660");
        student.setSlogen("老大最帅");
        studentDAO.doUpdate(student);
        logger.info("修改数据记录成功");
        System.out.println("修改数据记录成功,修改后的数据为："+'\n'+student);
    }

    //查找某条数据
    @Test
    public void Test_doSelectById()
    {

        String study_id="java-666";
        List<Student> student=studentDAO.doSelectByStudy_id(study_id);
        logger.info("查询数据记录成功");
        System.out.println("查询的数据记录为：");
//        可能有study_id有重复，所有用for，each循环来输出，输出可能重复的记录
        for(Student stuAll:student)
        {
            System.out.println(stuAll);
        }
    }

    //查找全部数据
    @Test
    public void Test_doSelectAll()
    {
        List<Student> student= studentDAO.doSelectAll();
        logger.info("查询数据记录成功");
        System.out.println("查询全部数据记录成功,所有数据为：");
        for(Student stuAll:student)
        {
            System.out.println(stuAll);
        }
    }
}
/*这个是之前尝试的代码，留着后期完善；
public class TestSpringMybaits
{
    public static void main(String[]args)
    {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
//        StudentDAO studentDAO = (StudentDAO) applicationContext.getBean("studentDAO");

        SqlSessionFactory sqlSessionFactory=(SqlSessionFactory)applicationContext.getBean("sqlsqlSession");
        System.out.println(sqlSessionFactory);
//        List<Student> list= studentDAO.doSelectAll();
//        System.out.println(list);
    }
}*/

