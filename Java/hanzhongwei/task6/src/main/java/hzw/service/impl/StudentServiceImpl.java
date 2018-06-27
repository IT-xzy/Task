package hzw.service.impl;

import hzw.mapper.StudentMapper;
import hzw.model.Student;
import hzw.service.StudentService;
import hzw.util.MemcacheUtil;
import hzw.util.RedisUtil;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class StudentServiceImpl implements StudentService {

    private static org.slf4j.Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);

    @Autowired
    StudentMapper studentMapper;
    @Autowired
    RedisUtil redisUtil;

    @Override
    public Student findIdStudent(Integer id) {
        return studentMapper.findIdStudent(id);
    }

    /*@Override
    public Student getID(Long id) {
        Student student;
        if (MemcacheUtil.get("sName"+id) != null) {
            student = (Student) MemcacheUtil.get("sName"+id);
            System.out.println("这是缓存中的数据");
            return student;
        }else {
            student = studentMapper.getID(id);
                //如果查询数据库不为空，将数据写入缓存中
                MemcacheUtil.set("sName"+id,student);
                return student;

        }
    }*/

//    @Override
//    public Student getID(Long id) {
//        Student student;
//        if (redisUtil.get("sName"+id) != null) {
//            Long a = System.currentTimeMillis();
//            student = (Student) redisUtil.get("sName"+id);
//            Long b = System.currentTimeMillis();
//            Long c = b-a;
//            System.out.println("这是缓存中的数据,取出时间为："+c+"ms");
//            return student;
//        }else {
//            student = studentMapper.getID(id);
//            if (studentMapper.getID(id) != null) {
//                //如果查询数据库不为空，将数据写入缓存中
//                redisUtil.set("sName"+id,student);
//                return student;
//            }else {
//                //如果查询数据为空，将该值写入缓存中，设计一个很短的失效时间
//                redisUtil.set("sName"+id,student,60);
//                return student;
//            }
//        }
//    }

    @Override
    public Student getID(Long id) {
        return (Student) redisUtil.get("sName"+id);
    }

    @Override
    public Student getID1(Long id) {
                return studentMapper.getID(id);
    }

    //插入数据时，不涉及缓存操作
    @Override
    public Integer insertStudent(Student student) {
        student.setCreate_at(System.currentTimeMillis());
        student.setUpdate_at(System.currentTimeMillis());
        return studentMapper.insertStudent(student);
    }

    //数据库删除后，删除缓存，等待下次请求时更新缓存
    @Override
    public Integer deleteStudent(Integer id) {
        studentMapper.deleteStudent(id);
        redisUtil.del("sName"+id);
        return studentMapper.deleteStudent(id);
    }

    //先更新数据库，然后删除缓存，等待下次请求时更新缓存
    @Override
    public Integer updateStudent(Student student) {
        student.setUpdate_at(System.currentTimeMillis());
        Integer a = studentMapper.updateStudent(student);
        redisUtil.del("sName"+student.getsId());
        return a;
    }

    @Override
    public List<Student> findListStudent() {
        List<Student> students;

        if (redisUtil.get("sStudent") != null) {
            students = (List<Student>) redisUtil.get("sStudent");
            logger.info("这是从缓存里取出来的数据"+students+"================");
            return students;
        }else {
            students = studentMapper.findListStudent();
            boolean isSuccess = redisUtil.set("sStudent",studentMapper.findListStudent());
            logger.info("放入缓存是否成功：" + isSuccess);
            return students;
        }
    }

    @Override
    public List<Student> findListStudent1(){
        return studentMapper.findListStudent();
    }

    @Override
    public List<Student> findNameStudent(String name) {
        return studentMapper.findNameStudent(name);
    }
}
