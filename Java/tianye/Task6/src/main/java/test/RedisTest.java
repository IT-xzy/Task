package test;


import com.Redis.RedisCacheUtil;
import org.junit.Before;
import org.junit.Test;
 import org.springframework.context.support.ClassPathXmlApplicationContext;


  /**
  * 测试
 */
         public class RedisTest {

       private RedisCacheUtil redisCache;
     private static String key;
    private static String field;
      private static String field2;
     private static String value;

           @Before
   public void setUp() throws Exception {
              ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
              context.start();
               redisCache = (RedisCacheUtil) context.getBean("redisCache");
           }

          // 初始化 数据
         static {
              key = "student1";
              field = "name";
              field2 = "address";
              value = "[{\"create_by\":\"逗比\",\"proIntroduction\":\"学习java单身一辈子\",\"studyNum\":3,\"update_at\":0,\"id\":1001,\"proName\":\"java工程师\",\"companyNeed\":\"500\",\"create_at\":66253,\"update_by\":\"\",\"picture\":\"saozhu1.png\"},{\"create_by\":\"逗比\",\"proIntroduction\":\"前端gay起来\",\"studyNum\":2,\"update_at\":0,\"id\":1002,\"proName\":\"前端工程师\",\"companyNeed\":\"600\",\"create_at\":45215,\"update_by\":\"\",\"picture\":\"peiqi2.png\"},{\"create_by\":\"逗比\",\"proIntroduction\":\"高大上，不可能的\",\"studyNum\":10,\"update_at\":0,\"id\":1003,\"proName\":\"ios工程师\",\"companyNeed\":\"450\",\"create_at\":54566,\"update_by\":\"\",\"picture\":\"xiaoxiao1.png\"},{\"create_by\":\"逗比\",\"proIntroduction\":\"低调的屌丝\",\"studyNum\":5,\"update_at\":0,\"id\":1004,\"proName\":\"Android工程师\",\"companyNeed\":\"550\",\"create_at\":96573,\"update_by\":\"\",\"picture\":\"peiqi1.png\"},{\"create_by\":\"逗比\",\"proIntroduction\":\"辛苦的一批\",\"studyNum\":6,\"update_at\":0,\"id\":1005,\"proName\":\"pm工程师\",\"companyNeed\":\"600\",\"create_at\":66001,\"update_by\":\"\",\"picture\":\"lulaoye.png\"},{\"create_by\":\"逗比\",\"proIntroduction\":\"硬气的屌丝\",\"studyNum\":7,\"update_at\":0,\"id\":1006,\"proName\":\"QA\",\"companyNeed\":\"350\",\"create_at\":63442,\"update_by\":\"\",\"picture\":\"saozhu3.png\"}]";
           }

           // 测试增加数据
         @Test
     public void testHset() {
          redisCache.set(key,value);
           System.out.println("数据保存成功！");
           }

      // 测试查询数据
          @Test
    public void testHget(){
               Object re = redisCache.get(key);
              System.out.println("得到的数据：" + re);
           }
     // 测试数据的数量
         @Test
    public void testHsize(){
                long size = redisCache.hsize(key);
              System.out.println("数量为：" + size);
            }
}
