package com.hzw.test;

import com.hzw.mapper.StudentMapper;
import com.hzw.pojo.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.logging.Logger;

public class TestStudentMapper {
    //把关于类Test的日志输出
    private static Logger logger = Logger.getLogger(String.valueOf(TestStudentMapper.class));

    public static void main(String[] args) {
        /**
         * ApplicationContext生成工厂对象。加载bean配置文件
         * 利用框架提供的 ClassPathXmlApplicationContext API 去生成工厂 bean。
         * ClassPathXmlApplicationContext 负责生成和初始化所有的对象
         */
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        //getBean() 方法得到所需要的 bean
        StudentMapper studentMapper = (StudentMapper) ac.getBean("studentMapper");

        //添加
        try{
            logger.info("================测试添加===============");
            Student stu = new Student();
            //获取时间戳
            long time = System.currentTimeMillis();
//            stu.Student("曹嘉懿",847368124,"PM",666,time,time);
            stu.setS_name("曹嘉懿");
            stu.setS_qq(847368124);
            stu.setS_type("PM");
            stu.setS_num(666);
            stu.setCreate_at(time);
            stu.setUpdate_at(time);
            studentMapper.addStu(stu);
            long id = stu.getS_id();
            logger.info("插入数据的ID是："+id);
        }catch (Exception e){
            e.printStackTrace();
            logger.info("插入数据失败"+e.getMessage());
        }

        //删除
        try{
            logger.info("================测试删除===============");
            long s_id = 35;
//            boolean b = studentMapper.deleteStu(s_id);
            studentMapper.deleteStu(s_id);
//            logger.info("删除返回结果=="+b);
        }catch (Exception e){
            e.printStackTrace();
            logger.info("删除数据失败"+e.getMessage());
        }

        //更新
        try{
            logger.info("================测试更新===============");
            Student stu1 = new Student();
            long time = System.currentTimeMillis();
            stu1.setS_id(33);
            stu1.setS_name("刘亦菲");
            stu1.setS_qq(343454676);
            stu1.setS_type("QA");
            stu1.setS_num(999);
            stu1.setUpdate_at(time);
//            boolean b = studentMapper.updateStu(stu1);
            studentMapper.updateStu(stu1);
//            logger.info("更新返回结果=="+b);
        }catch (Exception e){
            e.printStackTrace();
            logger.info("更新数据失败"+e.getMessage());
        }

        //根据姓名，学号查询
        try{
            logger.info("================测试查询NAME+NUM===============");
            Student stu = new Student();
            stu.Student("李龙",587);
            List<Student> list = studentMapper.getName(stu);
            for (Student s:list){
                logger.info("查询结果为===="+s);
            }
        }catch (Exception e){
            e.printStackTrace();
            logger.info("查询数据失败"+e.getMessage());
        }

        //查询ID
        try{
            logger.info("================测试查询ID===============");
            long s_id = 33;
            Student stu = studentMapper.getId(s_id);
            logger.info("查询ID结果\n"+stu);
        }catch (Exception e){
            e.printStackTrace();
            logger.info("查询数据ID失败"+e.getMessage());
        }

        //查询全部
        try{
            logger.info("================测试查询===============");
            List<Student> list = studentMapper.getAll();
            for(Student stu:list){
                logger.info(stu.toString());
            }
        }catch (Exception e){
            e.printStackTrace();
            logger.info("查询数据失败"+e.getMessage());
        }
    }
}
