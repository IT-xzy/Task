import com.danga.MemCached.MemCachedClient;
import com.lihoo.ssm.model.StudentList;
import com.lihoo.ssm.model.UserBean;
import com.lihoo.ssm.util.MemcachedUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * #Title: MemcachedSpringTest
 * #ProjectName task6_index1
 * #Description: TODO
 * #author lihoo
 * #date 2018/9/13-11:47
 */


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/applicationContext.xml"})
public class MemcachedSpringTest {
    private static Logger logger = LogManager.getLogger(MemcachedSpringTest.class);


    @Autowired
    private MemCachedClient memCachedClient;

    @Test
    public void testMemcachedSpring() {
        UserBean userBean = new UserBean("Cookie", "coco");
        logger.info(userBean);
        memCachedClient.set("stu2", userBean);
        Assert.assertEquals(userBean, (UserBean)userBean);

//        for (int i = 0; i < 444; ++i) {
//            UserBean userBB = new UserBean("nice" + i, "1234" + i);
////            logger.info(userBB);
//            MemcachedUtil.put("bibi" + i, userBB, 60);
//            Object obj = MemcachedUtil.get("bibi" + i);
//            logger.info(obj);
//            Assert.assertEquals(userBB, obj);
//        }
    }

    @Test
    public void testStudent() {
        StudentList studentList = new StudentList();
        studentList.setUsername("狗子小柴abc");
        studentList.setQqNum(1532461254L);
        studentList.setStudyType("java");
        studentList.setStudyTime(1532461532L);
        studentList.setSchool("清华大学");
        studentList.setStudyId("java-7787");
        studentList.setDailyLink("www.ruoji.com");
        studentList.setPromise("干就完事儿");
        studentList.setTeachBro("alibaba");
        studentList.setKnowUsFrom("知乎");
        studentList.setCreateAt(1536462512L);
        studentList.setUpdateAt(1533468521L);
        logger.info(studentList);

        memCachedClient.set("student76", studentList);

        memCachedClient.get("student76");

        logger.info(memCachedClient.get("student76"));

        Assert.assertEquals(studentList, (StudentList)studentList);
    }
}
