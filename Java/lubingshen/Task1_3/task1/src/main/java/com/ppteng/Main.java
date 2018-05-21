package com.ppteng;

import com.ppteng.service.CrudService;
import com.ppteng.service.CrudServiceImpl;
import org.apache.log4j.Logger;

import com.ppteng.pojo.Student;

public class Main {
    private static Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        CrudService service = new CrudServiceImpl();
        long startInsert = System.currentTimeMillis();
        Student studentInsert = new Student(
                "曲艳行", "3169119846", "JAVA工程师",
                "11月18日--11月22日", "燕山大学", "java-",
                "http://www.jnshu.com/daily/40038?dailyType=others&total=8&page=1&uid=18143&sort=0&orderBy=3",
                "努力努力再努力！", "郑州分院王鹏举", "知乎");
        studentInsert.setCreateAt(System.currentTimeMillis());
        for (int i = 1; i < 10; i++) {
            //因为num(在线学号)是唯一索引
            studentInsert.setNum("java-" + i);
            try {
                logger.debug("->成功插入一条信息，该学员的学号是： " + service.addAStudent(studentInsert));
            } catch (Exception e) {
                logger.error("->插入信息时发生错误！");
            }
        }
        long endInsert = System.currentTimeMillis();
        logger.info("->完成所有插入，一共花费时间:  " + (endInsert - startInsert) + "毫秒。");

        //删除
        try {
            long deleteId = 1L;
            if (service.deleteAStudent(deleteId)) {
                logger.info("->成功删除一条学员信息，该学员的ID是" + deleteId);
            } else {
                logger.info("->删除失败，ID为" + deleteId + "的学员不存在！");
            }
        } catch (Exception e) {
            logger.error("->删除信息时发生错误！");
        }

        //使用学号精确查询
        try {
            String selectNum = "java-5";
            Student studentByNum;
            studentByNum = service.findAStudentByNum(selectNum);
            if (studentByNum != null) {
                logger.info("->成功找到线上学号为“" + selectNum + "”的学员：\n" + studentByNum);
            } else {
                logger.info("->查询失败，线上学号为" + selectNum + "的学员不存在！");
            }
        } catch (Exception e) {
            logger.error("->查询的时候发生错误！");
        }

        //主键查询
        try {
            Long selectID = 1L;
            Student studentByID;
            studentByID = service.findByPrimeKey(selectID);
            if (studentByID != null)
                logger.info("->成功找到ID为“" + selectID + "”的学员：\n" + studentByID);
            else
                logger.info("->查询失败，ID为" + selectID + "的学员不存在！");
        } catch (Exception e) {
            logger.info("->查询的时候发生错误！");
        }

        //逐条更新
        long startUpdate = System.currentTimeMillis();
        Student studentUpdate = studentInsert;
        studentUpdate.setDeclaration("老大最帅");
        //不更新Num属性
        studentUpdate.setNum(null);
        for (long i = 1; i < 10; i++) {
            studentUpdate.setId(i);
            try {
                if (service.updateInformation(studentUpdate)) {
                    logger.debug("->ID为" + i + "的学员信息更新成功！");
                } else {
                    logger.info("->ID为" + i + "的学员信息更新失败！");
                }
            } catch (Exception e) {
                logger.error("->更新的时候发生异常！");
            }
        }
        long endUpdate = System.currentTimeMillis();
        logger.info("->完成更新！一共花费时间： " + (endUpdate - startUpdate) + "毫秒。");

        //清空表格，为下次测试做准备
        try {
            service.deleteAll();
            logger.info("表格数据清理成功，随时可以进行下一次测试！");
        } catch (Exception e) {
            logger.error("->清理的时候发生错误！");
        }
    }
}
