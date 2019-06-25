import cn.wp.model.Message;
import cn.wp.service.MessageService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @ClassName: MessageTest
 * @Description:测试
 * @Author: 老王
 * @Date: 2019/5/11 16:02
 * @Version: 1.0
 */
@ContextConfiguration("classpath:spring/applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class MessageTest {
    @Autowired
    MessageService messageService;
    Logger logger = Logger.getLogger(MessageTest.class);
    Message message = new Message();

    @Test
    public void insert() {
        message.setId(5L);
        message.setWorkTitle(5L);
        message.setUserName("阿飞");
        message.setState(5L);
        message.setCreateAt(2018L);
        message.setUpdateAt(2018L);
        message.setCreateBy(5L);
        message.setUpdateBy(5L);
        message.setMessage("哦啦啦");
        message.setparentId(5L);
        message.setType((byte) 5);
        logger.info(messageService.insert(message));
    }

    @Test
    public void deleteByPrimaryKey() {
        logger.info(messageService.deleteByPrimaryKey(3L));
    }

    @Test
    public void updateByPrimaryKey() {
        message.setId(5L);
        message.setWorkTitle(5L);
        message.setUserName("爱情海");
        message.setState(5L);
        message.setCreateAt(2019L);
        message.setUpdateAt(2019L);
        message.setCreateBy(5L);
        message.setUpdateBy(5L);
        message.setMessage("你是我的眼");
        message.setparentId(5L);
        message.setType((byte) 5);
        logger.info(messageService.updateByPrimaryKey(message));
    }

    @Test
    public void selectByPrimaryKey() {
        logger.info(messageService.selectByPrimaryKey(4L));
    }

    @Test
    public void selectAll() {
        logger.info(messageService.selectAll());
    }

    @Test
    public void selectByDynamicCondition() {
        logger.info(messageService.selectByDynamicCondition("梵高", 3L));
    }
}
