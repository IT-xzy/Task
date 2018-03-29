package redis;

import jnshu.tasksix.util.RedisUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.cache.RedisCache;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created with IntelliJ IDEA.
 *
 * @author: Administrator
 * @date: 2017-10-22
 * @Time: 上午 10:44
 * Description:
 **/


//忽略某些警告
//value = true 则测试完毕自动回滚，无法看到数据库是否插入数据，测试环境应该设置为false
// 否则无法确定是否成功提交事务
//value = false
@Rollback(value = true)
//标记，使事务管理器来管理识别
@Transactional(transactionManager = "transactionManager")

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:conf/spring-mybatis.xml","classpath:conf/spring-redis.xml"})
public class RedisTest {

    private static Logger loggerMencache= LoggerFactory.getLogger(RedisTest.class);
//
//    @Autowired
//    MemcachedUtil memcachedUtil;
    private static final long serialVersionUID = -5809782578272943999L;

    @Autowired
    RedisUtil redisUtil;


    @Test
    public void testRedis(){
        loggerMencache.info("asda");
        redisUtil.setCacheValue("holle","world");
        String hello =  redisUtil.getValue("holle");
        loggerMencache.info("hello: "+ hello);
        Assert.assertEquals("world",hello);

    }

}