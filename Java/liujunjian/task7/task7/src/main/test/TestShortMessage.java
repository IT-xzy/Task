import com.tools.ShortMessageUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/shortMessage.xml")
public class TestShortMessage {
    @Autowired
    private ShortMessageUtil shortMessageUtil;

    @Test
    public void test() throws Exception{
        System.out.println(shortMessageUtil.sendShortMessage("17612135494"));
    }
}
