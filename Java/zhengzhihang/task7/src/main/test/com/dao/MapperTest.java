package com.dao;
import com.pojo.OcT;
import com.pojo.Occupation;
import com.pojo.Trainees;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-mybatis.xml")
public class MapperTest {
    private static Logger logger = Logger.getLogger(MapperTest.class);
    @Autowired
    private Mapper mp;
    private int i;
    private Trainees trainees;

    @Test
    public void accountTrainees() {
        i=mp.accountTrainees();
        logger.info(i);
    }

    @Test
    public void countWork() {
        i=mp.countWork();
        logger.info(i);
    }
//接口有参数，测试类不需要参数
    @Test
    public void lessonCount() {
        i=mp.lessonCount(1);
        logger.info(i);
    }

    @Test
    public void niceTrainees() {
        List<Trainees> traineesList;
        traineesList=mp.niceTrainees();
        logger.info(traineesList);
    }

    @Test
    public void queryAllCareers() {
        List<Occupation> occupationList;
        occupationList=mp.queryAllCareers();
        logger.info(occupationList);
    }

    @Test
    public void queryAllCareersAndLesson(){
        List<OcT> ocTS=mp.queryAllCareersAndLesson();
        for (int i=0;i<ocTS.size();i++){
            ocTS.get(i).setCourseSum(mp.lessonCount(ocTS.get(i).getId()));
        }
        logger.info(ocTS);

        }


     @Test
    public void checkPwd(){
        Trainees tr=mp.checkPwd("123");
         System.out.println(tr);
     }

     @Test
     public void loginTrainees(){
        Trainees trainees=new Trainees();
        trainees.setAccount("222test");
        trainees.setPassword("333");
        trainees.setEmail("123@qq.com");
        trainees.setPic("222.png");
        trainees.setPhoneNumber("123123");
        int i=mp.loginTrainees(trainees);
         System.out.println(i);
     }

     @Test
    public void test111(){
        int j=5;
        for(int i=0;i<10;i++){
            System.out.println(i);
            if (i==j){
                break;
            }
        }

     }

     @Test
    public void findId(){
        String account=mp.findAccountById(1);
         System.out.println(account);
     }

     @Test
    public void findTrainees(){
         System.out.println(mp.findTraineesById(1));
     }

     @Test
    public void testRandom(){
         int random;
         StringBuffer sb=new StringBuffer();
         for(int i=0;i<5;i++){
             random=(int)(1+Math.random()*(10-1+1));
             sb.append(random);
         }
         System.out.println(sb);

     }

    @Test
    public void updatePwd() {
        int i=mp.updatePwd("123123","123");
        System.out.println(i);
    }

    @Test
    public void updatePicById() {
        int i=mp.updatePicById("222",1);
        System.out.println(i);
    }

    @Test
    public void findPicById() {
        System.out.println(mp.findPicById(1));
    }
}

