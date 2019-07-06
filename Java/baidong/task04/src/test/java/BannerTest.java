import com.jnshu.model.Banner;
import com.jnshu.service.BannerService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@ContextConfiguration("classpath:spring/applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class BannerTest {

    @Autowired
    private BannerService bannerService;
    Logger logger = Logger.getLogger(BannerTest.class);

    @Test
    public void select(){
        List<Banner> banner = bannerService.selectAll();
        logger.info(banner);
    }
}
