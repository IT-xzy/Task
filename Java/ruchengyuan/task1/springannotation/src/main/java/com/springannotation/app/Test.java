package com.springannotation.app;

import com.springannotation.dao.StudentDao;
import com.springannotation.model.StudentMod;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * 这是一个运用mybatis和spring进行增删改查的main
 * Created by Administrator on 16/7/2017.
 */

public class Test {

    //把关于类Test的日志输出
    private static Logger logger = Logger.getLogger(Test.class);

    public static void main(String[] args) {

        /*
         * ApplicationContext生成工厂对象。加载bean配置文件
         * 利用框架提供的 ClassPathXmlApplicationContext API 去生成工厂 bean。
         * ClassPathXmlApplicationContext 负责生成和初始化所有的对象
         */
            ApplicationContext ctx =
                    new ClassPathXmlApplicationContext("ApplicationContext-c3p0.xml");
        //getBean() 方法得到所需要的 bean
        StudentDao studentDao = (StudentDao) ctx.getBean("studentDao");

        try {
            //批量查询
            logger.info("\n\n批量查找");
            //把返回的查询到的所有学员信息返回到list中
            List<StudentMod> studentList = studentDao.studentName();
            logger.info("List<StudentMod>:size = " + studentList.size());
            //输出学员信息到日志INFO
            for (StudentMod entityTemp : studentList) {
                logger.info(entityTemp.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("批量查询出错： " + e.getMessage());
        }

        try{
            //查找
            logger.info("\n\n测试查找");
            StudentMod studentMod = new StudentMod();
            studentMod.setUser_id("CSS-1111");
            //studentMod中传入参数ID
            //把返回的参数给予studentMod
            studentMod = studentDao.studySelect(studentMod);
            logger.info("查询参数\n"+ studentMod);
        }
        catch(Exception e){
            e.printStackTrace();
            logger.error("查询出错： " + e.getMessage());
        }

        try {
            //添加
            logger.info("测试增加");
            StudentMod studentMod2 = new StudentMod();
            //获取当前时间戳
            long entry_data = System.currentTimeMillis();
            //调用StudentDao的构造方法
            studentMod2.studentMod("JAVA-2222", "王华", 1, 112233, entry_data,"郑州大学",
                    "www.baidu.com","学习吧，少年","知乎",entry_data,entry_data);
            //执行查询方法
            studentDao.studyInsert(studentMod2);
        }catch(Exception e){
            e.printStackTrace();
            logger.error("增加出错： " + e.getMessage());
        }

        try {
            //修改
            System.out.println("测试修改");
            StudentMod studentMod4 = new StudentMod();
            //传入要修改的内容
            studentMod4.setName("华王");
            //传入Id
            studentMod4.setUser_id("JAVA-2222");
            long entry_data = System.currentTimeMillis();
            studentMod4.setUpdate_at(entry_data);
            //返回影响的行数i
            int i = studentDao.studyUpdate(studentMod4);
            logger.info("返回修改行数 ： " + i);
        }catch (Exception e){
            e.printStackTrace();
            logger.error("修改出错： " + e.getMessage());
        }

        try {
            //删除
            System.out.println("测试删除");
            //返回影响的行数i1
            int i1 = studentDao.studyDelete("JAVA-2222");
            logger.info("删除的的记录：" + i1);
        }catch (Exception e){
            e.printStackTrace();
            logger.error("删除出错： " + e.getMessage());
        }
    }
}
