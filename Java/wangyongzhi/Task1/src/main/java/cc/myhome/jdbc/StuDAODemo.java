package cc.myhome.jdbc;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;


import static java.lang.System.out;

public class StuDAODemo {
   // public static Logger logger = LogManager.getLogger(StuDAODemo.class);

    public static void main(String[] args) {

        StuDAO dao = new StuDAO("jdbc:mysql://localhost:3306/stu_info?" +
                "useUnicode=true&characterEncoding=UTF8&useSSL=false&serverTimezone=Hongkong",
                "root", "123456");
    //    logger.info("连接加载成功。");
        Scanner console = new Scanner(System.in);
        while (true) {
            out.print("（1）显示所有学生信息  （2）添加学生信息   （3）根据学号查询     （4）根据姓名查询 ");
            switch (Integer.parseInt(console.nextLine())) {
                case 1:
                    dao.getAll().forEach(stu -> {
                        out.printf("%d %s %s %s %s %s %s %s %s %s %d %d %n",
                                stu.getLine_id(),
                                stu.getName(),
                                stu.getQQ(),
                                stu.getType(),
                                stu.getTime(),
                                stu.getSchool(),
                                stu.getLink(),
                                stu.getWish(),
                                stu.getSenior(),
                                stu.getHow(),
                                stu.getCreate(),
                                stu.getUpdate());
                    });
                    break;

                case 2:
                    out.print("姓名：");
                    String name = console.nextLine();
                    out.print("QQ号：");
                    String qq = console.nextLine();
                    out.print("学习类型：");
                    String type = console.nextLine();
                    out.print("预计入学时间：");
                    String time = console.nextLine();
                    out.print("毕业院校：");
                    String school = console.nextLine();
                    out.print("日报链接：");
                    String link = console.nextLine();
                    out.print("辅导师兄：");
                    String senior = console.nextLine();
                    out.print("立志：");
                    String wish = console.nextLine();
                    out.print("从何得知IT修真院：");
                    String how = console.nextLine();
                    out.print("创建时间：");
                    long create = Long.parseLong(console.nextLine());
                    out.print("更新时间：");
                    long update = Long.parseLong(console.nextLine());
                    dao.add(new Stu(name, qq, type, time, school, link, senior, wish, how, create, update));
                    break;

                case 3:
                    out.print("请输入想要查询的学生学号：");
                    long id = Long.parseLong(console.nextLine());
                    Stu stu = dao.getById(id);
                    out.printf("%d %s %s %s %s %s %s %s %s %s %d %d %n",
                            stu.getLine_id(),
                            stu.getName(),
                            stu.getQQ(),
                            stu.getType(),
                            stu.getTime(),
                            stu.getSchool(),
                            stu.getLink(),
                            stu.getWish(),
                            stu.getSenior(),
                            stu.getHow(),
                            stu.getCreate(),
                            stu.getUpdate());
                    break;


                case 4:
                    out.print("请输入想要查询的学生姓名：");
                    String name2 = console.nextLine();
                    dao.getByName(name2).forEach(stu2 -> {
                        out.printf("%d %s %s %s %s %s %s %s %s %s %d %d %n",
                                stu2.getLine_id(),
                                stu2.getName(),
                                stu2.getQQ(),
                                stu2.getType(),
                                stu2.getTime(),
                                stu2.getSchool(),
                                stu2.getLink(),
                                stu2.getWish(),
                                stu2.getSenior(),
                                stu2.getHow(),
                                stu2.getCreate(),
                                stu2.getUpdate());
                    });
                    break;
            }


        }
    }
}
