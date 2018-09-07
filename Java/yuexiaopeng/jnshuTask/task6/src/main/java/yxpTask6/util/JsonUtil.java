package yxpTask6.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import yxpTask6.pojo.Student;
import yxpTask6.service.StudentService;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Vector;

@Component
public class JsonUtil
{
    @Autowired
    StudentService studentService;
    @Autowired
    TaskMemcachedUtil taskMemcachedUtil;
    @Autowired
    TaskRedisUtil taskRedisUtil;
    /*
    * 从数据库查询json数据；
    * @Param 传入的studyId
    * @Return 查询后的学生数据map*/
    public Map studentJson(Map map)
    {
        Student student;
//        System.out.println(map);
        String stringIndex=map.get("studyId").toString();
        //将studyId字符串转为字符数组
        String[] arrayStr=stringIndex.split(",");
        List listIndex= Arrays.asList(arrayStr);
//        System.out.println(listIndex);
//        List<Student> listStudent=new Vector<>();
        for(int i=0;i<listIndex.size();i++)
        {
            student = studentService.selectByStudyId(listIndex.get(i).toString());
//            listStudent.add(i,student);
            map.put("studyId : "+listIndex.get(i).toString(),student);
        }
        return map;
    }
        /*
         * 从数据库查询json数据；
         * @Param 传入的studyId
         * @Return 查询后的学生数据map*/
        public Map redisJson(Map map)
        {
            Student student;
    //        System.out.println(map);
            String stringIndex=map.get("studyId").toString();
            String[] arrayStr=stringIndex.split(",");
            List listIndex= Arrays.asList(arrayStr);
    //        System.out.println(listIndex);
    //        List<Student> listStudent=new Vector<>();
            for(int i=0;i<listIndex.size();i++)
            {
                student = taskRedisUtil.getByStudyIdRedis(listIndex.get(i).toString());
                map.put("studyId : "+listIndex.get(i).toString(),student);
            }
            return map;
        }
    /*
     * 从数据库查询json数据；
     * @Param 传入的studyId
     * @Return 查询后的学生数据map*/
    public Map memcachedJson(Map map)
    {
        Student student=new Student();
//        System.out.println(map);
        String stringIndex=map.get("studyId").toString();
        String[] arrayStr=stringIndex.split(",");
        List listIndex= Arrays.asList(arrayStr);
//        System.out.println(listIndex);
//        List<Student> listStudent=new Vector<>();
        for(int i=0;i<listIndex.size();i++)
        {
            student = taskMemcachedUtil.getStudentMemcache(listIndex.get(i).toString());
            map.put("studyId : "+listIndex.get(i).toString(),student);
        }
        return map;
    }
}
