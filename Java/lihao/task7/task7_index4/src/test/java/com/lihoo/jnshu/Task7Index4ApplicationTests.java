package com.lihoo.jnshu;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lihoo.jnshu.admin.dao.StudentListMapper;
import com.lihoo.jnshu.admin.domain.StudentList;
import com.lihoo.jnshu.admin.service.IStudentListService;
import com.lihoo.jnshu.common.util.COSUtil.QiniuyunCOSUtil;
import com.lihoo.jnshu.common.util.cache.RedisUtil;
import com.lihoo.jnshu.common.util.emailUtil.SendCommonPostMail;
import com.lihoo.jnshu.common.util.msgUtil.RonglianSendMsgUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan("com.lihoo.jnshu.admin.dao")
public class Task7Index4ApplicationTests {
    private static Logger logger = LoggerFactory.getLogger(Task7Index4ApplicationTests.class);

    @Test
    public void contextLoads() {
    }

//    @Qualifier("IStudentListService")
    @Autowired
    private StudentListMapper studentListMapper;

    @Autowired
    private IStudentListService studentListService;

    @Test
    public void CRUDTest() {
        QueryWrapper<StudentList> qw = new QueryWrapper<>();
        qw.gt("id", 0);
//        StudentList ss = studentListService.getOne(qw);
//        logger.info("通过电话找人：" + ss);
        List list=studentListService.list(qw);
        list.forEach(System.out::println);
//        list.forEach(item -> logger.info("打印学生列表：" + item));
    }

    @Autowired
    StudentListMapper mapper;

    @Test
    public void crudTest(){
        QueryWrapper<StudentList> slqw = new QueryWrapper<>();
        slqw.eq("username", "大力哥");
        StudentList dali = studentListMapper.selectOne(slqw);
//        StudentList dali = studentListService.getOne(slqw);
        System.out.println("大力："+ dali);

    }

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

//    @Autowired
//    private RedisTemplate redisTemplate;
//
//    @Test
//    public void TestRedis() {
//        RedisUtil redisUtil = new RedisUtil();
//        redisUtil.set("ccc", "nice111");
//        Object haveValue = redisUtil.get("ccc");
//        System.out.println("用键取值：：" + haveValue);
//
//    }


    @Test
    public void testRedis2() throws Exception {
        stringRedisTemplate.opsForValue().set("13945178624", "7423");

        Object aaa = stringRedisTemplate.opsForValue().get("13945178624");
        System.out.println("-----------------------------------------------");
        System.out.println("这是String 缓存：" + aaa);
        System.out.println("-----------------------------------------------");
//        Assert.assertEquals("4569", stringRedisTemplate.opsForValue().get("aaa"));
    }

    @Test
    public void testObj() throws Exception {
//        User user = new User("aa@126.com", "aa", "aa123456", "aa","123");
//        ValueOperations<String, User> operations=redisTemplate.opsForValue();
//        operations.set("com.neox", user);
//        operations.set("com.neo.f", user,1,TimeUnit.SECONDS);
//        Thread.sleep(1000);
//        //redisTemplate.delete("com.neo.f");
//        boolean exists=redisTemplate.hasKey("com.neo.f");
//        if(exists){
//            System.out.println("exists is true");
//        }else{
//            System.out.println("exists is false");
//        }
//        // Assert.assertEquals("aa", operations.get("com.neo.f").getUserName());
    }

    @Test
    public void testVerifyCode() {
//        String aaa = RonglianSendMsgUtil.sendVerifyCode("17744469309");
//
//        System.out.println("测试验证码是不是： " + aaa);
    }

    @Test
    public void testEmailCode() throws IOException {

        SendCommonPostMail.sendEmailCode("audit4835@126.com", "0123");
//        System.out.println("邮箱验证吗是：" + eCode);
    }

    @Test
    public void testSubString() {
        String aaa = "8521456";
        String bbb = aaa.substring(0, 4);
        System.out.println(bbb);
    }

    @Test
    public void testUpLoadPic() {

        String aaa = "C:\\Users\\lihoo\\Pictures\\Camera Roll\\public\\win10.jpg";
        QiniuyunCOSUtil.picUp(aaa);
        
    }
}
