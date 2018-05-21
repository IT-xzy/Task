package com.ppteng;

import com.ppteng.service.CrudService;
import com.ppteng.service.CrudServiceImpl;
import com.ppteng.utils.FormatTime;
import org.apache.log4j.Logger;

import com.ppteng.bean.Student;
//特地写在前面：因为Spring JDBC Template 实现和其他方案有较多不同，所以一样的流程，main函数差别很大
//主要是因为Spring JDBC Template的查询功能比较弱小....如果对象不存在会抛出异常...不会正确返回flase（update的方法还算比较正常）
//其实可以用List的对象去接收然后判断size的方法解决，我这里没有用
//其实DAO层和Service层改的也挺多的....
//总结： 还是spring+mybatis的功能强大！做这个只是为了加深对SM框架的理解。

public class Main {

    public static void main(String[] args) {
        Logger logger = Logger.getLogger(Main.class);
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
            } catch (RuntimeException e){
                logger.info("->警告！"+ e.getMessage());
                logger.info("该学号为：  " + studentInsert.getNum());
            } catch (Exception e2) {
                logger.error("->插入信息时发生错误！");
            }
        }
        long endInsert = System.currentTimeMillis();
        logger.info("->完成所有插入，一共花费时间:  " + FormatTime.format(endInsert - startInsert));

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
            }    //其实这里的else没有什么意义，如果找不到会抛出异常，然后跳到catch部分。加上也可以，方便以后改需求。
        } catch (RuntimeException e){
            logger.info("->警告;"+e.getMessage());
        } catch (Exception e) {
            logger.error("->查询的时候发生错误！");
        }

        //主键查询
        Long selectID = 1L;
        try {
            logger.info("->成功找到ID为“" + selectID + "”的学员：\n" + service.findByPrimeKey(selectID));
        } catch (RuntimeException e){
            logger.info("->警告;"+e.getMessage());
            logger.info("该ID为： " + selectID);
        } catch (Exception e1) {
            logger.info("->查询的时候发生错误！");
        }

        //逐条更新
        long startUpdate = System.currentTimeMillis();
        Student studentUpdate = studentInsert;
        studentUpdate.setDeclaration("老大最帅");
        //不更新Num属性
        studentUpdate.setNum(null);
        for (long i = 1; i < 11; i++) {
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
        logger.info("->完成更新！一共花费时间： " + FormatTime.format(endUpdate - startUpdate) + "毫秒。");

        //清空表格，为下次测试做准备
        try {
            service.deleteAll();
            logger.info("->表格数据清理成功，随时可以进行下一次测试！");
        } catch (Exception e) {
            logger.error("->清理的时候发生错误！");
        }
    }
}
