import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import spring.dao.StudentDao;
import spring.model.Student;

import java.util.List;

public class Test1 {
    public static void main(String[] args){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        RedisTemplate redisTemplate = applicationContext.getBean(RedisTemplate.class);
        StudentDao studentDao = applicationContext.getBean(StudentDao.class);

//        List<Student> students = studentDao.getGood();
//        redisTemplate.opsForValue().set("key1", students);
//        List<Student> students1 = (List<Student>) redisTemplate.opsForValue().get("key1");
//        for (Student student:students1) {
//            System.out.println(student);
//        }

//        redisTemplate.opsForValue().set("key1","我是key1");
//        redisTemplate.opsForValue().set("key2","我是key2");
//        System.out.println(redisTemplate.opsForValue().get("key1"));
//        System.out.println(redisTemplate.opsForValue().get("key2"));
//        redisTemplate.delete("key2");
//        System.out.println(redisTemplate.opsForValue().get("key1"));
//        System.out.println(redisTemplate.opsForValue().get("key2"));
//        System.out.println("key1长度:"+redisTemplate.opsForValue().size("key1"));
//        //设置新值返回旧值
//        System.out.println(redisTemplate.opsForValue().getAndSet("key1","这是新值"));
//        System.out.println("设置后key1的值:"+redisTemplate.opsForValue().get("key1"));
//        System.out.println(redisTemplate.opsForValue().get("key1",7,9));
//        System.out.println("追加字符串到末尾返回长度："+redisTemplate.opsForValue().append("key1","嘿嘿嘿"));
//        String a = (String)redisTemplate.opsForValue().get("key1");
//        System.out.println(a);

    }
}
