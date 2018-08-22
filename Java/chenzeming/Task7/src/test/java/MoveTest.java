import com.jnshu.czm.util.EmailVerificationUntil;
import com.jnshu.czm.util.MoveUtil;
import com.jnshu.czm.util.PhonoVerificationUntil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class MoveTest {

    @Test
    public void AiToNiu(){
        MoveUtil.AliToNiu();
    }

    @Test

    public void NiuToAi() throws Exception {
        MoveUtil.NiuToAli();
    }

}
