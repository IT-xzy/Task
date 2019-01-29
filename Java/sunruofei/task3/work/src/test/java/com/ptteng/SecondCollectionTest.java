package com.ptteng;


import com.ptteng.model.SecondCollection;
import com.ptteng.service.SecondCollectionService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration("classpath:/spring/applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class SecondCollectionTest {
    @Autowired
    SecondCollectionService secondCollectionService;
    SecondCollection secondCollection = new SecondCollection();
    Logger logger = Logger.getLogger(SecondCollection.class);
    @Test
    public void insert(){
        secondCollection.setCreateAt(1212L);
        secondCollection.setCreateBy(2L);
        secondCollection.setFirstCollectionId(2L);
        secondCollection.setName("绘画");
        secondCollection.setState((2L));
        secondCollection.setUpdateAt(1212L);
        secondCollection.setUpdateBy(2L);
        logger.info(secondCollectionService.insert(secondCollection));
    }
    @Test
    public void deleteByPrimaryKey(){
        logger.info(secondCollectionService.deleteByPrimaryKey(3L));
    }
    @Test
    public void updateByPrimaryKey(){
        secondCollection.setCreateAt(1212L);
        secondCollection.setCreateBy(2L);
        secondCollection.setFirstCollectionId(2L);
        secondCollection.setName("照片");
        secondCollection.setState(2L);
        secondCollection.setUpdateAt(1212L);
        secondCollection.setUpdateBy(2L);
        secondCollection.setId(4L);
        logger.info(secondCollectionService.updateByPrimaryKey(secondCollection));
    }
    @Test
    public void selectByPrimaryKey(){
        logger.info(secondCollectionService.selectByPrimaryKey(2L));
    }
    @Test
    public void selectAll(){
        logger.info(secondCollectionService.selectAll());
    }
    @Test
    public void selectByDynamicCondition(){
        logger.info(secondCollectionService.selectByDynamicCondition("绘画",1L));
    }
}
