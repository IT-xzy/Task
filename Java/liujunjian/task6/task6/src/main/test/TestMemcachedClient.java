import com.pojo.Profession;
import com.service.PttDaoService;
import net.rubyeye.xmemcached.MemcachedClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring/applicationContext.xml")
public class TestMemcachedClient {
    @Autowired
    private MemcachedClient memcachedClient;
    @Autowired
    private PttDaoService pttDaoService;

    @Test
    public void testGet() throws Exception {
        List<Profession> list = pttDaoService.findAll();
        memcachedClient.set("list", 0, list);
        List<Profession> l = memcachedClient.get("professions");
        System.out.println(l.get(8).getStu_number());
    }
}
