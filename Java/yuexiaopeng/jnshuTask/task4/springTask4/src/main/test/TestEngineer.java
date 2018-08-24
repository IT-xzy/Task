import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import task.pojo.Engineer;
import task.service.EngineerService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestEngineer
{
    static Logger logger= Logger.getLogger(TestEngineer.class);
    @Autowired
    private EngineerService engineerService;

    @Test
    public void testSelectEngineer()
    {
        Engineer engineer=engineerService.selectEngineer();
        logger.info(engineer);
    }
}
