
/*
 * @ClassName:OSSTest
 * @Description:TODO
 * @Author qiao
 * @Date 2018/9/5 20:04
 **/

import com.util.task7.OSSClientUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class OSSTest {
    @Autowired
    private OSSClientUtil ossClientUtil;
    @Test
    public void test1(){
    }
}
