import com.lihoo.ssm.dao.StudentListMapper;
import com.lihoo.ssm.model.StudentList;
import com.lihoo.ssm.service.StudentListService;
import com.lihoo.ssm.util.cache.RedisUtil;
import com.lihoo.ssm.util.cache.RedisUtilHow2j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * #Title: ListTest
 * #ProjectName task6_index1
 * #Description: TODO
 * #author lihoo
 * #date 2018/9/10-18:29
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/applicationContext.xml"})
public class ListTest {
    private static Logger logger = LogManager.getLogger(ListTest.class);

    @Autowired
    StudentListMapper studentListMapper;

    @Autowired
    StudentListService studentListService;

    @Test
    public void ById() {
        System.out.println("kaishi");
        StudentList a = studentListService.selectByPrimaryKey(52L);
        String ccc =  a.getUsername();
        System.out.println(ccc);
    }

    @Test
    public void testStudentMemCache() {
        StudentList studentList = new StudentList();
        studentList.setUsername("pip66");
        studentList.setQqNum(1532461254L);
        studentList.setStudyType("java");
        studentList.setStudyTime(1532461532L);
        studentList.setSchool("清华大学");
        studentList.setStudyId("java-123");
        studentList.setDailyLink("www.ruoji.com");
        studentList.setPromise("干就完事儿");
        studentList.setTeachBro("敖厂长");
        studentList.setKnowUsFrom("知乎");
        studentList.setCreateAt(1536462512L);
        studentList.setUpdateAt(1533468521L);
        logger.info(studentList);
        studentListService.insert(studentList);
        logger.info(studentList);
//        memCachedClient.set("student76", studentList);
//        Assert.assertEquals(studentList, (StudentList)studentList);
    }

//    @Test
//    public void getJavaList() {
//        List<StudentList> stuJavaList = studentListMapper.getJavaList();
//        for (StudentList list1 : stuJavaList) {
//            logger.info( "Java后端学员：：" + list1);
//        }
//    }
//
//    @Test
//    public void getWebList() {
//        List<StudentList> stuWebList = studentListMapper.getWebList();
//        for (StudentList list2 : stuWebList) {
//            logger.info( "Web前端学员：：" + list2);
//        }
//    }

    @Test
    public void testJavaListService() {
        List<StudentList> aa = studentListService.getJavaList();
        for (StudentList list3 : aa) {
            logger.info("获取职业类型中含有Java的学员List：：" + list3);
        }
    }

    @Test
    public void testWebListService() {
        List<StudentList> bb = studentListService.getWebList();
        for (StudentList list4 : bb) {
            logger.info("获取职业类型中含有web的学员List：：" + list4);
        }
    }

    @Test
    public void allStuTest() {
        List<StudentList> alll = studentListService.selectAll();
        for (StudentList listAlll : alll) {
            logger.info("缓存de所有学员：" + listAlll);
        }
    }

    @Autowired
    RedisUtil redisUtil;
    @Test
    public void redisTest() {
        List list=studentListMapper.selectAll();
//        System.out.println(list);
        redisUtil.set("testredis6",list.toString(),600000L);
//        System.out.println(redisUtil.get("testredis").toString());
    }



    @Autowired
    RedisUtilHow2j redisUtilHow2j;

    @Test
    public void redisListTest() {
        List<StudentList> list = studentListMapper.selectAll();
        redisUtilHow2j.lSet("how2jmmm1", list, 60000L);
        System.out.println(list);
//
        List<Object> aaa = redisUtilHow2j.lGet("how2jmmm1", 0L, 3L);
        System.out.println(aaa);
//
        long bbb = redisUtilHow2j.lGetListSize("how2jmmm1");
        System.out.println(bbb);

        Object ccc = redisUtilHow2j.lGetIndex("how2jmmm1", 0L);
        System.out.println(ccc);


    }
}
