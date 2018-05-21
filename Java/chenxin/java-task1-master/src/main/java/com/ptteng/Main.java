package com.ptteng;

import com.mysql.jdbc.CommunicationsException;
import com.ptteng.model.Student;
import com.ptteng.service.StudentService;
import com.ptteng.service.implement.StudentServiceImpl;
import org.apache.log4j.Logger;

import javax.naming.CommunicationException;
import java.net.ConnectException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Main {
    static Logger logger = Logger.getLogger(Main.class);
//    static SimpleDateFormat formatter = new SimpleDateFormat("yyyy年-MM月dd日-HH时mm分ss秒");

    public static void main(String[] args) throws ConnectException{
        Long currentTime = System.currentTimeMillis();
//        Date date = new Date(currentTime);
        StudentService studentService= new StudentServiceImpl();


//      查找

        try {
            List<Student> list=studentService.getStudentByName("燕");
            System.out.println(list);
            if (list.size() >0){
                logger.info("studentService.getStudentByName(\"王\");查找成功" +list);
            }else{
                logger.info("查找失败");
            }
        } catch (Exception e) {
            logger.info("查找操作出错");
            e.printStackTrace();
        }
        //新增
        Student student = new Student("王连喜", "38114135", "JAVA工程师", "2017年1月6日", "保定学院", "JAVA-2871", "http://www.jnshu.com/daily/45199?dailyType=others&total=37&page=1&cid=661&sort=0&orderBy=3", "陷阵之志", "雍金卫", "知乎");
        Long createTime = System.currentTimeMillis();
        student.setCreated_at(createTime);
        try {
            if (studentService.saveStudent(student)){
                logger.info("studentService.saveStudent(student数据保存成功" + '\n'+'\n'+student.toString());
            }else{
                logger.info("保存失败");
            }
        } catch (Exception e) {
            logger.info("保存操作异常");
            e.printStackTrace();
        }

        //更新
        long updateTime = System.currentTimeMillis();
            try {
                Student student1 = studentService.getStudentById(155L);
                student1.setName("燕捕头");
                student1.setNumber("23点45分");
                student1.setUpdated_at(updateTime);
                if (studentService.updateStudent(student1)) {
                    logger.info("操作studentService.updateStudent(student1)，执行成功" +'\n'+'\n'+studentService.getStudentById(155L));
                }else {
                    logger.info("studentService.getStudentById(155L)执行失败");
                }
            } catch (Exception e) {
                e.printStackTrace();
                logger.info("更新操作异常");
            }

//        删除
        try {
            if (studentService.removeStudent("王连喜")){
                logger.info("删除成功");
            }else{
                logger.info("删除失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("删除操作失败");
        }
        logger.info("Total cost time: " + (System.currentTimeMillis() - currentTime)  + "毫秒钟.");

    }
}
