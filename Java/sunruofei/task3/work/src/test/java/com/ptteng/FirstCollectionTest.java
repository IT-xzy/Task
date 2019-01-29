package com.ptteng;


import com.ptteng.model.FirstCollection;
import com.ptteng.service.FirstCollectionService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration("classpath:/spring/applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class FirstCollectionTest {
    @Autowired
    FirstCollectionService firstCollectionService;
    Logger logger = Logger.getLogger(FirstCollectionTest.class);
    FirstCollection firstCollection = new FirstCollection();

    @Test
    public void insert() {
        firstCollection.setCreateAt(2019L);
        firstCollection.setCreateBy(2L);
        firstCollection.setName("孙若飞");
        firstCollection.setState(2L);
        firstCollection.setUpdateAt(2019L);
        firstCollection.setUpdateBy(2L);
        logger.info(firstCollectionService.insert(firstCollection));
    }

    @Test
    public void deleteByPrimaryKey() {
        logger.info(firstCollectionService.deleteByPrimaryKey(4L));
    }

    @Test
    public void updateByPrimaryKey() {
        firstCollection.setUpdateBy(3L);
        firstCollection.setUpdateAt(2019L);
        firstCollection.setName("大毛");
        firstCollection.setState(2L);
        firstCollection.setCreateBy(3L);
        firstCollection.setCreateAt(2019L);
        firstCollection.setId(3L);
        logger.info(firstCollectionService.updateByPrimaryKey(firstCollection));
    }

    @Test
    public void selectByPrimaryKey() {
        logger.info(firstCollectionService.selectByPrimaryKey(3L));
    }

    @Test
    public void selectAll() {
        logger.info(firstCollectionService.selectAll());
    }

    @Test
    public void selectByDynamicCondition(){
        logger.info(firstCollectionService.selectByDynamicCondition(null,null));
    }
}
