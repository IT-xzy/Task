package yxpTask6.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import yxpTask6.pojo.Student;
import yxpTask6.service.StudentService;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.TimeUnit;
@Component
public class TaskRedisUtil
{

    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private StudentService studentService;
    /*
    * 所有方法包括
    *1.将数据库所有数据放入redis中；
    *2.将数据库的studyId构成的索引建立；
    * 3，更新redis，包括删除，增减，更新具体的学生数据；
    * 4.更新index，包括增加，删除；
    * 5.更新数据库，包括增加，删除，更新单条数据；
    * 6.从redis中查询单条数据；
    * 7.从redis中查询分页数据；
    * */

    /*从数据库中查询全部数据放入redis的map中
    * */
    public void creatAllStudentRedis()
    {
        //数据库查询全部的学生数据
        Map<String,Object> map=studentService.selectAllStudentMap();
        //存储的map的key为studyId；放入student的key中；
        redisTemplate.opsForHash().putAll("student",map);
        //设置过期时间
        redisTemplate.expire("student",15,TimeUnit.DAYS);

    }
    /*从数据库中查询出所有的studyId值，放入list中；
        @Return list 从数据库查询的所有studyId的index索引；
    * */
    public List creatAllIndexRedis()
    {
        List listStudyId=studentService.selectAllStudyId();
        Collections.sort(listStudyId);
        //删除以后的index
        redisTemplate.opsForList().trim("listStudyId",0,0);
        redisTemplate.opsForList().rightPop("listStudyId");
        //增加新的index；
        redisTemplate.opsForList().rightPushAll("listStudyId",listStudyId);
        redisTemplate.expire("listStudyId",15,TimeUnit.DAYS);
        List list=redisTemplate.opsForList().range("listStudyId",0,-1);
        return list;
    }
    /*从缓存中读取数据；
    @Param studyId
    @Return student数据
    * */
    public Student getByStudyIdRedis(String studyId)
    {
        Object studentObject=redisTemplate.opsForHash().get("student",studyId);
        ObjectMapper mapper = new ObjectMapper();
        Student student=mapper.convertValue(studentObject,Student.class);
        return student;
    }/*
    * 删除redis保存的学生数据；并更新index；
    * @Param student
    *
    * */
    public void deleteStudentRedis(String studyId)
    {
//        String string=null;

        //删除学生数据
        redisTemplate.opsForHash().delete("student",studyId);
        redisTemplate.expire("student",15,TimeUnit.DAYS);
        //删除list中的studyId
        redisTemplate.opsForList().remove("listStudyId",0,studyId);
        redisTemplate.expire("listStudyId",15,TimeUnit.DAYS);
//        string="delete one student from redis success";
//        return string;
    }
    /*
    * 增加redis数据
    * @Parem student 学生数据；
    **/
    public void addStudentRedis(Student student)
    {
        //增加学生数据
        redisTemplate.opsForHash().put("student",student.getStudyId(),student);
        redisTemplate.expire("student",15,TimeUnit.DAYS);
        //增加indexList
        List listStudyId=redisTemplate.opsForList().range("listStudyId",0,-1);
        listStudyId.add(student.getStudyId());
        Collections.sort(listStudyId);
        //删除listStudyId中的数据；
        redisTemplate.opsForList().trim("listStudyId",0,0);
        redisTemplate.opsForList().rightPop("listStudyId");
        //更新后的studyIdIndex放入redis中；
        redisTemplate.opsForList().rightPushAll("listStudyId",listStudyId);
        redisTemplate.expire("listStudyId",15,TimeUnit.DAYS);
    }
    /*
    * 更新缓存中的数据；
    * @Param student更新后的全部数据；
    * */
    public void updateStudentRedis(Student student)
    {
        //先删除原来redis中的student数据；
//        Student studentOld=getByStudyIdRedis(student.getStudyId());
        redisTemplate.opsForHash().delete("student",student.getStudyId());
        //放入新数据
        redisTemplate.opsForHash().put("student",student.getStudyId(),student);
        redisTemplate.expire("student",15,TimeUnit.DAYS);
    }

    /*
    * 分页缓存
    * @Param pageNum 页码数；
    * @Param pageSize 每页数量；
    * @Return 分页的学生List*/
    public List pageStudentRedis(Integer pageNum,Integer pageSize)
    {
        List<Student> listStudent=new Vector<>();
        Student student;
        List indexStudyId=redisTemplate.opsForList().range("listStudyId",0,-1);
        Integer pageStart=pageNum*pageSize-pageSize;
        Integer pageEnd=pageNum*pageSize;
        //保证请求的分页信息下标符合规则；
        if(pageStart>=0&&pageStart<indexStudyId.size())
        {
            if(pageEnd>indexStudyId.size())
                pageEnd=indexStudyId.size();
            for (int i = pageStart; i < pageEnd; i++) {
                student = getByStudyIdRedis(indexStudyId.get(i).toString());
                listStudent.add(student);
            }
        }
        return listStudent;
    }
    /*
    * 获取reids中的index的list
    * @Return list存储index的list；
    * */
    public List getAllIndexRedis()
    {
        List list=redisTemplate.opsForList().range("listStudyId",0,-1);
        return list;
    }
    /*
    * 将redis的数据写入mysql中
    * */
    public Boolean redisToMysql()
    {
        Boolean boo=false;
        //从redis中拿到全部数据；对比，存在即更新；不存在即进行插入；
        Map<String,Object> mapStudent=redisTemplate.opsForHash().entries("student");
        Student student;
        String studyId;
        ObjectMapper mapper = new ObjectMapper();
        for(Map.Entry<String,Object> map:mapStudent.entrySet())
        {
//            student=(Student)map.getValue();
            studyId=map.getKey();
            //判断数据库是否存在；
            student=studentService.selectByStudyId(studyId);
            //等于空，进行插入；
            if(student==null)
            {
                student=mapper.convertValue(map.getValue(),Student.class);
                studentService.insertStudent(student);
            }
            //不等于空，进行更新；
            student=mapper.convertValue(map.getValue(),Student.class);
            studentService.updateStudent(student);
            boo=true;
        }
        return boo;
    }
}
