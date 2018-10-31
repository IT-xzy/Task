package test;

//import com.jnshu.server.MainStudent;
import com.jnshu.server.po.Students;
import com.jnshu.server.service.BeanService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.apache.log4j.Logger;

import java.text.SimpleDateFormat;
import java.util.*;

//@RunWith就是一个运行器，@RunWith(JUnit4.class)就是指用JUnit4来运行
//@RunWith(SpringJUnit4ClassRunner.class)是指让测试运行于Spring测试环境
@RunWith(SpringJUnit4ClassRunner.class)
//Spring整合JUnit4测试时，使用注解@ContextConfiguration引入一个或多个配置文件
@ContextConfiguration(locations={"classpath:springConfig/spring-db.xml"})
public class MainTest {
    private static Logger logger = Logger.getLogger(MainTest.class);
//    ApplicationContext context =
//            new ClassPathXmlApplicationContext ("springConfig/spring-db.xml");
//    BeanService beanService=(BeanService)context.getBean ("BeanServiceMain") ;
@Autowired
private BeanService beanService;
    Students students=new Students ();
    long timeStamp = System.currentTimeMillis();  //获取当前时间戳,也可以是你自已给的一个随机的或是别人给你的时间戳(一定是long型的数据)
    @Test
    public void testSelectAll(){
        List rt=beanService.selectAll ();
        System.out.println (rt);
        Iterator<Students> iter = rt.iterator();
        logger.info ("查询成功");
        while(iter.hasNext()) {
            System.out.println(iter.next());
        }
    }

//    @Test
////    分页查询
//    public void testSelectInfoByMap() {
//        Map<String, Object> map = new HashMap<String, Object> ();
//        map.put ("start", 0);
//        map.put ("pagesize", 4);
//        List<Students> re = beanService.selectInfoByMap (map);
//        for (Students ui : re) {
//            System.out.println (ui);
//        }
//    }
    @Test
//    通过姓名查询学员信息
    public void testSelectByName(){
        try{
            students.setStudentName ("苏正荣");
            List<Students> students1=beanService.selectIf (students);

            Iterator<Students> iter = students1.iterator();
            logger.info ("查询成功");
            while(iter.hasNext()) {
                System.out.println(iter.next());
            }
        }catch ( Exception e ) {
            e.printStackTrace ();
        }

    }


    @Test
//    插入数据
    public void testInsert(){
        try{
            students.setCreateAt (timeStamp);
            students.setUpdateAt (timeStamp);
            students.setStudentName ("苏正荣");
            students.setQq ("2210126316");
            students.setProfession ("Android工程师");
            students.setAdmissionDate ("2018年9月16日");
            students.setGraduatedFrom ("淮海工学院东港学院");
            students.setStudentId ("Android-591");
            students.setDailyLink ("http://www.jnshu.com/school/23273/daily");
            students.setMakeWishes ("老大最帅的");
            students.setCoachingSenior ("汪开放");
            students.setApproach ("知乎");
            beanService.insertStudents (students);
            logger.info ("插入成功");
            System.out.println ("新插入数据的ID是："+students.getId ());
        }catch ( Exception e){
            e.printStackTrace ();
        }
    }
    @Test
//    删除数据
    public void testDelect(){
        try{
            boolean  rs= beanService.deleteStudents (2);
            logger.info ("删除成功");
            System.out.println (rs);
        }catch ( Exception e ) {
            e.printStackTrace ();
        }
    }
    @Test
//    更新整条信息
    public void testUpdate(){
        try{
            students.setId (3);
            students.setUpdateAt (timeStamp);
            students.setStudentName ("神秘嘉宾");
            students.setQq ("494357733");
            students.setProfession ("Android工程师");
            students.setAdmissionDate ("2018年9月17日");
            students.setGraduatedFrom ("西南交通大学");
            students.setStudentId ("??????");
            students.setDailyLink ("??????");
            students.setMakeWishes ("加油");
            students.setCoachingSenior ("[北京分院|真传弟子] PM-张新然");
            students.setApproach ("知乎");
            boolean rs=beanService.updateOneStudents (students);
            logger.info ("更新成功");
            System.out.println (rs);
        }catch ( Exception e ) {
            e.printStackTrace ();
        }
    }
    @Test
//    更新某几项信息
    public void testUpdatePast(){
        try{
            students.setUpdateAt (timeStamp);
            students.setStudentName ("神秘男子");
            students.setProfession ("Java11");
            students.setId (3);
            boolean rs= beanService.update (students);
            logger.info ("更新成功");
            System.out.println (rs);
        }catch ( Exception e ) {
            e.printStackTrace ();
        }
    }
//    @Test
//    通过ID查询学员信息
//    public void testSelectById(){
//        try{
//            Students rt= beanService.selectStudents (1);
//            logger.error ("查询成功");
//            System.out.println (rt.toString ());
//        }catch ( Exception e ) {
//            e.printStackTrace ();
//        }
//    }

    @Test
//    通过学号查询学员信息
    public void testSelectByStundentId(){
        try{
            students.setStudentId ("Android-591");
            List students1=beanService.selectIf (students);
            Iterator<Students> iter = students1.iterator();
            logger.info ("查询成功");
            for (Object rs:students1) {
                System.out.println (rs);
            }
        }catch ( Exception e ) {
            e.printStackTrace ();
        }
    }
//    @Test
////    批量插入信息
//    public void testBatchInsert() {
//        long start = System.currentTimeMillis ();
//        int runtime=1;
//        int length = 5;
//        try{
//            for (int j=0;j<runtime;j++){
//                Students[] stArry = new Students[length];
//                for (int i=0;i<length;i++){
//                    stArry[i] = new Students ();
//                    stArry[i].setCreateAt (timeStamp);
//                    stArry[i].setUpdateAt (timeStamp);
//                    stArry[i].setStudentName ("苏正荣");
//                    stArry[i].setQq ("2210126316");
//                    stArry[i].setProfession ("Android工程师");
//                    stArry[i].setAdmissionDate ("2018年9月16日");
//                    stArry[i].setGraduatedFrom ("淮海工学院东港学院");
//                    stArry[i].setStudentId ("Android-591");
//                    stArry[i].setDailyLink ("http://www.jnshu.com/school/23273/daily");
//                    stArry[i].setMakeWishes ("老大最帅的");
//                    stArry[i].setCoachingSenior ("汪开放");
//                    stArry[i].setApproach ("知乎");
//                }
//                beanService.batchInsert (stArry);
//                System.out.println ("循环"+j+"次");
//            }
//            long end = System.currentTimeMillis ();
//            System.out.println ("插入一条数据并且循环" +length*runtime + "次\n" + "使用连接池所用的时间为" + (end - start)/1000 + "秒\n");
//
//        }catch ( Exception e ) {
//            System.out.println ("出现意外");
//            e.printStackTrace ();
//        }
//        System.out.println ("执行完毕");
//    }
}
