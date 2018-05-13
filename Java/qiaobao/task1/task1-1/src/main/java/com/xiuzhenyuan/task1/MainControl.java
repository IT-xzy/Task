package com.xiuzhenyuan.task1;


import com.xiuzhenyuan.task1.tool.PrintFormat;
import com.xiuzhenyuan.task1.model.StudentDO;
import com.xiuzhenyuan.task1.service.StudentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class MainControl {
    //    Logger类不允许实例化一个新的记录器实例，但它提供了两个静态方法获得一个 Logger 对象：
    private static Logger log = Logger
            .getLogger(MainControl.class.getName());
    //        加载spring bean容器，管理对象
    ApplicationContext act = new ClassPathXmlApplicationContext("SpringConfig.xml");
    StudentService studentService = (StudentService) act.getBean("serviceImple");

    public static void main(String[] args) {
        MainControl mainControl = new MainControl();

        mainControl.getOne(1);

        mainControl.selectLike("宇",3);

        mainControl.save("小张伟",156844112,"sdhfjusu45552",20180422,"西南大学",
                3456,"大张伟","web","发发发");

        mainControl.delete(5);

        mainControl.update(1,"pm");

        List<StudentDO> stu =new ArrayList<StudentDO>();
        StudentDO studentDO1 =new StudentDO("孙虎3", 1586974154, "pm", 20180413, "中南大学",
                3699, "ahduad5561", "胜天", "旺旺", System.currentTimeMillis());
        StudentDO studentDO2 =new StudentDO("孙虎4", 1586974154, "pm", 20180413, "中南大学",
                3699, "ahduad5561", "胜天", "旺旺", System.currentTimeMillis());
        stu.add(studentDO1);
        stu.add(studentDO2);
        mainControl.bacthSave(stu);
    }

    /**
     *填入student字段信息
     */
    public void save( String name,int qq,String dailyLink,int entorTime,String graduateSchlool, int netId,String senior,String type,String wish){
        try {
            log.info("数据插入成功，返回ID" +studentService.saveStudent(name,qq,dailyLink,entorTime,graduateSchlool,netId,senior,type,wish));
        } catch (Exception e) {
            log.info("用户名已存在，请重新输入！！！！！！！" );
            log.info("异常原因：" + e.getMessage());
//            e.printStackTrace();
        }
    }
    /**
     *根据id获取学员信息
     */

    public void getOne(int addID) {
        PrintFormat printFormat =new PrintFormat();
        StudentDO studentDO= studentService.getStudent(addID);
        if (studentDO != null) {
            printFormat.printf(studentDO);
        } else {
            log.info("id名不存在，查无此人！");
        }
    }

    /**
     *更新type字段
     */
    public void update(int addId,String type) {
        System.out.println(studentService.updateStudent(addId, type));
    }

    /**
     * 删除信息
     * @param addId
     */
    public void delete(int addId){
        System.out.println(studentService.deleteStudentByAddId(addId));
    }

    /**
     *模糊查询
     */
    public void selectLike(String name,int netId){
        PrintFormat printFormat =new PrintFormat();
        List<StudentDO> stu = studentService.selectLikeNameNetId(name, netId);
        if(stu !=null){
            for (StudentDO studentDO1 : stu) {
                printFormat.printf(studentDO1);
            }
        }else {
            log.info("没有符合要求的学员信息");
        }

    }
    /**
     * 批量插入
     * @param stu
     */
    public void bacthSave(List<StudentDO> stu){
        try{
            log.info("成功插入数据："+studentService.studentBatchInsert(stu)+"条");
        }catch (Exception e){
            log.info("兄弟姓名重复了！！！！" );
            log.info("异常原因：" + e.getMessage());
//            e.printStackTrace();
        }

    }
}



