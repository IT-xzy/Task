package cc.myhome.jdbctemplate.service;

import java.util.Scanner;

import static java.lang.System.*;

import java.util.List;
import java.util.Map;

import cc.myhome.model.Network1;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import cc.myhome.jdbctemplate.dao.Dao;

public class TemplateDemo2 {
    private static ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");;
    private static Dao dao = (Daoimpl2) ctx.getBean("dao");
/**
 * 为何在此处加载，运行时会跳过这个区块。
    {
        ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        dao = ((Daoimpl2)) ctx.getBean("dao");
    }
 */


    public static void main(String[] args) {



        Scanner console = new Scanner(System.in);
        while (true) {
            out.print("（1）显示所有学生信息  （2）添加学生信息   （3）根据学号查询     （4）根据姓名查询 ");
            switch (Integer.parseInt(console.nextLine())) {
                case 1:
                    List rows = dao.selectAll();
                    for (int i = 0; i < rows.size(); i++) {
                        Map stu = (Map) rows.get(i);
                        out.print(stu.get("Line_id") + " ");
                        out.print(stu.get("Name") + " ");
                        out.print(stu.get("QQ") + " ");
                        out.print(stu.get("Type") + " ");
                        out.print(stu.get("Enrolment_time") + " ");
                        out.print(stu.get("Graduate") + " ");
                        out.print(stu.get("Report_link") + " ");
                        out.print(stu.get("Wish") + " ");
                        out.print(stu.get("Senior") + " ");
                        out.print(stu.get("How_know") + " ");
                        out.print(stu.get("Create_at") + " ");
                        out.print(stu.get("Update_at") + " ");
                        out.println();
                    }
                    break;

                case 2:
                    Network1 stu = new Network1();
                    out.print("姓名：");
                    stu.setName(console.nextLine());
                    out.print("QQ号：");
                    stu.setQQ(console.nextLine());
                    out.print("学习类型：");
                    stu.setType(console.nextLine());
                    out.print("预计入学时间：");
                    stu.setEnrolmentTime(console.nextLine());
                    out.print("毕业院校：");
                    stu.setGraduate(console.nextLine());
                    out.print("日报链接：");
                    stu.setReportLink(console.nextLine());
                    out.print("辅导师兄：");
                    stu.setSenior(console.nextLine());
                    out.print("立志：");
                    stu.setWish(console.nextLine());
                    out.print("从何得知IT修真院：");
                    stu.setHowKnow(console.nextLine());
                    out.print("创建时间：");
                    stu.setCreateAt(Long.parseLong(console.nextLine()));
                    out.print("更新时间：");
                    stu.setUpdateAt(Long.parseLong(console.nextLine()));
                    dao.insert(stu);
                    break;

                case 3:
                    out.print("请输入想查询的学生学号：");
                    long id = Long.parseLong(console.nextLine());
                    Map stu1 = dao.selectById(id);
                    out.print(stu1.get("Line_id") + " ");
                    out.print(stu1.get("Name") + " ");
                    out.print(stu1.get("QQ") + " ");
                    out.print(stu1.get("Type") + " ");
                    out.print(stu1.get("Enrolment_time") + " ");
                    out.print(stu1.get("Graduate") + " ");
                    out.print(stu1.get("Report_link") + " ");
                    out.print(stu1.get("Wish") + " ");
                    out.print(stu1.get("Senior") + " ");
                    out.print(stu1.get("How_know") + " ");
                    out.print(stu1.get("Create_at") + " ");
                    out.print(stu1.get("Update_at") + " ");
                    out.println();
                    break;

                case 4:
                    out.print("请输入想查询的学生姓名：");
                    String name = console.nextLine();
                    List rows1 = dao.selectByName(name);
                    for (int i = 0; i < rows1.size(); i++) {
                        Map stu2 = (Map) rows1.get(i);
                        out.print(stu2.get("Line_id") + " ");
                        out.print(stu2.get("Name") + " ");
                        out.print(stu2.get("QQ") + " ");
                        out.print(stu2.get("Type") + " ");
                        out.print(stu2.get("Enrolment_time") + " ");
                        out.print(stu2.get("Graduate") + " ");
                        out.print(stu2.get("Report_link") + " ");
                        out.print(stu2.get("Wish") + " ");
                        out.print(stu2.get("Senior") + " ");
                        out.print(stu2.get("How_know") + " ");
                        out.print(stu2.get("Create_at") + " ");
                        out.print(stu2.get("Update_at") + " ");
                        out.println();
                    }
                    break;


            }
        }


    }
}
