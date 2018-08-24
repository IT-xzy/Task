import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import task.pojo.Amount;
import task.service.AmountService;

import org.apache.log4j.Logger;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestAmout
{
    static Logger logger=Logger.getLogger(TestAmout.class);
    @Autowired
    private AmountService amountService;

    @Test
    public void testSelectAmout()
    {
        Amount amount=amountService.selectAmount(1532275200L);
        logger.info(amount);
    }
}
