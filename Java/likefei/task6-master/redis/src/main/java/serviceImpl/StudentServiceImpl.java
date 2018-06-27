package serviceImpl;
import mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import pojo.Student;
import service.StudentService;
import utils.PojoMap;
import utils.Randomlist;
import utils.RedisUtil;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Service
public class StudentServiceImpl implements StudentService {
@Autowired
private StudentMapper studentMapper;
@Resource
private RedisUtil redisUtil;

private static final long expire = 60*60*3;

    @Override
    @SuppressWarnings("unchecked")
    public List<Student> list() {
        if (redisUtil.hasKey("studentList")){
            return (List<Student>)redisUtil.get("studentList");
        }
        else {
            redisUtil.set("studentList",studentMapper.list(),expire);
            return studentMapper.list();
            }
        }
    @Override
    public void add(Student student) {
        redisUtil.del("studentlist");
        studentMapper.add(student);
    }

    @Override
    public void delete(Integer id)  {
        studentMapper.delete(id);
    }

    @Override
    public Student get (Integer id){
        String str = id+"";
        Student student = null;
        if (redisUtil.hasKey(str)){
            try {
                return (Student)PojoMap.convertMap(Student.class,redisUtil.getCacheMap(str));
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        else {
            student = studentMapper.get(id);
            try {
                redisUtil.setCacheMap(str,PojoMap.covertBean(student));
            } catch (Exception e) {
                e.printStackTrace();
            }
//            redisUtil.hset("str","name",student.getName(),expire);
//            redisUtil.hset("str","job",student.getJob(),expire);
//            redisUtil.hset("str","school",student.getSchool(),expire);
//            redisUtil.hset("str","qq",student.getQq(),expire);
//            redisUtil.hset("str","url",student.getUrl(),expire);
            return student;
        }
    }

    @Override
    public void update(Student student)  {
        studentMapper.update(student);
    }

    @Override
    public void pinsert(List<String> list) { }

    @Override
    public Integer gettotal(){
return studentMapper.gettotal();
    }

    @Override
    public int getjavatotal() {
        return studentMapper.getjavatotal();}


    @Override
    public List<Student> random() {
        List<Student> list = studentMapper.list();
        List<Student> newlist = Randomlist.createRandomList(list,4);
        return  newlist;
    }
}


