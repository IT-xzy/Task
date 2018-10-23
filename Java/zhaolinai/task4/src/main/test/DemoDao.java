import com.mapper.ExcellentMapper;
import com.mapper.JobMapper;
import com.model.Job;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:ApplicationContext.xml")
public class DemoDao {
    @Autowired
    ExcellentMapper excellentMapper;
    @Autowired
    JobMapper jobMapper;
    Logger logger= Logger.getLogger(DemoDao.class);
    @Test
    public void test() {
//       logger.info(excellentMapper.show());
//      logger.info(jobMapper.show("前端开发方向"));
        long currentTime = System.currentTimeMillis();

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy年-MM月dd日-HH时mm分ss秒");

        Date date = new Date(currentTime);
      List list=  jobMapper.show();



        System.out.println(formatter.format(date));


    }
}
