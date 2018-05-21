import lujing.mapper.StudentMapperCustom;
import lujing.pojo.StudentQueryVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author lujing
 * Create_at 2018/3/6 15:47
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext-*.xml")
public class demo {
    @Autowired
    private StudentMapperCustom studentMapperCustom;
    
    @Test
   public void demo1() {
        StudentQueryVo studentQueryVo = new StudentQueryVo();
        
      
       
    }
    
    
}
