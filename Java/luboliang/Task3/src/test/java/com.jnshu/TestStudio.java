package com.jnshu;

import com.jnshu.model.Studio;
import com.jnshu.mapper.StudioDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring/springDao.xml")
public class TestStudio {
    @Autowired
    StudioDao studioDao;
    Studio studio = new Studio();

    @Test
    public void add() {
        studio.setType("工作室简介此处省略300子");
        studio.setCreate_at(System.currentTimeMillis());
        studio.setUpdate_at(System.currentTimeMillis());
        studio.setState("上架");
        studio.setEditor("光脚大仙");
        studioDao.addStudio(studio);
        System.out.println("id==============================" + studio.getId());
    }

    @Test
    public void delete() {

        System.out.println(studioDao.deleteStudio(3));
    }
    @Test
    public void update(){
        studio.setType("艺术家简介此处省略300子");
        studio.setCreate_at(System.currentTimeMillis());
        studio.setUpdate_at(System.currentTimeMillis());
        studio.setState("下架");
        studio.setEditor("光脚大仙");
        studio.setId(5);
    }
    @Test
    public void findBy(){

        System.out.println(studioDao.findByStudio(12));
    }
    @Test
    public void findAll(){
        System.out.println(studioDao.findAllStudio());

    }



}
