package lujing.serviceimpl;

import lujing.mapper.LearnMapper;
import lujing.pojo.Learn;
import lujing.pojo.Student;
import lujing.pojo.StudentCustom;
import lujing.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeoutException;

import static org.junit.Assert.*;

/**
 * @author lujing
 * Create_at 2018/1/5 14:47
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/applicationContext-service.xml", "classpath:spring/applicationContext-dao.xml"})
public class UserServiceImplTest {
    @Autowired
    UserServiceImpl userServiceImpl;
    @Autowired
    LearnMapper learnMapper;
    @Autowired
    RedisTemplate redisTemplate;
    
    
    @Test
    public void findUser() {
        User userxx = new User();
        User user1 = new User();
        
        user1.setName("admin");
        user1.setPassword("admin");
        
        userxx.setName("admin");
        userxx.setPassword(null);
    }
    
    @Test
    public void findUserByName() {
        System.out.println(userServiceImpl.findUserByName("admin"));
    }
    
    @Test
    public void siginUser() {
        User testuser = new User();
        testuser.setName("admin");
        testuser.setPassword("admin");
        System.out.println(userServiceImpl.siginUser(testuser, ""));
    }
    
    /**
     * @Test public void testMEM(){
     * System.out.println(memcachedClient);
     * try {
     * Boolean FF =  memcachedClient.set("xx",500,"setorget");
     * System.out.println(FF);
     * } catch (TimeoutException e) {
     * e.printStackTrace();
     * } catch (InterruptedException e) {
     * e.printStackTrace();
     * } catch (MemcachedException e) {
     * e.printStackTrace();
     * }
     * try {
     * String xxx=  memcachedClient.get("xx");
     * System.out.println(xxx);
     * } catch (TimeoutException e) {
     * e.printStackTrace();
     * } catch (InterruptedException e) {
     * e.printStackTrace();
     * } catch (MemcachedException e) {
     * e.printStackTrace();
     * }
     * <p>
     * try {
     * memcachedClient.shutdown();
     * } catch (IOException e) {
     * e.printStackTrace();
     * }
     * <p>
     * }
     */
    
    @Test
    public void testRedis() {
        List<Learn> xx = learnMapper.selectAll();
        redisTemplate.opsForHash().put("student", "list", xx);
        for (int i = 0; i < 40; i++) {
            List<StudentCustom> studentlist = (List<StudentCustom>) redisTemplate.opsForHash().get("student", "list");
            
            
            System.out.println(studentlist);
            
        }
        
    }
    
}
