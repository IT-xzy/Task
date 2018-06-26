package action;

import mybatis.mapper.PersonMapper;
import mybatis.model.Person;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.sql.SQLDataException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;
/*
 * 测试MybatisSpring整合
 * MybatisSpring 的 main主函数入口
 * 类：java/mybatis
 * XML：resources/mybatis
 *
 */

@Component
public class MybatisAction {

    @Autowired
    private PersonMapper personMapper;

    static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(MybatisAction.class.getName());

    String contextxml = "mybatis/springmybatis.xml";


    public static void main(String[] args){

        try {

            ApplicationContext conn = new ClassPathXmlApplicationContext("mybatis/springmybatis.xml");

            MybatisAction mybatisAction = (MybatisAction) conn.getBean("mybatisAction");

            logger.info("\n =========== \n" + mybatisAction.personMapper.selectById(2) + "\n =========== \n");

            Person p = new Person();
            p.setId(22);

            logger.info(mybatisAction.personMapper.selectByPerson(p));

        }catch (Exception e){
            e.fillInStackTrace();
//            抛出异常
//            throw e;
        }

    }

//  查找，修改，删除
    @Test
    public void testMybatis(){

//        获取上下文连接配置
        ApplicationContext context = new ClassPathXmlApplicationContext(contextxml);

//        获取bean
        MybatisAction mybatisAction = (MybatisAction) context.getBean("mybatisAction");

        Date date = new Date();
        SimpleDateFormat stm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Person p = new Person();
        p.setId(2);
        p.setName("测试修改");
        p.setQq(567892365);
//        p.setCreate_at(date.getTime());
        p.setUpdate_at(date.getTime());
        p.setAge(22);
        p.setEmail("1231@12.com");
        p.setPro("包揽全冠");
        p.setSex(1);
        p.setTell(139000);


//        mybatisAction.personMapper.insertPerson(p);
//        mybatisAction.personMapper.updatePerson(p);
//        mybatisAction.personMapper.deletePerson(3);

        Person person = mybatisAction.personMapper.selectById(2);
        System.out.print( person.toString() );


        stm.format(person.getCreate_at());
        stm.format(person.getUpdate_at());
//        String std = "创建时间为：" + stm.format(p.getUpdate_at()) + "\n";
//        String str = "修改时间为： " + stm.format(p.getUpdate_at()) + "\n";


//        for (int i=0;i<1000;i++){
//            System.out.print("\n" + mybatisAction.personMapper.selectById(i) + "\n");
////            mybatisAction.personMapper.deletePerson(i);
//        }

    }

//  单条数据修改 返回boolean 方法void
    @Test
    public void updateP(){

        boolean fblog = false;

        try {

            ApplicationContext context = new ClassPathXmlApplicationContext(contextxml);

            MybatisAction mybatisAction = (MybatisAction) context.getBean("mybatisAction");


            Person p = new Person();
            p.setId(44);
            p.setName("测试修改");
            p.setQq(85532);
            p.setAge(22);
            p.setEmail("7777@12.com");
            p.setPro("修改时间");
            p.setSex(1);
            p.setTell(138000);

            int upd = mybatisAction.personMapper.updatePerson(p);

            if(upd > 0){

                fblog = true;

                System.out.print("\n===更新成功===\n" + fblog);
            }


        }catch (Exception e){
            e.fillInStackTrace();
        }
//        finally {
//
//            return fblog;
//        }
//        return fblog;

    }


//    单条数据插入 返回id 方法void
    @Test
    public void insertOne(){

        int ins = 0;

        ApplicationContext context = new ClassPathXmlApplicationContext(contextxml);

        MybatisAction mybatisAction = (MybatisAction) context.getBean("mybatisAction");

            Person p = new Person();
    //        p.setId(40);
            p.setName("测试插入2");
            p.setQq(16231452);
            p.setAge(22);
            p.setEmail("7777@12.com");
            p.setPro("测试插入2");
            p.setSex(1);
            p.setTell(158000);

            try {

                ins = mybatisAction.personMapper.insertPerson(p);

//              logger.info( "\n" + mybatisAction.personMapper.insertPerson(p) + "\n");
//              Assert.assertEquals(p.getId(),41);

                System.out.print("新增数据id：" + p.getId() + "\n");


            }catch (Exception e){
                e.fillInStackTrace();
                System.err.print("新增数据未成功！");
            }

    }

