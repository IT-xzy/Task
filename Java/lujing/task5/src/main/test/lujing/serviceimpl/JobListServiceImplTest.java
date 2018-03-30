package lujing.serviceimpl;

import lujing.pojo.Professions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author lujing
 * Create_at 2017/12/28 20:50
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/applicationContext-service.xml", "classpath:spring/applicationContext-dao.xml"})

public class JobListServiceImplTest {
    @Autowired
    JobListServiceImpl JobListServiceImpl;
    @Test
    public void findJobLists() {
        List<Professions> lp = JobListServiceImpl.findJobLists();
        for (Professions professions : lp) {
            System.out.println(professions);
        }
    }
}