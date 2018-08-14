package wyq.webapp.aspects;

import com.whalin.MemCached.MemCachedClient;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import wyq.webapp.pojo.Engineer;
import wyq.webapp.pojo.Student;
import wyq.webapp.service.StudentService;

import java.util.List;

@Component
@Aspect
public class MemcacheHelper {
    ////memcached
//    @Autowired
//    MemCachedClient memCachedClient;
//
//    @Autowired
//    StudentService studentService;
//
//    @Around("execution(* wyq.webapp.service.impl.StudentServiceImpl.*(..))")
//    public List doFindEngineerAround(ProceedingJoinPoint call) {
//        List<Student> studentList = (List<Student>)memCachedClient.get("studentList");
//        System.out.println(studentList);
//
//        if(studentList != null) {
//            System.out.println("从缓存中读取！studentList" + studentList );
//        } else {
//            try {
//                studentList = (List<Student>)call.proceed();
//            } catch (Throwable e) {
//                e.printStackTrace();
//            }
//            if (studentList != null) {
//                memCachedClient.add("studentList", studentList);
//                System.out.println("缓存加入:" + studentList );
//            }
//
//        }
//
//        return studentList;


    //redis
    @Autowired
    RedisTemplate redisTemplate;

    @Around("execution(* wyq.webapp.service.impl.EngineerServiceImpl.*(..))")
    public List doFindEngineer(ProceedingJoinPoint call){
        List<Student> studentList = (List<Student>)redisTemplate.opsForValue().get("engineerList");
        System.out.println(studentList);

        if (studentList != null) {
            System.out.println("从缓存中读取！engineerList" + studentList);
        } else {
            try {
                studentList = (List<Student>)call.proceed();
            } catch (Throwable e) {
                e.printStackTrace();
            }
            if (studentList != null) {
                redisTemplate.opsForValue().set("engineerList",studentList);
                System.out.println("缓存加入:" + studentList );
            }

        }

        return studentList;
    }

}