    //  单条数据删除 返回boolean 方法void
    @Test
    public void deleteP(){

        boolean fblog = false;

        try {

            ApplicationContext context = new ClassPathXmlApplicationContext(contextxml);

            MybatisAction mybatisAction = (MybatisAction) context.getBean("mybatisAction");


            int upd = mybatisAction.personMapper.deletePerson(40);
            System.err.print(upd);
            if(upd > 0){

                fblog = true;

                System.out.print("\n===删除成功===\n" + fblog);
            }


        }catch (Exception e){
            e.fillInStackTrace();
        }
//        finally {
//
//            return fblog;
//        }

    }

//    批量插入
    @Test
    public void insertList(){

        ApplicationContext conn = new ClassPathXmlApplicationContext(contextxml);

        MybatisAction mybatisAction = (MybatisAction) conn.getBean("mybatisAction");

        Date date = new Date();

        Random random = new Random();

        int max = 30;
        int min = 20;
        String xing = "问";
        String ming = "天";
        Person pro = new Person();
        pro.setName("大师兄");

        List<Person> list = new ArrayList<Person>();

        for (int j = 0; j < 2; j++) {

            list.clear();

            for (int i = 0; i < 5; i++) {

                int xingshi = (int) (Math.random() * 11);
                int shi = (int) (Math.random() * 11);
                if (xingshi == 0) {
                    xing = "张";
                } else if (xingshi == 1) {
                    xing = "王";
                } else if (xingshi == 2) {
                    xing = "赵";
                } else if (xingshi == 3) {
                    xing = "李";
                } else if (xingshi == 4) {
                    xing = "吕";
                } else if (xingshi == 5) {
                    xing = "刘";
                } else if (xingshi == 6) {
                    xing = "诸葛";
                } else if (xingshi == 7) {
                    xing = "夏侯";
                } else if (xingshi == 8) {
                    xing = "乔";
                } else if (xingshi == 9) {
                    xing = "欧阳";
                } else if (xingshi == 10) {
                    xing = "孙";
                }
                if (shi == 0) {
                    ming = "良";
                } else if (shi == 1) {
                    ming = "楠";
                } else if (shi == 2) {
                    ming = "乾坤";
                } else if (shi == 3) {
                    ming = "天地";
                } else if (shi == 4) {
                    ming = "乾";
                } else if (shi == 5) {
                    ming = "村夫";
                } else if (shi == 6) {
                    ming = "飞龙";
                } else if (shi == 7) {
                    ming = "风";
                } else if (shi == 8) {
                    ming = "叶";
                } else if (shi == 9) {
                    ming = "子赣";
                } else if (shi == 10) {
                    ming = "孔明";
                }

                int age = random.nextInt(max) % (max - min + 1) + min;
                int sex = (int) (Math.random() * 2);
                Person u = new Person();
                u.setName(xing + ming);
                u.setCreate_at(date.getTime());
                u.setUpdate_at(date.getTime());
                u.setAge(age);
                u.setSex(sex);
                pro.setName(xing + ming);
                //            userMapper.insertUser(u);
                System.out.print("=====  xingshi:" + xing + ming + ",age:" + age + ",sex:" + sex + "  =====\n");
                System.out.print("------已插入第" + (i + 1) + "条数据------\n");
                System.out.print(list.toString());
                System.out.print("list.size():" + list.size() + "\n");

                list.add(u);
            }

            logger.info(mybatisAction.personMapper.insertPersonList(list));

            mybatisAction.personMapper.findAll();
        }




    }




}
