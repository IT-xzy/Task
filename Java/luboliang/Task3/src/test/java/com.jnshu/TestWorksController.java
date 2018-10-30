package com.jnshu;

import com.jnshu.mapper.WorksDao;
import com.jnshu.model.Workss;

import com.jnshu.service.WorksService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/springDao.xml")
public class TestWorksController {
    @Autowired
    WorksDao worksDao;
    Workss workss = new Workss();
    @Autowired
    WorksService worksService;
    @Test
    public void add() {
        workss.setCreate_at(System.currentTimeMillis());
        workss.setUpdate_at(System.currentTimeMillis());
        workss.setWorks_class1("绘画.装置");
        workss.setWorks_class2("梦雨童生");
        workss.setWorks_name("乡村小路");
        workss.setWorks_introduction("此处略过300字");
        workss.setWorks("c/2/as/asd/asdasd/adsas");
        worksDao.addWorkss(workss);
        System.out.println("id============================================================================" +
                "======"+workss.getId());

    }
    @Test
    public void findby(){
        System.out.println(worksDao.findByWorkss(11));
    }
    @Test
    public void delete(){

        System.out.println(worksDao.deleteWorkss(10));
    }
    @Test
    public void update(){
        workss.setCreate_at(System.currentTimeMillis());
        workss.setUpdate_at(System.currentTimeMillis());
        workss.setWorks_class1("绘画.装置");
        workss.setWorks_class2("梦雨童生");
        workss.setWorks_name("乡村小路");
        workss.setWorks_introduction("此处略过300子");
        workss.setWorks("c/2/as/asd/asdasd/adsas");
        System.out.println(worksDao.updateWorkss(workss));
    }
    @Test
    public void findAll(){

//        System.out.println(worksDao.findAllWorkss());
        System.out.println(worksService.findAllWorkss());

    }
}
