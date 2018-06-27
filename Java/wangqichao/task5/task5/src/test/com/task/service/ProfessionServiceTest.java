package com.task.service;

import com.task.dao.ProfessionDao;
import com.task.models.Profession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
//生成spring容器
@RunWith(SpringJUnit4ClassRunner.class)
//加载配置文件
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class ProfessionServiceTest {
    //生成对象注入属性
    @Autowired
    ProfessionDao professionDao;
    @Test
    public void justAdd() {
        Profession profession=new Profession(System.currentTimeMillis(),"ui","视觉设计师","一星","视觉能力强，想象力丰富,有一台mac","3-5年","15588","5-10K","10-20K","20-30K","ps");
        professionDao.addPro(profession);
    }

    @Test
    public void justDelete() {
        professionDao.deletePro(1);
    }

    @Test
    public void justUpdate() {
        Profession profession=new Profession();
        profession.setName("前端工程师");
        profession.setUpdatedAt(System.currentTimeMillis());
        profession.setId(3);
        professionDao.updatePro(profession);
    }

    @Test
    public void justListByName() {
        System.out.println(professionDao.getProByName("前端工程师"));
        }
     }