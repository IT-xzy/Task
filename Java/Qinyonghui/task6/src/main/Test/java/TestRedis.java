import com.jnshu.entity.Student4;
import com.jnshu.entity.User;
import com.jnshu.mapper.Student4Mapper;
import com.jnshu.mapper.UserMapper;
import com.jnshu.myutils.RedisCache;
import com.jnshu.service.Student4Service;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.logging.Logger;

@SuppressWarnings("ALL")
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class TestRedis {
    Logger logger = Logger.getLogger(TestRedis.class.getName());
    @Autowired
    UserMapper userMapper;
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    RedisCache redisCache;
    @Autowired(required = false)
    @Qualifier("Redis")
    Student4Service student4Service;
    @Autowired
    Student4Mapper student4Mapper;

    @Test
    public void testResis() {

        User user = new User("rootADH", "1234567");
        //redisTemplate.opsForValue().set("user", user);
        redisCache.putCacheWithExpireTime("user2", user, 10000);
       // redisCache.getCache("user1", User.class);
        //System.out.println("value：" + redisTemplate.opsForValue().get("user"));
        System.out.println("value：" + redisCache.getCache("user2", User.class));
    }

    @Test
    public void testRandom() {
        //Student4 student4 = student4Service.findStudent4ById(17L);
        //System.out.println(student4);
        long Min = 1L;
        long Max = 10L;
        //long randomId = Min + (long)(Math.random() * ((Max - Min) + 1L));
        for (int i=0;i<10;i++){
            //System.out.println(new Random().nextInt(5));
            System.out.println( Min + (long)(Math.random() * ((Max - Min) + 1L)));
        }
    }
    @Test
    public void testFindByPage(){
        List<Student4> stuList = student4Service.getStudent4ByPage(1,10);
        for( Student4 s:stuList){
            System.out.println(s);
        }
    }


    @Test
    public void name() {
        Student4 student4 = new Student4();
        student4.setPosition("qwe");
        student4.setResume(":qwe");
        student4.setImg(":asd");
        redisTemplate.opsForValue().set("qin", student4);
        System.out.println(redisTemplate.opsForValue().get("qin"));
    }
}