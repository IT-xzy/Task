import com.impl.PttDaoServiceImpl;
import com.pojo.Profession;
import com.service.PttDaoService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestPttDaoService {
    private ApplicationContext context;

    @Before
    public void setContext() {
        context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
    }

    @Test
    public void testFindProfession() throws Exception {
        PttDaoService pttDaoService = context.getBean(PttDaoServiceImpl.class);
        Profession profession = pttDaoService.findProfession("java");
        System.out.println(profession.getProfession());
    }

    @Test
    public void testFindNumber() throws Exception {
        PttDaoService pttDaoService = context.getBean(PttDaoServiceImpl.class);
        List<Profession> list = pttDaoService.findAll();
        for (Profession p:list) {
            System.out.println(p.getGra_number());
        }
    }
}
