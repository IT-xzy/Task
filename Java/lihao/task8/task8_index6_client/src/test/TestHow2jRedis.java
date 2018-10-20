/**
 * #Title: TestHow2jRedis
 * #ProjectName task6_index1
 * #Description: TODO
 * #author lihoo
 * #date 2018/9/17-13:35
 */

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lihoo.ssm.model.StudentList;
import com.lihoo.ssm.service.StudentListService;
import com.lihoo.ssm.util.cache.RedisUtilHow2j;
import com.lihoo.ssm.util.commonUtil.Log2Util;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/applicationContext.xml"})
public class TestHow2jRedis {

    @Autowired
    StudentListService studentListService;

//    @Test
//    public void setTest() {
//        StudentList studentList = studentListService.selectByPrimaryKey()
//    }

    @Test
    public void getSettUnitBySettUnitIdTest() {
        Long systemId = 28L;
//        Long merchantId = 133L;

        StudentList studentList = studentListService.selectByPrimaryKey(systemId);
        StudentList studentList1 = studentListService.selectByPrimaryKey(systemId);
        boolean flag = (studentList == studentList1);
        System.out.println(studentList);
        System.out.println("相等吗：" + flag);
        Log2Util.logger.info("查找结果：" + studentList.getStudyType());
    }

    @Test
    public void testFindAll() {
        List<StudentList> list = studentListService.selectAll();
        for (StudentList listbabalili : list) {
            Log2Util.logger.info(listbabalili);
        }
        Log2Util.logger.info("查找结果：" );
    }

    @Test
    public void addTest() {
        Log2Util.logger.info("添加一条缓存");

    }

    //    @Autowired
//    RedisUtilHow2j redisUtilHow2j;
//
//    @Test
//    public void testString() {
//        Log2Util.logger.info("添加键值对");
//        redisUtilHow2j.set("name", "火拳艾斯");
//        Log2Util.logger.info(redisUtilHow2j.get("name"));
//        redisUtilHow2j.del("name");
//        Log2Util.logger.info(redisUtilHow2j.get("name"));
//        Log2Util.logger.info("Over!!!!");
//    }
//
//    @Test
//    public void testNumber() {
//        long incr = redisUtilHow2j.incr("number", 1);
//        Log2Util.logger.info(incr);
//        incr = redisUtilHow2j.incr("number", 1);
//        Log2Util.logger.info(incr);
//    }
//
//    @Test
//    public void testHashMap() {
//        Map<String, Object> map = new HashMap<>();
//        map.put("name", "meepo");
//        map.put("pwd", "45612399+");
//        redisUtilHow2j.hmset("user", map);
//        Log2Util.logger.info(redisUtilHow2j.hget("user", "pwd"));
//    }
    //    public static void main(String[] args) throws Exception {
//
//        //=====================testString======================
//        redisUtil.set("name", "how2java");
//        System.out.println(redisUtil.get("name"));
//        redisUtil.del("name");
//        System.out.println(redisUtil.get("name"));
//
//        //=====================testNumber======================
//        long incr = redisUtil.incr("number", 1);
//        System.out.println(incr);
//        incr =redisUtil.incr("number", 1);
//        System.out.println(incr);
//
//        //=====================testMap======================
//        Map<String,Object> map=new HashMap<>();
//        map.put("name", "meepo");
//        map.put("pwd", "password");
//        redisUtil.hmset("user", map);
//        System.out.println(redisUtil.hget("user","name"));
//    }
}
