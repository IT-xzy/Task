package com.ev;

import com.ev.bean.Student;
import com.ev.service.StudentService;
import com.ev.service.impl.StudentServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.dao.DuplicateKeyException;

import java.util.List;


public class Main {

    public static void main(String[] args) {

        Logger logger = Logger.getLogger(Main.class.getName());
        StudentService studentService = new StudentServiceImpl();
        Student studentInsert = new Student("刘伟", "男", 22, "1059707455", "pm", 20180130L, "湖北大学", "pm-1041", "http://www.jnshu.com/school/21247/daily", "砥砺前行", "[北京分院|首席弟子]PM-刘骁");

        //插入11条数据
        long startInsert = System.currentTimeMillis();
        for (int i = 0; i < 11; i++) {
            try {
                logger.info("->Succeed adding a student whose id is " + studentService.addAStudent(studentInsert));
            } catch (DuplicateKeyException e) {
                logger.info("-->WARNING" + e.getMessage());
                logger.debug("-->The number of this student   is " + studentInsert.getNumber() + ".");
            } catch (Exception ex) {
                logger.error(ex.getClass().getSimpleName());
                logger.error("-->Error happens when adding.");
            }
        }
        long endInsert = System.currentTimeMillis();
        logger.info("-->All inserts done ,it costs " + (endInsert - startInsert) + " ms.");

        //删除指定id为11的学员
        try {
            long deleteId = 11L;
            if (studentService.deleteAStudent(deleteId))
                logger.info("-->Delete student successfully, the id is " + deleteId + ".");
            else
                logger.debug("-->Delete student whose id is " + deleteId + " failed, the student doesn't exist! ");
        } catch (Exception e) {
            logger.error(e.getClass().getSimpleName());
            logger.error("-->Error happens when deleting.");
        }

        //使用学号精确查询
        try {
            String selectNum = "pm-1041";
            List<Student> studentByNum;
            studentByNum = studentService.findAStudentByNumber(selectNum);
            if (studentByNum != null) {
                logger.info("-->Succeed finding the student whose id is " + selectNum + "\n" + studentByNum + ".");
            } else {
                logger.debug("-->Querying failed to find a student whose id is " + selectNum + ".");
            }
        } catch (Exception e) {
            logger.error(e.getClass().getSimpleName());
            logger.error("-->Error happens when querying student bu number");
        }

        //主键查询
        try {
            long selectID = 1L;
            List<Student> studentByID;
            studentByID = studentService.findByPrimeKey(selectID);
            if (studentByID != null) {
                logger.info("-->Succeed finding a student(s) whose id is " + selectID + "\n" + studentByID + ".");
            } else
                logger.debug("-->Querying failed to find a student whose id is " + selectID + ".");
        } catch (Exception e) {
            logger.error(e.getClass().getSimpleName());
            logger.info("-->Error happens when querying student by id");
        }

        //姓名模糊查询
        try {
            String name = "刘伟";
            List<Student> studentByName;
            studentByName = studentService.findAStudentsByName(name);
            if (studentByName!=null){
                logger.info("-->Succeed finding a student(s) whose name is " + name + "\n" + studentByName + ".");
            }else {
                logger.debug("-->Querying failed to find a student whose name is " + name + ".");
            }
        }catch (Exception e){
            logger.error(e.getClass().getSimpleName());
            logger.info("-->Error happens when querying student by name");
        }

        //逐条更新
        long startUpdate = System.currentTimeMillis();
        Student studentUpdate = studentInsert;
        studentUpdate.setDeclaration("老大最帅");
        //不更新Num属性
        studentUpdate.setNumber(null);
        for (long i = 1; i <= 11; i++) {
            studentUpdate.setId(i);
            studentUpdate.setUpdateAt(System.currentTimeMillis());
            try {
                if (studentService.updateInformation(studentUpdate)) {
                    logger.info("-->Succeed updating information of student whose id is " + i + "!");
                } else {
                    logger.debug("-->Failed updating information of student whose id is " + i + "!");
                }
            } catch (Exception e) {
                logger.error(e.getClass().getSimpleName());
                logger.error("-->Error happens when updating.");
            }
        }
        long endUpdate = System.currentTimeMillis();
        logger.info("-->Updating complete ,it costs " + (endUpdate - startUpdate) + " ms.");

        //清空表格，为下次测试做准备
//        try {
//            studentService.reset();
//            logger.info("-->Table has been reset, ready for another test.");
//        } catch (Exception e) {
//            logger.error(e.getClass().getSimpleName());
//            logger.error("-->Error happens when resetting the table.");
//        }
    }

}
