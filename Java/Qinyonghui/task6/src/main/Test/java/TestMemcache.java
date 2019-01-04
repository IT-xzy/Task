import com.danga.MemCached.MemCachedClient;
import com.jnshu.entity.Student4;
import com.jnshu.entity.User;
import com.jnshu.mapper.UserMapper;
import com.jnshu.myutils.MemCacheUtil;
import com.jnshu.service.Student4Service;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.logging.Logger;

//@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class TestMemcache {
   Logger logger = Logger.getLogger(TestMemcache.class.getName());
   @Autowired
   private   MemCachedClient memCachedClient;
   @Autowired(required=false)
   @Qualifier("NoCache")
   Student4Service student4Service;
   @Autowired
   @Qualifier("Memcache")
    Student4Service student4Service2;
   @Autowired
   UserMapper userMapper;
   @Autowired
   private MemCacheUtil memCacheUtil ;//= new MemCacheUtil() ;
   @Test
    public void testMem() {
      String userkey = String.valueOf(43L);
      User user1 = (User) memCachedClient.get(userkey);
      if (user1 != null) {
         logger.info("缓存中有key===" + user1.toString());
      } else {
         logger.info("缓存中没有key===" + userkey);
         //数据库根据id查询用户
         user1 = userMapper.selectByPrimaryKey(43L);
         logger.info("user1====" + user1.toString());
         //添加缓存
         memCachedClient.set(userkey, user1);
         if (memCachedClient.set(userkey, user1)) {
            logger.info("添加缓存成功，key====" + user1.toString());
         } else {
            logger.info("添加缓存失败，key====" + userkey);
         }
         System.out.println(memCachedClient.get("user"));
      }
   }
   @Test
   public void  findStudent4ById()
   {
       //通过实现Serializable接口序列化后存入缓存
      String key = String.valueOf(19L);
      List<Student4> student4List = (List<Student4>) memCachedClient.get("student4"+key);
       logger.info("缓存中有key===" + student4List);
       memCachedClient.delete("student4"+key);
       logger.info("student4"+memCachedClient.get("student4"+key));
   }
   @Test
   public void insertTest(){
       User user = new User();
       user.setUsername("guojing9");
       user.setPassword("1234567");
       user.setUpdateAt(System.currentTimeMillis());
       user.setCreateAt(System.currentTimeMillis());
      System.out.println("subian\n"+userMapper.addOne(user)+"\n");
   }
   @Test
    public void prostuffToMemCache(){
       User user = new User();
       user.setUsername("guojing18");
       user.setPassword("1234567");
      //logger.info("查找结果"+student4Service2.findStudent4ById(17L));
       User user1 = new User();
       user1= memCacheUtil.get("guoab", User.class);
       if(null!=user1){
           logger.info("获取结果："+user1);
       }else{
           logger.info("添加结果："+ memCacheUtil.set("guoab", user));
           user1= memCacheUtil.get("guoab", User.class);
       }
       logger.info("获取结果@@@@："+user1);

      // User user2 = memCacheUtil.get("test9", User.class);
       //logger.info("获取结果******：" + user2);
       //byte[] serializable = ProtoStuffSerializerUtil.serialize(user);
       //System.out.println("serrializable: "+Arrays.toString(serializable));
       //String userkey = String.valueOf(1L);
       //User user1 = userMapper.selectByPrimaryKey(1L);
       //System.out.println("user1 "+user1);

     //logger.info("添加结果："+memCachedClient.set("mykey", ProtoStuffSerializerUtil.serialize(user)));

     //User deserializerUser1 = ProtoStuffSerializerUtil.deserialize((byte[]) memCachedClient.get("mykey"),User.class) ;
    //System.out.println("deserializer "+deserializerUser1.toString());

       //User deserializer = ProtoStuffSerializerUtil.deserialize(serializable, User.class);
       //System.out.println("deserializer "+deserializer.toString());

   }
}
