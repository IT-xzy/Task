import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import yxp.pojo.Amount;
import yxp.service.AmountService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestAmount
{
    @Autowired
    private AmountService amountService;

    @Test
    public void testAmount()
    {
        long updateAt=1530378061000l;
        Amount amount=amountService.listAmount(updateAt);
        System.out.println(amount);
    }
}
