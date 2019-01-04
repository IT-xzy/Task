package com.jnshu.server;

import com.jnshu.server.po.Students;
import com.jnshu.server.service.BeanService;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.Iterator;
import java.util.List;

public class MainStudent{
    private static Logger logger = Logger.getLogger(MainStudent.class);
    ApplicationContext context =
            new ClassPathXmlApplicationContext ("springConfig/spring-db.xml");

    BeanService beanService=(BeanService)context.getBean ("BeanServiceMain") ;
    Students students=new Students ();
    long timeStamp = System.currentTimeMillis();  //获取当前时间戳,也可以是你自已给的一个随机的或是别人给你的时间戳(一定是long型的数据)

    //    插入数据
    public void insert(){
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
            logger.warn ("插入成功");
            System.out.println ("新插入数据的ID是："+students.getId ());
        }catch ( Exception e){
            e.printStackTrace ();
        }
    }
//    删除数据
    public void delect(){
        try{
//            System.out.println ("请输入需要删除学员信息的id：");
//            Scanner s = new Scanner(System.in);
//            int i = s.nextInt ();
            int i=4;
            boolean  rs= beanService.deleteStudents (i);
            logger.warn ("已删除第"+i+"条");
            System.out.println (rs);
        }catch ( Exception e ) {
            e.printStackTrace ();
        }
    }
//    更新整条信息
    public void update(){
        try{
            int i=3;
            students.setId (i);
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
            boolean rs=beanService.updateStudents (students);
            logger.warn ("第"+i+"条更新成功");
            System.out.println (rs);
        }catch ( Exception e ) {
            e.printStackTrace ();
        }
    }
//    更新某几项信息
    public void updatePast(){
        try{
            int i=5;
            students.setUpdateAt (timeStamp);
            students.setStudentName ("神秘男子");
            students.setProfession ("Java11");
            students.setId (i);
            boolean rs= beanService.updateOne (students);
            logger.warn ("第"+i+"条的部分信息更新成功");
            System.out.println (rs);
        }catch ( Exception e ) {
            e.printStackTrace ();
        }
    }
//    通过ID查询学员信息
    public void selectById(){
        try{
            int i=1;
            students= beanService.selectStudents (i);
            logger.warn ("查询ID为"+i+"的学员");
            System.out.println (students.toString ());
        }catch ( Exception e ) {
            e.printStackTrace ();
        }
    }
//    通过姓名查询学员信息
    public void selectByName(){
        try{
//            System.out.println ("请输入需要查询学员的姓名：");
//            Scanner s = new Scanner(System.in);
//            String nm = s.nextLine ();
            String nm="苏正荣";
            students.setStudentName (nm);
            List<Students> students1=beanService.selectIf (students);
            Iterator<Students> iter = students1.iterator();
            logger.warn ("查询姓名为"+nm+"的学员");
            while(iter.hasNext()) {
                System.out.println(iter.next());
            }
        }catch ( Exception e ) {
            e.printStackTrace ();
        }

    }
//    通过学号查询学员信息
    public void selectByStundentId(){
        try{
//            System.out.println ("请输入需要查询学员的学号：");
//            Scanner s = new Scanner(System.in);
//            String id = s.nextLine ();
            String id=("Android-591");
            students.setStudentId (id);
            List students1=beanService.selectIf (students);
            Iterator<Students> iter = students1.iterator();
            logger.warn ("查询学号为"+id+"的学员");
            for (Object rs:students1) {
                System.out.println (rs.toString ());
            }
        }catch ( Exception e ) {
            e.printStackTrace ();
        }
    }
//    批量插入信息
    public void batchInsert() {
        long start = System.currentTimeMillis ();
        int runtime=1;
        int length = 5;
        try{
            for (int j=0;j<runtime;j++){
                Students[] stArry = new Students[length];
                for (int i=0;i<length;i++){
                    stArry[i] = new Students ();
                    stArry[i].setCreateAt (timeStamp);
                    stArry[i].setUpdateAt (timeStamp);
                    stArry[i].setStudentName ("苏正荣");
                    stArry[i].setQq ("2210126316");
                    stArry[i].setProfession ("Android工程师");
                    stArry[i].setAdmissionDate ("2018年9月16日");
                    stArry[i].setGraduatedFrom ("淮海工学院东港学院");
                    stArry[i].setStudentId ("Android-591");
                    stArry[i].setDailyLink ("http://www.jnshu.com/school/23273/daily");
                    stArry[i].setMakeWishes ("老大最帅的");
                    stArry[i].setCoachingSenior ("汪开放");
                    stArry[i].setApproach ("知乎");
                }
                beanService.batchInsert (stArry);
            }
            long end = System.currentTimeMillis ();
            System.out.println ("插入一条数据并且循环" +length*runtime + "次\n" + "使用连接池所用的时间为" + (end - start)/1000 + "秒\n");

        }catch ( Exception e ) {
            e.printStackTrace ();
        }
        System.out.println ("执行完毕");
    }
    public static void main(String[] args) {
       MainStudent ms=new MainStudent ();
       ms.insert ();
        ms.batchInsert ();
       ms.delect ();
       ms.update ();
       ms.updatePast ();
       ms.selectById ();
       ms.selectByName ();
       ms.selectByStundentId ();

    }
}
