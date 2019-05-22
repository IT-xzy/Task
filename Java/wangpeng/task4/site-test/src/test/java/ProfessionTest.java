import cn.wp.service.ProfessionService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @ClassName:
 * @Description:
 * @Author: 老王
 * @Date: 2019/5/20 16:44
 * @Version: 1.0
 */
@ContextConfiguration("classpath:applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class ProfessionTest {
    @Autowired
    ProfessionService professionService;
    Logger logger = Logger.getLogger(ProfessionTest.class);

    @Test
    public void selectAll() {
        logger.info(professionService.selectAll());
    }

}
