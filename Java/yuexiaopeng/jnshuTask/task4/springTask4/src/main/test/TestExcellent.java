import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import task.pojo.Excellent;
import task.service.ExcellentService;
import org.apache.log4j.Logger;


import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestExcellent
{
   static Logger loger=Logger.getLogger(TestExcellent.class);

    @Autowired
    private ExcellentService excellentService;

    @Test
    public void testSelectExcellent()
    {
        List<Excellent> excellents=excellentService.selectExcellent();
        for(Excellent excellent:excellents)
        {
            loger.info(excellent);
        }
    }
}
