package com.jnshuboot.testTask;

import com.jnshuboot.dao.StudentMapper;
import com.jnshuboot.DemobootApplication;
import com.jnshuboot.pojo.Student;
import com.jnshuboot.pojo.example.StudentExample;
import com.jnshuboot.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemobootApplication.class)
//@MapperScan(basePackages = "com.jnshuboot.dao")
public class TestStudent {
    static Logger logger = LoggerFactory.getLogger(TestStudent.class);
    @Autowired
    ApplicationContext applicationContext;

    @Test
    public void testStu1() {
        StudentExample studentExample = new StudentExample();
        StudentMapper studentMapper = (StudentMapper) applicationContext.getBean("studentMapper");
        long i = studentMapper.countByExample(studentExample);
        logger.warn("数据库数量为" + i);
    }

    @Test
    public void testStu2() {
        StudentExample studentExample = new StudentExample();
        StudentMapper studentMapper = (StudentMapper) applicationContext.getBean("studentMapper");
        //生成条件
        StudentExample.Criteria criteria = studentExample.createCriteria();
        //删除固定的studyId数据；
        criteria.andStudyIdLike("%java%");
        //删除范围性studyId数据；
//        criteria.andStudyIdBetween("java-003","java-007");
        int j = studentMapper.deleteByExample(studentExample);
        logger.warn("删除的student数量为：" + j);
    }

    @Test
    public void testStu3() {
        StudentExample studentExample = new StudentExample();
        StudentMapper studentMapper = (StudentMapper) applicationContext.getBean("studentMapper");
        //生成条件
        StudentExample.Criteria criteria = studentExample.createCriteria();

        Student student = new Student();
//        缺省插入
//        student.setId(666);
        student.setCreateAt(System.currentTimeMillis());
        student.setUpdateAt(System.currentTimeMillis());
//        student.setName("李白");
//        student.setQq(820180608);
//        student.setStudyType("java工程师");
//        student.setStudyId("ja-004");
        student.setJoinTime(System.currentTimeMillis());
//        student.setUniversity("葡vfvfvfv院");
//        student.setDailyLink("http://www.jnshu.com/school/22071/daily");
//        student.setSlogen("fvfeeeeeefvfvf");
//        student.setMaster("嗨，大师兄");
        logger.warn("增加的student数据为：" + student);
        int i = studentMapper.insert(student);
        logger.warn("增加的student数量为：" + i);
//        两个不同结果的insert
        logger.warn("增加的student数据为：" + student);
        int j = studentMapper.insertSelective(student);
        logger.warn("增加的student数量为：" + j);
    }

    //    @Autowired
//    StudentMapper studentMapper;
    @Test
    public void testStu4() {
        StudentMapper studentMapper = (StudentMapper) applicationContext.getBean("studentMapper");
        StudentExample studentExample = new StudentExample();
        StudentExample.Criteria criteria = studentExample.createCriteria();
        criteria.andUniversityLike("%修真院%");
        List list = studentMapper.selectByExample(studentExample);
        logger.warn("查询的学生数据为" + list);
        log.info("查询的学生数据为:{}", list.size());
    }

    @Test
    public void testStu5() {
        StudentExample studentExample = new StudentExample();
        StudentMapper studentMapper = (StudentMapper) applicationContext.getBean("studentMapper");
        StudentExample.Criteria criteria = studentExample.createCriteria();
//        criteria.andIdIsNotNull();
//        logger.warn("查询的学生数据为"+criteria);
//        criteria.andIdEqualTo(7);
        criteria.andNameEqualTo("looo").andStudyTypeIsNotNull();
//        criteria.andStudyTypeEqualTo("aaa");


//        logger.warn("查询的学生数据为"+criteria);
        Student student = new Student();
//        student.setName("looo");
        student.setUpdateAt(System.currentTimeMillis());
        int i = studentMapper.updateByExampleSelective(student, studentExample);
        logger.warn("更改的学生数据为" + i);
    }

    @Autowired
    StudentService studentService;

    @Test
    public void TestService1() {
        Student student = new Student();
        student.setStudyId("yyuop");
//        int j=studentService.insertSelective(student);
//        log.warn("测试增加的student数量为："+j);
        studentService.insertSelective2(student);


    }

    @Test
    public void TestServiceDelete() {

        int j = studentService.deleteById(35);
//        int j=studentMapper.insertSelective(student);
        logger.warn("删除的student数量为：" + j);
    }

    @Test
    public void TestServiceUpdate() {
        Student student = new Student();
        student.setStudyId("java-002");
        student.setName("loin");
        student.setId(43);
//        int j=studentService.updateById(student);
//        logger.warn("更新的student数量为："+j);
        studentService.updateById2(student);
    }

    @Test
    public void TestServiceSelect1() {
        Integer id = 43;
        Student student1 = studentService.selectById(id);
        log.warn("测试查询id为{}的student数据为：{}", id, student1);

    }

    //    @Test
//    public void TestServiceSelect2(){
//        List<Student> list=studentService.selectPage(1,3);
//    }
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Test
    public void TestServiceSelecttt() {
        String str = "str3";
        String strr = "string";
        Student student = new Student();
        student.setStudyId("java-002");
        List list = new ArrayList();
        list.add(0, student);
        redisTemplate.opsForList().rightPush("stu", list);
    }
}
