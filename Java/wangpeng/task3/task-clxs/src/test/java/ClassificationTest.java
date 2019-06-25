import cn.wp.model.Classification;
import cn.wp.service.ClassificationService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @ClassName: ClassificationTest
 * @Description:测试
 * @Author: 老王
 * @Date: 2019/5/11 16:02
 * @Version: 1.0
 */
@ContextConfiguration("classpath:spring/applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class ClassificationTest {
    @Autowired
    ClassificationService classificationService;
    Classification classification = new Classification();
    Logger logger = Logger.getLogger(ClassificationTest.class);

    @Test
    public void insert() {
        classification.setId(5L);
        classification.setName("阿凡达");
        classification.setState(5L);
        classification.setCreateAt(2020L);
        classification.setUpdateAt(2020L);
        classification.setCreateBy(5L);
        classification.setUpdateBy(5L);
        logger.info(classificationService.insert(classification));
    }

    @Test
    public void deleteByPrimaryKey() {
        logger.info(classificationService.deleteByPrimaryKey(1L));
    }

    @Test
    public void updateByPrimaryKey() {
        classification.setId(5L);
        classification.setName("噗噗噗");
        classification.setState(5L);
        classification.setCreateAt(2019L);
        classification.setUpdateAt(2019L);
        classification.setCreateBy(5L);
        classification.setUpdateBy(5L);
        logger.info(classificationService.updateByPrimaryKey(classification));
    }

    @Test
    public void selectByPrimaryKey() {
        logger.info(classificationService.selectByPrimaryKey(2L));
    }

    @Test
    public void selectAll() {
        logger.info(classificationService.selectAll());
    }

    @Test
    public void selectByDynamicCondition() {
        logger.info(classificationService.selectByDynamicCondition(null, null));
    }
}
