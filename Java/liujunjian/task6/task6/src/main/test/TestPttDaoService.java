import com.pojo.Profession;
import com.service.PttDaoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring/applicationContext.xml")
public class TestPttDaoService {
    @Autowired
    private PttDaoService pttDaoService;

    @Test
    public void testFindProfession() throws Exception {
        Profession profession = pttDaoService.findProfession("java");
        System.out.println(profession.getProfession());
    }

    @Test
    public void testFindNumber() throws Exception {
        List<Profession> list = pttDaoService.findAll();
        for (Profession p:list) {
            System.out.println(p.getGra_number());
        }
    }
}
