import com.ptteng.Service.JsonServiceImple.JsonServiceImp;
import com.ptteng.entity.Json;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @ClassName okokdd
 * @Description TODO
 * @Author 孙若飞
 * @Date 2019/3/1  10:49
 * @Version 1.0
 **/


@ContextConfiguration("classpath:spring-mvc.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class okokdd {

    @Autowired
    JsonServiceImp jsonServiceImp;

    @Test
    public void add() {
        for (int i = 0; i < 100000; i++)

        {
            Json json = new Json();
            json.setName("oo");
            json.setPhone(2132L);
            json.setQq(342342L);
            jsonServiceImp.insert(json);
            System.out.println("=============" + json);
            System.out.println("来吧快活啊");

        }

    }

}
