import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import yxp.pojo.Engineer;
import yxp.service.EngineerService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestEngineer
{
    @Autowired
    private EngineerService engineerService;

    @Test
    public void testEngineer()
    {
        Engineer engineer=engineerService.listEngineer(1);
        System.out.println(engineer);
    }
}
