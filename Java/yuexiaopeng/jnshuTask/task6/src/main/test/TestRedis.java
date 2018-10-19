import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import yxpTask6.pojo.Engineer;
import yxpTask6.pojo.Student;
import yxpTask6.service.EngineerService;
import yxpTask6.service.StudentService;
import yxpTask6.util.TaskRedisUtil;

import java.util.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestRedis
{
    static Logger logger=Logger.getLogger(TestRedis.class);
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private StudentService studentService;
    @Autowired
    private TaskRedisUtil taskRedisUtil;
    @Test
    public void TestRedisMap() throws  Exception
    {
        taskRedisUtil.creatAllStudentRedis();
        taskRedisUtil.creatAllIndexRedis();
    }
    @Test
    public void TestRedisDelete() throws  Exception
    {
        Student student=new Student();
        student.setStudyId("java-001");

        Set setOld=redisTemplate.opsForHash().keys("student");
        System.out.println("删除前的student数据的key*********"+setOld);

        List listOld=redisTemplate.opsForList().range("listStudyId",0,-1);
        System.out.println("删除前的index"+listOld);

        taskRedisUtil.deleteStudentRedis(student.getStudyId());

        Set setNew=redisTemplate.opsForHash().keys("student");
        System.out.println("删除后的student数据的key*********"+setNew);

        List listNew=redisTemplate.opsForList().range("listStudyId",0,-1);
        System.out.println("删除后的index"+listNew);

    }
    @Test
    public void TestRedisAdd() throws  Exception
    {

        Student student=new Student();

        student.setId(666);
        student.setCreateAt(System.currentTimeMillis());
        student.setUpdateAt(System.currentTimeMillis());
        student.setName("李白");
        student.setQq(820180608);
        student.setStudyType("java工程师");

        student.setStudyId("java-666");
        student.setJoinTime(20180608l);
        student.setUniversity("aaaaaaaaaaaaaaa");
        student.setDailyLink("bbbbbbbbbbbbbbb");
        student.setSlogen("fvfeeeeeefvfvf");
        student.setMaster("mmmmmmmmmmmmm");

        Set setOld=redisTemplate.opsForHash().keys("student");
        System.out.println("增加前的student数据的key*********"+setOld);

        List listOld=redisTemplate.opsForList().range("listStudyId",0,-1);
        System.out.println("增加前的index"+listOld);

        taskRedisUtil.addStudentRedis(student);

        Set setNew=redisTemplate.opsForHash().keys("student");
        System.out.println("增加后的student数据的key*********"+setNew);


        List listNew=redisTemplate.opsForList().range("listStudyId",0,-1);
        System.out.println("增加后的index"+listNew);

    }
    @Autowired
    EngineerService engineerService;
    @Test
    public void TestUpadate()
    {
        Student student=new Student();
        student.setId(666);
        student.setCreateAt(System.currentTimeMillis());
        student.setUpdateAt(System.currentTimeMillis());
        student.setName("李白");
        student.setQq(820180608);
        student.setStudyType("java工程师");

        student.setStudyId("java-008");
        student.setJoinTime(20180608l);
        student.setUniversity("哦**********哦哦");
        student.setDailyLink("哦哦**********哦");
        student.setSlogen("哦**********哦");
        student.setMaster("哦**********哦");

        Set setOld=redisTemplate.opsForHash().keys("student");
        System.out.println("更新前studyId******"+setOld);
        Student studentOld=taskRedisUtil.getByStudyIdRedis(student.getStudyId());
        System.out.println("更新前数据******"+studentOld);

        List listOld=redisTemplate.opsForList().range("listStudyId",0,-1);
        System.out.println("更新前索引数据******"+listOld);

        taskRedisUtil.updateStudentRedis(student);

        Set setNew=redisTemplate.opsForHash().keys("student");
        System.out.println("更新后studyId******"+setNew);
        Student studentNew=taskRedisUtil.getByStudyIdRedis(student.getStudyId());
        System.out.println("更新后数据******"+studentNew);

        List listNew=redisTemplate.opsForList().range("listStudyId",0,-1);
        System.out.println("更新后索引数据******"+listNew);
    }
    @Test
    public void TestGetRedis()
    {
        Student studentObject=taskRedisUtil.getByStudyIdRedis("java-001");
        if(studentObject!=null)
        {System.out.println(studentObject);}
    }
    @Test
    public void TestGetPageRedis()
    {
        List listNew=redisTemplate.opsForList().range("listStudyId",0,-1);
        System.out.println("索引数据******"+listNew);

        List list=taskRedisUtil.pageStudentRedis(1,3);
        System.out.println("分页数据为******"+list);
    }
    @Test
    public void TestGetIndex()
    {
        List list=taskRedisUtil.getAllIndexRedis();
        System.out.println("所有的index为*****"+list);
    }
    @Test
    public void TestRedisToMysql()
    {
        Boolean boo=taskRedisUtil.redisToMysql();
        System.out.println(boo);
    }
    @Test
    public void mapJson()
    {
        List list=taskRedisUtil.getAllIndexRedis();
        Map map=new HashMap();
        map.put("studyId",list.toString());
        logger.info(map);
    }
}
