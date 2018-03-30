package lujing.serviceimpl;



import lujing.pojo.Learn;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author Arike
 * Create_at 2017/12/28 11:10
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/applicationContext-service.xml", "classpath:spring/applicationContext-dao.xml"})
public class IndexServiceImplTest {
    @Autowired
    private IndexServiceImpl IndexServiceImpl;
   
    
    @Test
    public void selectLearnALL() {
        List<Learn> lee;
        lee = IndexServiceImpl.selectLearnALL();
        for (Learn ss : lee) {
            System.out.println(ss);
        }
    }
    
   
  
   
 
}