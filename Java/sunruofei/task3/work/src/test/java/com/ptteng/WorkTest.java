package com.ptteng;


import com.ptteng.model.Work;
import com.ptteng.service.WorkService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration("classpath:/spring/applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class WorkTest {
    @Autowired
    WorkService workService;
    Work work = new Work();
    Logger logger = Logger.getLogger(Work.class);
    @Test
    public void insert(){
        work.setCreateAt(2222L);
        work.setCreateBy(2L);
        work.setDetailPicture("/sdadas/adsas");
        work.setIntroduction("好");
        work.setIntroductionWord("真好");
        work.setName("随便画画");
        work.setSecondCollectionId(2L);
        work.setSmallPicture("/asd/asda");
        work.setUpdateAt(1212L);
        work.setUpdateBy(2L);
        work.setVideoLink("/sad/asd");
       logger.info( workService.insert(work));
    }
    @Test
    public void deleteByPrimaryKey() {
        logger.info(workService.deleteByPrimaryKey(3L));
    }
    @Test
    public void updateByPrimaryKey(){
        work.setCreateAt(2222L);
        work.setCreateBy(2L);
        work.setDetailPicture("/sdadas/adsas");
        work.setIntroduction("好");
        work.setIntroductionWord("真好");
        work.setName("随便画");
        work.setSecondCollectionId(2L);
        work.setSmallPicture("/asd/asda");
        work.setUpdateAt(1212L);
        work.setUpdateBy(2L);
        work.setVideoLink("/sad/asd");
        work.setId(4L);
        logger.info(workService.updateByPrimaryKey(work));
    }
    @Test
    public void selectByPrimaryKey(){
        logger.info(workService.selectByPrimaryKey(1L));
    }
    @Test
    public void selectAll(){
        logger.info(workService.selectAll());
    }
    @Test
    public void selectByDynamic(){
        logger.info(workService.selectByDynamicCondition("梵高的老舅",1L));
    }

}
