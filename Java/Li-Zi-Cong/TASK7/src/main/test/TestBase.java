import jnshu.dao.AccountMapper;
import jnshu.dao.StudentInfoMapper;
import jnshu.dao.StudentMapper;
import jnshu.pojo.StudentInfo;
import jnshu.service.impl.StudentInfoImpl;
import jnshu.util.SerializeUtil;
import okhttp3.internal.Internal;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.Jedis;

import javax.servlet.http.Cookie;
import java.util.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application.xml")
public class TestBase {
    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private StudentInfoImpl studentInfoMapper;


//    时间戳
//    @Test
//    public  void getToken()throws Exception{
//        String input = "eee222";
//        String salt = "QWERASDF";
////        生成时间戳
//        Long timeStamp = System.currentTimeMillis() / 1000;
//
////        拼装待加密数据
//        String date = input+"/"+salt+"/"+timeStamp;
//
////        加密
//        String bytes2=DES.desEncodeCBC("qwerasdf",date);
//
////        解密
//        System.out.println(DES.desDecodeCBC("qwerasdf",bytes2));
//    }

    @Test
    public void testString() {
        String date = "qqq" + "/" + "1qw2" + "/" + "259201";
        String[] temp = date.split("/", 0);
        System.out.println(temp[2]);
        long nowTimeStamp = System.currentTimeMillis() / 1000;
        System.out.println("n:" + nowTimeStamp);
        long legalTime = 3600 * 24 * 3;
        System.out.println("l:" + legalTime);
        System.out.println("yun::" + (Long.valueOf(temp[2]) - legalTime));


    }

    String salutation = "Hello! ";

    @Test
    public void testCount() throws Exception {
//        StudentMapper studentMapper = id->
//        String ss= "ee";
//        GreetingService greetService1 = (b)->
//                System.out.println(salutation + b);
//        greetService1.sayMessage("Runoob");
    }

    interface Cache {
        List list(Set list);
    }

    @Test
    public void test2() throws Exception {
        Jedis redis = new Jedis("localhost", 6379);
        Set list = redis.keys("student//*");
        List list2 = null;
        List list3 = null;
        Cache cache = user -> {
            user.size();
            Iterator iterator = user.iterator();
            int i = 0;
            while (iterator.hasNext()) {
                String[] strings = iterator.next().toString().split("student//", 2);
                System.out.println(i + "\t" + strings[1]);
//                list3.add(i,strings[1]);
                i++;
            }
            return list2;
        };
        cache.list(list);

    }
    @Test
    public void sp() throws Exception {
        String sources = "5user12user13";
        System.out.println(sources.split("user", 6)[0]);
        System.out.println(sources.split("user", 6).length);
        String string = "key";
        int id = 12;
        String string3 = string + id;
        System.out.println(string3);
        StudentInfo studentInfo = new StudentInfo(2, "ee", 123, "java", "1024", "www", null, null, null, null, null);
        int id2 = studentInfoMapper.insertSTU(studentInfo);
        System.out.println("insert id:" + studentInfo.getId());
    }






    @Test
    public void test3() throws Exception {
        Jedis redis = new Jedis("localhost", 6379);
        Set list = redis.keys("student//*");
        Iterator iterator = list.iterator();
        int[] arr = new int[list.size()];
        int i = 0;
        while (iterator.hasNext()) {
            String[] strings = iterator.next().toString().split("student//", 2);
            System.out.println(i + "\t" + strings[1]);
            int temp = Integer.parseInt(strings[1]);
            arr[i++] = temp;
        }
        System.out.println(arr.length);
        for (int j = 0; j < arr.length - 1; j++) {
            for (int k = 0; k < (arr.length - j) - 1; k++) {
                if (arr[k] > arr[k + 1]) {
                    int temp = arr[k];
                    arr[k] = arr[k + 1];
                    arr[k + 1] = temp;
                }
            }
        }
        List list1 =new ArrayList();
        for (int a : arr) {
            System.out.println("f:" + a);
            list1.add(a);
        }
        System.out.println("eee:"+arr[11]);
        redis.set("studentList".getBytes(),SerializeUtil.serializeList(list1));
    }


    @Test
    public void setAll() throws Exception {
        Jedis redis = new Jedis("localhost", 6379);
        studentInfoMapper.listAll().forEach(i -> redis.set(new String("student//" + i.getId()).getBytes(), SerializeUtil.serialize(i)));
    }

    @Test
    public void delete() {
        Jedis redis = new Jedis("localhost", 6379);
        Set list = redis.keys("student//*");
        Iterator iterator = list.iterator();
        System.out.println(list.size());
        while (iterator.hasNext()) {
            redis.del(iterator.next().toString());

        }
    }


    @Test
    public void getKey() throws Exception {
        Jedis redis = new Jedis("localhost", 6379);
//        System.out.println(redis.keys("studentList").size());
        StudentInfo studentInfo = (StudentInfo) SerializeUtil.unserialize(redis.get("student//12".getBytes()));
        System.out.println(studentInfo.toString());
//        List list = SerializeUtil.unserializeList(redis.get("studentList").getBytes());
//        list.forEach(x-> System.out.println(x));
//        int[] list=(int[]) SerializeUtil.unserialize(redis.get("studentList".getBytes()));
//        System.out.println(list[20]);
    }

    @Test
    public void setCount() throws Exception {
        Jedis redis = new Jedis("localhost", 6379);
        System.out.println(redis.exists("student//1"));

    }


}
