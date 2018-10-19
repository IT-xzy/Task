
import com.jnshu.entity.Banner;
import com.jnshu.mapper.BannerDao;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@ContextConfiguration(locations = "classpath:applicationContext.xml")//加载xml文件
@RunWith(SpringJUnit4ClassRunner.class)
public class BannerDaoTest {
    Logger logger = LogManager.getLogger(BannerDaoTest.class.getName());
    @Autowired
    BannerDao bannerDao;

    @Test//作品上下架
    public void findSelectiveBanner(){
        Banner banner = new Banner();
        banner.setState(false);
        banner.setType(false);
        List<Banner> bannerList = new ArrayList<Banner>();
        bannerList=bannerDao.select(banner);
        for(int i=0;i<bannerList.size();i++){
            Banner t = (Banner)bannerList.get(i);
            System.out.println(t.toString());
        }
    }
}
