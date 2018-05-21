//package memcache;
//
//import com.whalin.MemCached.MemCachedClient;
//import jnshu.tasksix.util.MemcachedUtil;
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.test.annotation.Rollback;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.transaction.annotation.Transactional;
//import java.util.Date;
//
//
///**
// * Created with IntelliJ IDEA.
// *
// * @author: Administrator
// * @date: 2017-10-22
// * @Time: 上午 10:44
// * Description:
// **/
//
//
////忽略某些警告
////value = true 则测试完毕自动回滚，无法看到数据库是否插入数据，测试环境应该设置为false
//// 否则无法确定是否成功提交事务
////value = false
//
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"classpath:conf/spring-memcached.xml"})
//public class MemcacheTest {
//
//    private static Logger loggerMencache= LoggerFactory.getLogger(MemcacheTest.class);
////
////    @Autowired
////    MemcachedUtil memcachedUtil;
//    private static final long serialVersionUID = -5809782578272943999L;
//
//
//    private MemCachedClient cachedClient;
//
//    @Test
//    public void testMemcached(){
////        loggerMencache.info("memcache");
////        MemCachedClient cachedClient = new MemCachedClient("neeaMemcachedPool");
////        try {
////            boolean success = cachedClient.add("hello", "world",new Date(1000*100));
////            loggerMencache.info("success: " + success);
////        }catch (Exception e){
////            e.printStackTrace();
////        }
////        String hello = (String)cachedClient.get("hello");
////        loggerMencache.info("hello: "+ hello);
//
//
//        boolean success = MemcachedUtil.set("hello","world",new Date(1000*60));
//        loggerMencache.info("success: " + success);
//        String hello = (String)MemcachedUtil.get("hello");
//        loggerMencache.info("hello: "+ hello);
//        Assert.assertEquals("world",hello);
//
//    }
//
//}